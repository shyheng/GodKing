package com.shy.godking.jdbc;

import java.sql.*;

public class DBConnection {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://120.77.255.179:3306/godking?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf8",
                "root","1234");
    }

    public static void colse(ResultSet resultSet , PreparedStatement ps ,Connection connection){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
