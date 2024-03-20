package com.university.project.railTrainSystem.TestGraph;


import com.university.project.railTrainSystem.config.SettingGraph;
import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.jgrapht.traverse.DepthFirstIterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.jgrapht.alg.shortestpath.AStarShortestPath;

import java.util.Deque;
import java.util.List;

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
//
//    @Test
//    void testShortestPath() {
//        settingGraph.addingVertexToGraph();
//        settingGraph.settingEdgesForEachVertex();
//
//        String sourceVertex = "Sofia";
//        String targetVertex = "Vratsa";
//
//        AStarShortestPath<String, DefaultEdge> shortestPath = new AStarShortestPath<>(settingGraph.getGraph());
//        List<DefaultEdge> path = (List<DefaultEdge>) shortestPath.getPath(sourceVertex, targetVertex);
//
//        if (path != null) {
//            System.out.println("There is a connection between " + sourceVertex + " and " + targetVertex);
//            System.out.println("Path: " + path);
//        } else {
//            System.out.println("There is no connection between " + sourceVertex + " and " + targetVertex);
//        }
//    }


    @Test
    void testIterator(){
        settingGraph.addingVertexToGraph();
        settingGraph.settingEdgesForEachVertex();
        DepthFirstIterator depthFirstIterator
                = new DepthFirstIterator<>(settingGraph.getGraph());

        Deque stack = depthFirstIterator.getStack();
        while (stack.isEmpty()){
            System.out.println(stack.pop());
        }


        // not working
    }

    @Test
    void testDjiikstraAlgorithm(){
//        Graph<String, DefaultWeightedEdge> graph = settingGraph.getGraph();
//        DijkstraShortestPath<String, WeightedMultigraph> shortestPathAlg = new DijkstraShortestPath<String, DefaultWeightedEdge>(graph);

        settingGraph.findShortestPath("Sofia", "Pleven");

    }
}
