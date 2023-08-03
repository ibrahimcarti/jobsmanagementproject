/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.denemeproject.DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ibrahim
 */
public class DbHelper {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/myexmpl?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "12345";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
