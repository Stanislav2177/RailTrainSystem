package com.university.project.railTrainSystem.config;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SettingGraph {


    public SettingGraph() {
        addingVertexToGraph();
        settingEdgesForEachVertex();
    }

    public static String[] vertices = {
            "Dragoman", "Sofia", "Poduyane", "Pernik", "Mezdra", "Vratsa", "Cherven Bryag",
            "Montana", "Lom", "Vidin", "Pleven", "Pavlikeni", "Gorna Oryahovitsa", "Ruse",
            "Tyrgovishte", "Veliko Tyrnovo", "Samuil", "Silistra", "Kaspichan", "Shumen",
            "Varna", "Dobrich", "Karnobat", "Burgas", "Zimnica", "Sliven", "Yambol",
            "Nova Zagora", "Stara Zagora", "Tvyrdica", "Dybovo", "Careva Livada", "Gabrovo",
            "Tulovo", "Kazanlyk", "Mihailovo", "Dimitrovgrad", "Simeonovgrad", "Svilengrad",
            "Podkova", "Plovdiv", "Karlovo", "Stamboliiski", "Pazardjik", "Septemvri",
            "Velingrad", "Dobrinishte", "Kostenec", "Radomir", "Kyustendil", "Dupnica",
            "Blagoevgrad", "General Todorov", "Kulata", "Petrich"
    };

//    public static Graph<String, DefaultEdge> graph = new WeightedMultigraph<>(DefaultEdge.class);
        Graph<String, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        private DijkstraShortestPath<String, DefaultWeightedEdge> shortestPathAlg = new DijkstraShortestPath<>(graph);

    public Graph<String, DefaultWeightedEdge> getGraph() {
        return graph;
    }

    public void addingVertexToGraph(){
        for (String vertex : vertices){
            graph.addVertex(vertex);
        }
    }

    public void findShortestPath(String sourceVertex, String targetVertex) {
        double shortestPathLength = shortestPathAlg.getPath(sourceVertex, targetVertex).getLength();
        System.out.println( " current " + shortestPathAlg.getPath(sourceVertex, targetVertex));
//        System.out.println("Shortest path from " + sourceVertex + " to " + targetVertex + ": " + shortestPathAlg.getPath(sourceVertex, targetVertex));
        System.out.println("Shortest path length: " + shortestPathLength);

        String path = String.valueOf(shortestPathAlg.getPath(sourceVertex, targetVertex));

        calculateWeightBetweenTwoPaths(path);
    }

    public int calculateWeightBetweenTwoPaths(String list){
        //Receiving the whole trace, and then calculating the total kilometers
        Stack<DefaultWeightedEdge> strings = separateTheWholeTraceToListOfStrings(list);
        int totalKilometers = 0;

        int size = strings.size();

        for (int i = 0; i < size; i++) {
            totalKilometers += graph.getEdgeWeight(strings.pop());
        }

        DefaultWeightedEdge edge = graph.getEdge("Sofia", "Mezdra");
        double edgeWeight = graph.getEdgeWeight(edge);
//        System.out.println("sofia - mezdra : " + edgeWeight);

//        System.out.println("total killometers : " + totalKilometers );

        return totalKilometers;
    }

    private Stack<DefaultWeightedEdge> separateTheWholeTraceToListOfStrings(String trace) {
        // Remove the leading and trailing brackets
        trace = trace.substring(1, trace.length() - 1);

        // Split the string by comma and space to separate individual pairs
        String[] pairs = trace.split(", ");

        // Create a list to store the separated strings
        Stack<DefaultWeightedEdge> stack = new Stack<>();

        // Iterate through each pair and add it to the list
        for (String pair : pairs) {
            // Remove the parentheses around each pair
            pair = pair.substring(1, pair.length() - 1);
            // Split the pair by colon to separate the vertices
            String[] vertices = pair.split(" : ");
            // Add the separated vertices to the list
            stack.push(graph.getEdge(vertices[0], vertices[1]));
        }

        // Print or use the separated strings as needed
        System.out.println(stack);
        return stack;
    }





//    public void getPaths(String vertex){
//        ShortestPathAlgorithm.SingleSourcePaths<String, DefaultWeightedEdge> paths = shortestPathAlg.getPaths(vertex);
//        paths.getGraph().
//    }

    public void settingEdgesForEachVertex(){
        graph.setEdgeWeight(graph.addEdge("Dragoman", "Sofia"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Sofia", "Poduyane"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Sofia", "Pernik"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Sofia", "Mezdra"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Mezdra", "Vratsa"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Mezdra", "Cherven Bryag"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Vratsa", "Montana"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Montana", "Lom"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Montana", "Vidin"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Lom", "Vidin"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Cherven Bryag", "Pleven"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Pleven", "Pavlikeni"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Gorna Oryahovitsa", "Pavlikeni"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Gorna Oryahovitsa", "Ruse"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Gorna Oryahovitsa", "Tyrgovishte"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Gorna Oryahovitsa", "Veliko Tyrnovo"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Ruse", "Samuil"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Samuil", "Silistra"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Samuil", "Kaspichan"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Tyrgovishte", "Shumen"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Shumen", "Kaspichan"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Kaspichan", "Varna"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Kaspichan", "Dobrich"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Varna", "Karnobat"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Karnobat", "Burgas"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Karnobat", "Zimnica"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Zimnica", "Sliven"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Zimnica", "Yambol"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Yambol", "Nova Zagora"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Nova Zagora", "Stara Zagora"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Sliven", "Tvyrdica"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Tvyrdica", "Dybovo"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Dybovo", "Careva Livada"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Careva Livada", "Veliko Tyrnovo"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Veliko Tyrnovo", "Gabrovo"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Dybovo", "Tulovo"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Tulovo", "Stara Zagora"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Tulovo", "Kazanlyk"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Stara Zagora", "Mihailovo"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Mihailovo", "Dimitrovgrad"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Dimitrovgrad", "Simeonovgrad"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Simeonovgrad", "Svilengrad"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Dimitrovgrad", "Podkova"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Mihailovo", "Plovdiv"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Plovdiv", "Dimitrovgrad"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Plovdiv", "Karlovo"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Kazanlyk", "Karlovo"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Kazanlyk", "Poduyane"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Plovdiv", "Stamboliiski"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Stamboliiski", "Pazardjik"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Pazardjik", "Septemvri"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Septemvri", "Velingrad"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Velingrad", "Dobrinishte"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Septemvri", "Kostenec"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Poduyane", "Kostenec"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Pernik", "Radomir"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Radomir", "Kyustendil"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Radomir", "Dupnica"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Dupnica", "Blagoevgrad"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("Blagoevgrad", "General Todorov"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("General Todorov", "Kulata"), getRandomWeight(15, 45));
        graph.setEdgeWeight(graph.addEdge("General Todorov", "Petrich"), getRandomWeight(15, 45));
    }

    private int getRandomWeight(int min, int max) {
        return (int) (min + Math.random() * (max - min + 1));
    }
}
