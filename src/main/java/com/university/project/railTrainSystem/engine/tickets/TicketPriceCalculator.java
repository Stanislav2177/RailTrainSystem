package com.university.project.railTrainSystem.engine.tickets;

import com.university.project.railTrainSystem.engine.calculateprice.PriceCalculator;

import java.sql.Timestamp;
import java.util.Random;


public class TicketPriceCalculator {
    PriceCalculator priceCalculator = new PriceCalculator();


    Ticket getATicket(String start, String end){
        double priceBetweenTwoStations = priceCalculator.getPriceBetweenTwoStations(start, end);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Long id = (long) generateRandomNumber(1, 1634352424);

        //TODO FINISH
        return null;


    }


    public static int generateRandomNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }

        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
