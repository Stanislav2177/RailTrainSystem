package com.university.project.railTrainSystem.engine.trains;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Only for insertions

@RestController
public class TrainController {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/rail_train_system";
    static final String USER = "root";
    static final String PASS = "34153";


    @PostMapping("/hidden/api/insert/trains")
    void insertTrains() throws SQLException {
        TrainService trainService = new TrainService();
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        trainService.insertDataIntoTrainTable(connection);
    }
}
