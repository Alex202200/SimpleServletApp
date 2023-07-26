package alex.mvc.controller;


import java.sql.*;


public class DBConnection {
    private static final String URL = "jdbc:postgresql://192.168.1.87:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "05051987";


    public static void main(String[] args) {
        createTable();
    }

    public static void createTable() {
        String sql = "CREATE TABLE users ("
                + "id SERIAL PRIMARY KEY,"
                + "first_name VARCHAR(50),"
                + "last_name VARCHAR(50),"
                + "age INTEGER"
                + ")";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Table 'users' was created");
        } catch (SQLException e) {
            System.out.println("Ошибка при создании таблицы: " + e.getMessage());
        }
    }

    public static Connection  getConnection () throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


}
