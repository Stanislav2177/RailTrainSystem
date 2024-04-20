package com.university.project.railTrainSystem.testengine;

import com.university.project.railTrainSystem.engine.calculateprice.*;
import com.university.project.railTrainSystem.engine.railways.CheckTheGraphInWhichRailStationPairs;
import com.university.project.railTrainSystem.engine.setgraph.SettingGraph;
import com.university.project.railTrainSystem.engine.trains.TrainService;
import com.university.project.railTrainSystem.entity.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEngine {
    PriceCalculator calculator = new PriceCalculator();
    SettingGraph graph = new SettingGraph();
    TrainService trainService = new TrainService();

    TicketPriceCalculator ticketPriceCalculator = new TicketPriceCalculator();


    @Test
    void testCalculator(){
        double priceBetweenTwoStations = calculator.getPriceBetweenTwoStations("Mezdra", "Karlovo");
        System.out.println("price = " + priceBetweenTwoStations);
    }
    @Test
    void testCheckForAvailableTrain() throws SQLException {
        String cityStart = "Sofia";
        trainService.checkForAvailableTrain(cityStart);
    }


    @Test
    void testGetATicket() throws SQLException {
        Ticket aTicket = ticketPriceCalculator.getATicket("Mezdra", "Karlovo");
        System.out.println(aTicket.toString());
    }

    @Test
    void CheckTheGraphInWhichRailStationPairs1(){
        CheckTheGraphInWhichRailStationPairs test = new CheckTheGraphInWhichRailStationPairs();
        String shortestPath = graph.findShortestPath("Sofia", "Varna");
        graph.separateTheWholeTraceToListOfStrings(shortestPath);
//        test.getTheRailStation(defaultWeightedEdges);
    }
    @Test
    void CheckTheGraphInWhichRailStationPairs2(){
        CheckTheGraphInWhichRailStationPairs test = new CheckTheGraphInWhichRailStationPairs();
        String shortestPath = graph.findShortestPath("Ruse", "Podkova");
        Set<String> stringSet = graph.separateTheWholeTraceToListOfStrings(shortestPath);
       test.getTheRailStation(stringSet);
    }
    @Test
    void CheckTheGraphInWhichRailStationPairs3(){
        CheckTheGraphInWhichRailStationPairs test = new CheckTheGraphInWhichRailStationPairs();
        String shortestPath = graph.findShortestPath("Mezdra", "Vidin");
        graph.separateTheWholeTraceToListOfStrings(shortestPath);
//        test.getTheRailStation(defaultWeightedEdges);
    }
    @Test
    void CheckTheGraphInWhichRailStationPairs4(){
        CheckTheGraphInWhichRailStationPairs test = new CheckTheGraphInWhichRailStationPairs();
        String shortestPath = graph.findShortestPath("Plovdiv", "Burgas");
        graph.separateTheWholeTraceToListOfStrings(shortestPath);
//        test.getTheRailStation(defaultWeightedEdges);
    }


    @Test
    void getFinalPrice() throws SQLException {
        User user = new User();
        user.setUserId(1L);

        CalculateFinalPrice calculateFinalPrice = new CalculateFinalPrice();
        double finalPrice = calculateFinalPrice.getFinalPrice("Mezdra", "Karlovo", user);

        System.out.println(finalPrice);
    }

}
