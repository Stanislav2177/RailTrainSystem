package com.university.project.railTrainSystem.engine.trains;

import com.university.project.railTrainSystem.engine.setgraph.SettingGraph;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrainService {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/rail_train_system";
    static final String USER = "root";
    static final String PASS = "34153";

    static final String fileName = "city-connection.txt";

    private static Connection connection = null;
    private static PreparedStatement pstmt = null;


//    public static String[] vertices = SettingGraph.vertices;

    @Transactional
    public void insertDataIntoTrainTable(String[] vertices) throws SQLException {
        try {
            // SQL statement for insertion
            String sql = "INSERT INTO train (city_start, city_end) VALUES (?, ?)";

            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Prepare the statement
            pstmt = connection.prepareStatement(sql);

            // Insert each pair of cities into the table
            for (int i = 0; i < vertices.length - 1; i++) {
                pstmt.setString(1, vertices[i]);
                pstmt.setString(2, vertices[i + 1]);
                pstmt.executeUpdate();
            }
        } finally {
            // Close resources
            if (pstmt != null) {
                pstmt.close();
            }
        }
    }

    public void insertDataIntoTrainTableFromFile() throws SQLException {
        List<String> verticies = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line by comma to get the two cities
                String[] cities = line.split(",");
                if (cities.length == 2) {
                    String cityStart = cities[0].trim(); // First city
                    String cityTwo = cities[1].trim(); // Second city

                    verticies.add(cityStart);
                    verticies.add(cityTwo);
//                    System.out.println("City Start: " + cityStart + ", City Two: " + cityTwo);
                    // You can process the cities here as needed
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }


        insertDataIntoTrainTable(verticies.toArray(String[]::new));
    }


    public List<Train> checkForAvailableTrain(String cityStart) throws SQLException {
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        String sql = "SELECT * FROM train WHERE city_start = ?";
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, cityStart);
        ResultSet rs = pstmt.executeQuery();

        List<Train> availableTrains = new ArrayList<>();
        Train train;
        while (rs.next()) {
            train = new Train();
            train.setId(rs.getInt(1));
            train.setCityStart(rs.getString(2));
            train.setCityEnd(rs.getString(3));
            train.setStart(rs.getTime(4)); // Adjusted to getTime() for TIME data type
            train.setFinish(rs.getTime(5)); // Adjusted to getTime() for TIME data type
            train.setType(rs.getString(6));
            train.setProblem(rs.getBoolean(7)); // Directly get as boolean
            availableTrains.add(train);
        }

        System.out.println(availableTrains.get(0).getId());

        // It seems you want to return the list of available trains, so you might want to return availableTrains here
        return availableTrains;
    }

}
