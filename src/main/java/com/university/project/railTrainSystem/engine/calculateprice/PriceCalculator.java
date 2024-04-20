package com.university.project.railTrainSystem.engine.calculateprice;

import com.university.project.railTrainSystem.engine.setgraph.SettingGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.List;

public class PriceCalculator {
    final double CENT_PER_KILOMETER = 0.10;
    private final SettingGraph graph = new SettingGraph();

    public double getPriceBetweenTwoStations(String startStation, String finalStation){
        List<DefaultWeightedEdge> shortestPathEdges = graph.findShortestPathEdges(startStation, finalStation);
        double v = graph.calculateWeightBetweenTwoPaths(shortestPathEdges);

        System.out.println("weight " + v);

        return v*CENT_PER_KILOMETER;
    }
}
