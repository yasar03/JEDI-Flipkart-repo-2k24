package com.flipfit.DAO;

import com.flipfit.bean.Customer;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.User;
import com.flipfit.constants.SQLConstants;
import com.flipfit.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
	
	/**
	 * Authenticates the user based on the email and password
	 * @param user the user object containing email and password
	 * @return true if the user is authenticated else returns false
	 */
	public boolean authenticateUser(User user){
		// to run without authentication, make isUserValid = true
		Connection connection = null;
		
		boolean isUserValid = false;
		try {connection = DBUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.SQL_SELECT_USER_LOGIN_CREDENTIAL); 

			preparedStatement.setString(1, user.getEmail());

			ResultSet rs = preparedStatement.executeQuery();
//			if(!rs.next()) {
//				throw new UnauthorizedAccessException("User not found");
//			}
			while (rs.next()) {
				if (user.getPassword().equals(rs.getString("password"))
						&& user.getRoleId().equalsIgnoreCase(rs.getString("role"))) {
					System.out.println(
							rs.getString("email") + " " + rs.getString("password") + " " + rs.getString("role"));
					isUserValid = true;
				}
			}

		} catch (SQLException e) {
			printSQLException(e);
		}

		return isUserValid;
	}
	
	/**
	 *
	 * @param customer the customer object to be registered
	 * @return true if the customer is registered successfully else returns false
	 */
	public boolean registerCustomer(Customer customer) {
		Connection connection = null;
		boolean registerSuccess = false;
		String query = "INSERT INTO customer VALUES (?,?,?,?,?)";
		String queryUser = "INSERT INTO user VALUES (?,?,?)";
		try {connection = DBUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				PreparedStatement preparedStatementUser = connection.prepareStatement(queryUser);

			preparedStatement.setString(1, customer.getEmail());
			preparedStatement.setString(2, customer.getName());
			preparedStatement.setString(3, customer.getPhoneNumber());
			preparedStatement.setInt(4, customer.getAge());
			preparedStatement.setString(5, customer.getAddress());

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected != 0)
				registerSuccess = true;

			preparedStatementUser.setString(1, customer.getEmail());
			preparedStatementUser.setString(2, customer.getPassword());
			preparedStatementUser.setString(3, "GymCustomer");

			rowsAffected = preparedStatementUser.executeUpdate();
			if (rowsAffected != 0)
				registerSuccess = true;

		} catch (SQLException e) {
			printSQLException(e);
		}

		return registerSuccess;
	}
	
	/**
	 *
	 * @param gymOwner the gym owner object to be registered
	 * @return true if the gym owner is registered successfully else returns false
	 */
	public boolean registerGymOwner(GymOwner gymOwner) {
		Connection connection = null;
		boolean registerSuccess = false;
		String query = "INSERT INTO gymOwner VALUES (?,?,?,?,?,?)";
		String queryOwner = "INSERT INTO user VALUES (?,?,?)";
		try {connection = DBUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				PreparedStatement preparedStatementOwner = connection.prepareStatement(queryOwner);

			preparedStatement.setString(1, gymOwner.getEmail());
			preparedStatement.setString(2, gymOwner.getName());
			preparedStatement.setString(3, gymOwner.getPhoneNumber());
			preparedStatement.setString(4, gymOwner.getAadharNumber());
			preparedStatement.setString(5, gymOwner.getPanNumber());
			preparedStatement.setBoolean(6, gymOwner.isVerified());

			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected != 0)
				registerSuccess = true;

			preparedStatementOwner.setString(1, gymOwner.getEmail());
			preparedStatementOwner.setString(2, gymOwner.getPassword());
			preparedStatementOwner.setString(3, "GymOwner");

			rowsAffected = preparedStatementOwner.executeUpdate();
			if (rowsAffected != 0)
				registerSuccess = true;

		} catch (SQLException e) {
			printSQLException(e);
		}

		return registerSuccess;
	}
	
	/**
	 *
	 * @param email the email of the user whose password needs to be updated
	 * @param password the new password
	 * @return true if the password is updated successfully else returns false
	 */
	public boolean updatePassword(String email, String password) {
		Connection connection = null;
		String query = "UPDATE user SET password = ? WHERE email = ?";
		try {connection = DBUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, password);
			preparedStatement.setString(2, email);

			return preparedStatement.executeUpdate()==1;
			

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