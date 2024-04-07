package com.university.project.railTrainSystem.engine.railways;

import java.util.ArrayList;
import java.util.List;

public class Railway {
    private final static List<String> railStations1 = new ArrayList<>();
    private final static List<String> railStations2 = new ArrayList<>();
    private final static List<String> railStations3 = new ArrayList<>();
    private final static List<String> railStations4 = new ArrayList<>();
    private final static List<String> railStations5 = new ArrayList<>();
    private final static List<String> railStations6 = new ArrayList<>();
    private final static List<String> railStations7 = new ArrayList<>();
    private final static List<String> railStations8 = new ArrayList<>();
    private final static List<String> railStations9 = new ArrayList<>();

    final  List<List<String>> allRailStations = new ArrayList<>();




    public Railway() {
        setUp();
    }

    private void setUp() {
        railStations1.add("Dragoman");
        railStations1.add("Sofia");
        railStations1.add("Poduyane");
        railStations1.add("Kostenec");
        railStations1.add("Septemvri");
        railStations1.add("Pazardjik");
        railStations1.add("Sofia");
        railStations1.add("Stamboliiski");
        railStations1.add("Dimitrovgrad");
        railStations1.add("Simeonovgrad");
        railStations1.add("Plovdiv");

        railStations2.add("Sofia");
        railStations2.add("Mezdra");
        railStations2.add("Cherven Bryag");
        railStations2.add("Pleven");
        railStations2.add("Pavlikeni");
        railStations2.add("Gorna Oryahovitsa");
        railStations2.add("Targovishte");
        railStations2.add("Kaspichan");
        railStations2.add("Shumen");
        railStations2.add("Varna");

        railStations3.add("Poduyane");
        railStations3.add("Karlovo");
        railStations3.add("Kazanlyk");
        railStations3.add("Tulovo");
        railStations3.add("Dybovo");
        railStations3.add("Tvyrdica");
        railStations3.add("Sliven");
        railStations3.add("Zimnica");
        railStations3.add("Karnobat");
        railStations3.add("Varna");

        railStations4.add("Ruse");
        railStations4.add("Gorna Oryahovitsa");
        railStations4.add("Veliko Tyrnovo");
        railStations4.add("Dybovo");
        railStations4.add("Careva Livada");
        railStations4.add("Tulovo");
        railStations4.add("Stara Zagora");
        railStations4.add("Mihaylovo");
        railStations4.add("Dimitrovgrad");
        railStations4.add("Podkova");

        railStations5.add("Sofia");
        railStations5.add("Pernik");
        railStations5.add("Radomir");
        railStations5.add("Dupnica");
        railStations5.add("General Todorov");
        railStations5.add("Blagoevgrad");
        railStations5.add("Kulata");

        railStations6.add("Radomir");
        railStations6.add("Kyustendil");

        railStations7.add("Mezdra");
        railStations7.add("Vratsa");
        railStations7.add("Vidin");
        railStations7.add("Montana");
        railStations7.add("Lom");

        railStations8.add("Plovdiv");
        railStations8.add("Mihaylovo");
        railStations8.add("Stara Zagora");
        railStations8.add("Yambol");
        railStations8.add("Zimnica");
        railStations8.add("Karnobat");
        railStations8.add("Burgas");

        railStations9.add("Ruse");
        railStations9.add("Samuil");
        railStations9.add("Kaspichan");

        allRailStations.add(railStations1);
        allRailStations.add(railStations2);
        allRailStations.add(railStations3);
        allRailStations.add(railStations4);
        allRailStations.add(railStations5);
        allRailStations.add(railStations6);
        allRailStations.add(railStations7);
        allRailStations.add(railStations8);
        allRailStations.add(railStations9);

    }
}
