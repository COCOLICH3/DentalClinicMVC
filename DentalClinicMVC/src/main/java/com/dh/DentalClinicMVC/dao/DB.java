package com.dh.DentalClinicMVC.dao;

import java.sql.*;

public class DB {

    private static final String DRIVER =  "org.h2.Driver";
    private static final String URL = "jdbc:h2:./dc";
    private static final String USER = "sa";
    private static final String PASSWORD = "sa";

    public static Connection getConnection() throws Exception {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void createTables() throws Exception {
        Connection connection =  null;
        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

