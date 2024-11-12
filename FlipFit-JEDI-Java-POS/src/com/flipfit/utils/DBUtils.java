/**
 * 
 */
package com.flipfit.utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 */
public class DBUtils {
private static Connection connection = null;
	
	public static Connection getConnection() {
		
        if (connection != null)
            return connection;
        else {
            try {
            	Properties prop = new Properties();
                //InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("./config.properties");
            	FileInputStream fileInputStream = new FileInputStream("/Users/yasar.bains/Downloads/JEDI-2.0-Flipkart-Development-main/FlipFit-JEDI-Java-POS-2/src/config.properties");
                prop.load(fileInputStream);
                //String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                //Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }
}
