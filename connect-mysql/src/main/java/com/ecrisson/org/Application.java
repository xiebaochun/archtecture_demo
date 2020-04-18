package com.ecrisson.org;

import java.sql.*;

public class Application {
    static PreparedStatement preparedStatement = null;
    static Connection conn = null;

    public static void main(String[] args) {
        try{
            log("---- simple JDBC connection");
            makeJDBCConnection();

            log("\n------ Adding company 'user' to DB -----");

            addDataToDB("xiaohong", 26, "she is a girl");

            log("\n------ Let's get Data from DB --------");
            getDataFromDB();

            preparedStatement.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConn() {
        try{
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void makeJDBCConnection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            log("Congrats - Seems your MySQL JDBC Driver Registered!");

        } catch (ClassNotFoundException e) {
            log("Sorry, couldn't found JDBC driver. Make soure you have added JDBC ");
            e.printStackTrace();
            return;
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql://10.120.19.22:3306/demo", "admin", "MyNewPass4!");
            if(conn != null) {
                log("Connection Successful! Enjoy. Now it's time to push data to your DB");
            } else {
                log("Failed to make connection!");
            }
        } catch (SQLException e) {
            log("MySQL Connnection Failed!");
            e.printStackTrace();
            return;
        }
    }

    public static void addDataToDB(String userName, Integer age, String description) {
        try {
            String insertQueryStatement = "INSERT INTO user (username, age, description) VALUES (?,?,?)";
            preparedStatement = conn.prepareStatement(insertQueryStatement);
            preparedStatement.setString(1, userName);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, description);
            preparedStatement.executeUpdate();
            log(userName + " added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getDataFromDB() {
        String result = "";
        try {
            String getSqueryStatement = "SELECT * FROM user";
            preparedStatement = conn.prepareStatement(getSqueryStatement);
            ResultSet rs = preparedStatement.executeQuery();

            Boolean isFinish = rs.next();

            while(isFinish) {
                isFinish = rs.next();
                if(!isFinish) break;
                log("is finish " + isFinish.toString());
                String userName = rs.getString("username");
                Integer age = rs.getInt("age");
                String desc = rs.getString("description");
                System.out.format("%s,%s,%s\n", userName, age, desc);
                result += userName + " " + age.toString() + " " + desc;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static void log(String string) {
        System.out.println(string);
    }
}
