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


    @PostMapping("/hidden/api/insert/trains")
    void insertTrains() throws SQLException {
        TrainService trainService = new TrainService();
//        trainService.insertDataIntoTrainTable();
        trainService.insertDataIntoTrainTableFromFile();
    }
}
