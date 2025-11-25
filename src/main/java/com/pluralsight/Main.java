package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            if (args.length != 2){
                System.out.println("Password and username needed");
                System.exit(1);
            }

            String username = args[0];
            String password = args[1];


            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world",
                    username,
                    password
            );

//        Statement statement = connection.createStatement();
//
//        String query = """
//                SELECT NAME
//                FROM CITY\s
//                WHERE COUNTRYCODE = "USA"
//               \s""";
//        ResultSet results = statement.executeQuery(query);
//        while (results.next()) {
//            String name = results.getString("Name"); // By column name
//            System.out.println("City: " + name);
//        }
//

            String country = "Usa";

            String query = "Select name from city where countrycode = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, country);
            ResultSet results = statement.executeQuery();

            while (results.next()) {
                String name = results.getString("Name"); // By column name
                System.out.println("City: " + name);
            }

            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
