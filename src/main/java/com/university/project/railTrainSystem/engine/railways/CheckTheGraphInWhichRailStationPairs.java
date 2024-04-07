package com.university.project.railTrainSystem.engine.railways;

import com.university.project.railTrainSystem.engine.setgraph.SettingGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.*;


public class CheckTheGraphInWhichRailStationPairs {


    //Optional
    public String getTheRailStation(Set<String> CitiesWhichAreIncluded){
        SettingGraph graph = new SettingGraph();
        Railway railway = new Railway();
        List<List<String>> allRailStations = railway.allRailStations;
        int indexOfPotentialRailway = 0;
        List<String> potentialRailway = new ArrayList<>();


        // 1st level approval
        for (int i = 0; i < allRailStations.size(); i++) {
            Set<String> setWithCities = CitiesWhichAreIncluded;

            List<String> eachRailway = allRailStations.get(i);
            for (int j = 0; j < eachRailway.size(); j++) {

                String city = setWithCities.iterator().next();
                if(eachRailway.contains(city)){
                    indexOfPotentialRailway = i;

                }
            }

            if(indexOfPotentialRailway != 0){
                potentialRailway = eachRailway;
            }
        }


        System.out.println(potentialRailway);


        return null;

    }

}
