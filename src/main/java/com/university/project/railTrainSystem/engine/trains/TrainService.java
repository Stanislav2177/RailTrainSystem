package com.university.project.railTrainSystem.engine.trains;

import com.university.project.railTrainSystem.engine.setgraph.SettingGraph;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class TrainService {


    public static String[] vertices = SettingGraph.vertices;

    @Transactional
    public void insertDataIntoTrainTable(Connection conn) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            // SQL statement for insertion
            String sql = "INSERT INTO train (city_start, city_end) VALUES (?, ?)";

            // Prepare the statement
            pstmt = conn.prepareStatement(sql);

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
}
