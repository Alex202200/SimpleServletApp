package alex.mvc.controller;


import java.sql.*;

import static alex.mvc.controller.DBConnection.getConnection;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://192.168.1.87:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "05051987";


    public static void main(String[] args) {
        testConnection();
    }

    public static Connection  getConnection () throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


    public static boolean testConnection () {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT 1");
            if (resultSet.next()) {
                System.out.println("Connection to the database established successfully.");
                return true;
            } else {
                System.out.println("Failed to establish connection to the database.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error while testing the database connection: " + e.getMessage());
            return false;
        }
    }

}
