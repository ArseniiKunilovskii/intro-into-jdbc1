package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/world",
                "root",
                "yearup"
        );

        Statement statement = connection.createStatement();

        String query = """
                SELECT NAME
                FROM CITY\s
                WHERE COUNTRYCODE = "USA"
               \s""";
        ResultSet results = statement.executeQuery(query);
        while (results.next()) {
            String name = results.getString("Name"); // By column name
            System.out.println("City: " + name);
        }

        connection.close();
    }
}
