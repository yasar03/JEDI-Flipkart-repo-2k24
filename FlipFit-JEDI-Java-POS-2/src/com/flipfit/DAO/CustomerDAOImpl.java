package com.flipfit.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipfit.bean.Gym;
import com.flipfit.exception.*;
import com.flipfit.utils.DBUtils;

public class CustomerDAOImpl implements CustomerDAO{

	public List<Gym> fetchGymList() throws GymNotFoundException{
		Connection connection = null;
		List<Gym> gyms = new ArrayList<Gym>();
		String query = "select gymId, gymName, ownerEmail, address, slotCount, seatsPerSlotCount, isVerified from gym";
		try {connection = DBUtils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement statement = connection.prepareStatement(query);
			System.out.println(statement);
			// Step 3: Execute the query or update query
			ResultSet rs = statement.executeQuery();
			
//			if(!rs.next()) {
//				throw new GymNotFoundException("No gyms found");
//			}
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				Gym gym = new Gym();
				gym.setGymId(rs.getString("gymId"));
				gym.setGymName(rs.getString("gymName"));
				gym.setOwnerEmail(rs.getString("ownerEmail"));
				gym.setAddress(rs.getString("address"));
				gym.setSlotCount(rs.getInt("slotCount"));
				gym.setSeatsPerSlotCount(rs.getInt("seatsPerSlotCount"));
				gym.setVerified(rs.getBoolean("isVerified"));
				gyms.add(gym);
//	                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
//		System.out.println(gyms);
		return gyms;
		
	}

	public void fetchSlotList(String gymId) throws GymNotFoundException, NoSlotsFoundException {
		Connection connection = null;
		String query = "Select * From Slot Where gymId=?";
		try {connection = DBUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(query);
			System.out.println(statement);
			statement.setString(1, gymId);
			ResultSet output = statement.executeQuery();
			if (!output.next()) {
				throw new GymNotFoundException("No gym found");
			}
			boolean slotsFound = false;
			
			System.out.println("SlotId \t Capacity \t SlotTime \t GymId");
			do {
				System.out.printf("%-7s\t", output.getString(1));
				System.out.printf("  %-9s\t", output.getString(6));
				System.out.printf("  %-9s\t", output.getString(3));
				System.out.printf("  %-9s\t", output.getString(2));
				System.out.println("");
				slotsFound = true;
			} while (output.next());
			if (!slotsFound) {
				throw new NoSlotsFoundException("No slots found");
			}
			System.out.println("-----------------------------------------------");
		} catch (SQLException sqlExcep) {
			printSQLException(sqlExcep);
		}
	}

	public void fetchBookedSlots(String email) {
		Connection connection = null;
		String query = "Select * From Booking where customerEmail = ?";
		try {connection = DBUtils.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
		
			statement.setString(1, email);
			ResultSet output = statement.executeQuery();
			System.out.println("BookingId \t Date \t    GymId");
			while (output.next()) {
				System.out.printf("%-12s\t", output.getString(1));
				System.out.printf("  %-7s\t", output.getString(5));
				System.out.printf("%-8s\t", output.getString(3));
				System.out.println("");
			}
			System.out.println("-----------------------------------------------");
		} catch (SQLException sqlExcep) {
			printSQLException(sqlExcep);
		}
	}
	
	public void bookSlots(String bookingId, String slotId, String gymId, String type, String date, String customerEmail) throws GymNotFoundException {
		Connection connection = null;
		String query = "INSERT INTO Booking (bookingId,slotId,gymId,type,date,customerEmail) values(?, ?, ?,?, ?, ?)";
		try {connection = DBUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, bookingId);
			statement.setString(2, slotId);
			statement.setString(3, gymId);
			statement.setString(4, type);
			statement.setString(5, date);
			statement.setString(6, customerEmail);
			int output = statement.executeUpdate();
			if(output == 0) {
				throw new GymNotFoundException("Gym not found");
			}
			System.out.println("Slot Booked Successfully, your booking ID is: "+bookingId);
			System.out.println("-----------------------------------------------");
		} catch (SQLException sqlExcep) {
			printSQLException(sqlExcep);
		}
	}
	
	public void makePayment(String paymentId, String cardNumber, String cvv, String expiryDate, String upiId, String email) {
		Connection connection = null;
		String query = "INSERT INTO Payments (paymentId,cardNumber,cvv,expiryDate,upiId, email) values(?, ?, ?,?, ?, ?)";
		try {connection = DBUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, paymentId);
			statement.setString(2, cardNumber);
			statement.setString(3, cvv);
			statement.setString(4, expiryDate);
			statement.setString(5, upiId);
			statement.setString(6, email);
			int output = statement.executeUpdate();
			System.out.println("Payment Successful");
			System.out.println("-----------------------------------------------");
		} catch (SQLException sqlExcep) {
			printSQLException(sqlExcep);
		}
	}
	
	public void editProfile(String email, String name, String phoneNumber, int age, String address) {
		Connection connection = null;
		String query = "Update Customer set name=?, phoneNumber=?, age=?, address=? where email=?";
		try {connection = DBUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, phoneNumber);
			statement.setInt(3, age);
			statement.setString(4, address);
			statement.setString(5, email);
			int output = statement.executeUpdate();
			System.out.println("Profile updated successfully");
			System.out.println("-----------------------------------------------");
		} catch (SQLException sqlExcep) {
			printSQLException(sqlExcep);
		}
	}

	public boolean isFull(String slotId, String date) {
		Connection connection = null;
		String query = "Select * slot where slotId=? and (numOfSeatsBooked>=numOfSeats)";
		try {connection = DBUtils.getConnection(); 
		PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, slotId);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();
			return rs.next();
		} catch (SQLException e)
		{
			printSQLException(e);
		}

		return false;
	}

	public boolean alreadyBooked(String slotId, String email, String date) {
		Connection connection = null;
		String query = "select isVerified from Booking where slotId=? and customerEmail =  ?";
		try {connection = DBUtils.getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, slotId);
			preparedStatement.setString(2, email);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			return rs.next();
		} catch (SQLException e) {
			printSQLException(e);
		}

		return false;
	}

	public void cancelBooking(String bookingId, String email) {
		Connection connection = null;
		String query = "Delete from Booking where bookingId = ?";
		try {connection = DBUtils.getConnection(); PreparedStatement statement = connection.prepareStatement(query);
//			statement.setString(1, email);
			statement.setString(1, bookingId);
//			statement.setString(3, date);
			statement.executeUpdate();
			System.out.println("Your booking has been cancelled");
			System.out.println("-----------------------------------------------");
		} catch (SQLException sqlExcep) {
			printSQLException(sqlExcep);
		}
	}

	public boolean checkSlotExists(String slotId, String gymId) {
		Connection connection = null;
		String query = "select isVerified from slot where slotId=? and gymId =  ?";
		try {connection = DBUtils.getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, slotId);
			preparedStatement.setString(2, gymId);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			return rs.next();
		} catch (SQLException e) {
			printSQLException(e);
		}

		return false;
	}

	public boolean checkGymApprove(String gymId) {
		Connection connection = null;
		String query = "select isVerified from gym where gymId =  ?";
		try {connection = DBUtils.getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, gymId);
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			return rs.next();
		} catch (SQLException e) {
			printSQLException(e);
		}

		return false;
	}

	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}