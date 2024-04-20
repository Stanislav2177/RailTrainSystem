package com.university.project.railTrainSystem.testgraph;


import com.university.project.railTrainSystem.engine.setgraph.SettingGraph;
import org.jgrapht.traverse.DepthFirstIterator;
import org.junit.jupiter.api.Test;

import java.util.Deque;

public class TestGraph {

    SettingGraph settingGraph = new SettingGraph();

    @Test
    void printAllEdges() {
        settingGraph.addingVertexToGraph();
        settingGraph.settingEdgesForEachVertex();

        settingGraph.getGraph().edgeSet().forEach(edge -> {
            String source = settingGraph.getGraph().getEdgeSource(edge);
            String target = settingGraph.getGraph().getEdgeTarget(edge);
            double weight = settingGraph.getGraph().getEdgeWeight(edge);

            System.out.println("Edge: " + source + " -> " + target + ", Weight: " + weight);
        });
    }

    @Test
    void testConnectionBetweenVertices() {
        settingGraph.addingVertexToGraph();
        settingGraph.settingEdgesForEachVertex();

        // Vertices to check connection between
        String vertex1 = "Sofia";
        String vertex2 = "Mezdra";

        // Check if there is a connection between vertex1 and vertex2
        boolean isConnected = settingGraph.getGraph().containsEdge(vertex1, vertex2);

        if (isConnected) {
            System.out.println("There is a connection between " + vertex1 + " and " + vertex2);
        } else {
            System.out.println("There is no connection between " + vertex1 + " and " + vertex2);
        }
    }


    @Test
    void testDjiikstraAlgorithm(){
//        Graph<String, DefaultWeightedEdge> graph = settingGraph.getGraph();
//        DijkstraShortestPath<String, WeightedMultigraph> shortestPathAlg = new DijkstraShortestPath<String, DefaultWeightedEdge>(graph);

        settingGraph.findShortestPath("Dragoman", "Kyustendil");
        System.out.println();
    }

    @Test
    void testNorthBulgaria(){
        settingGraph.findShortestPath("Mezdra", "Lom");
        settingGraph.findShortestPath("Vidin", "Mezdra");
        settingGraph.findShortestPath("Mezdra", "Gorna Oryahovitsa");
        settingGraph.findShortestPath("Mezdra", "Ruse");
        settingGraph.findShortestPath("Mezdra", "Karlovo");

    }

    @Test
    void testPaths(){
        settingGraph.findShortestPath("Mezdra", "Karlovo");
    }

    @Test
    void testRailway1(){
        settingGraph.findShortestPath("Dragoman", "Svilengrad");
    }

    @Test
    void testRailway2(){
        settingGraph.findShortestPath("Sofia", "Varna");
    }

    @Test
    void testRailway3(){
        settingGraph.findShortestPath("Ilianci", "Varna");
    }

    @Test
    void testRailway4(){
        settingGraph.findShortestPath("Ruse", "Podkova");
    }

    @Test
    void testRailway5(){
        settingGraph.findShortestPath("Sofia", "Kulata");
    }

    @Test
    void testRailway6(){
        settingGraph.findShortestPath("Sofia", "Kyustendil");
    }

    @Test
    void testRailway7(){
        settingGraph.findShortestPath("Mezdra", "Vidin");
    }

    @Test
    void testRailway8(){
        settingGraph.findShortestPath("Plovdiv", "Burgas");
    }


    @Test
    void testRailway9(){
        settingGraph.findShortestPath("Ruse", "Kaspichan");

    }



}
