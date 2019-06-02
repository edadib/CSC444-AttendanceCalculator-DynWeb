package meylis.connection;

import java.sql.*;

public class StaffConnection {

    static Connection con;

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_USER = "ATTENDANCES";
	private static final String DB_PASSWORD = "1234";
	
    public static Connection getConnection() {

        try {

            Class.forName(DB_DRIVER);

            try {
                con = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
                System.out.println("connected");

            }

            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return con;
    }
}
