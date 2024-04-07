package com.university.project.railTrainSystem.testengine;

import com.university.project.railTrainSystem.engine.calculateprice.PriceCalculator;
import com.university.project.railTrainSystem.engine.railways.CheckTheGraphInWhichRailStationPairs;
import com.university.project.railTrainSystem.engine.setgraph.SettingGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.Stack;

public class TestEngine {
    PriceCalculator calculator = new PriceCalculator();
    SettingGraph graph = new SettingGraph();


    @Test
    void testCalculator(){
        double priceBetweenTwoStations = calculator.getPriceBetweenTwoStations("Mezdra", "Karlovo");
        System.out.println(priceBetweenTwoStations);
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
}
