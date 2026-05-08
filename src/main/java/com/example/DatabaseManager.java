package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

public class DatabaseManager {

    private Connection connection;

    // Підключення до БД
    public DatabaseManager(String propertiesFile) {

        try {

            Properties properties = new Properties();

            FileInputStream fis =
                    new FileInputStream(propertiesFile);

            properties.load(fis);

            String url =
                    properties.getProperty("db.url");

            String user =
                    properties.getProperty("db.user");

            String password =
                    properties.getProperty("db.password");

            connection =
                    DriverManager.getConnection(
                            url,
                            user,
                            password
                    );

            System.out.println("Підключення до БД успішне!");
        }
        catch (IOException e) {

            System.out.println(
                    "Помилка читання properties: "
                            + e.getMessage()
            );
        }
        catch (SQLException e) {

            System.out.println(
                    "Помилка підключення до БД: "
                            + e.getMessage()
            );
        }
    }

    // INSERT телефону в БД
    public void insertPhone(Phone phone) {

        String sql =
                "INSERT INTO phones " +
                        "(type, brand, model, price, storage) " +
                        "VALUES (?, ?, ?, ?, ?)";

        try {

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(
                    1,
                    phone.getClass().getSimpleName()
            );

            statement.setString(
                    2,
                    phone.getBrand()
            );

            statement.setString(
                    3,
                    phone.getModel()
            );

            statement.setDouble(
                    4,
                    phone.getPrice()
            );

            statement.setInt(
                    5,
                    phone.getStorage()
            );

            statement.executeUpdate();

            System.out.println(
                    "Телефон збережено в БД!"
            );
        }
        catch (SQLException e) {

            System.out.println(
                    "Помилка INSERT: "
                            + e.getMessage()
            );
        }
    }
}