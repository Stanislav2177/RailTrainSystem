package com.university.project.railTrainSystem.engine.calculateprice;

import com.university.project.railTrainSystem.engine.calculateprice.PriceCalculator;
import com.university.project.railTrainSystem.engine.calculateprice.Ticket;
import com.university.project.railTrainSystem.engine.trains.Train;
import com.university.project.railTrainSystem.engine.trains.TrainService;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;
import java.text.DecimalFormat;


public class TicketPriceCalculator {
    PriceCalculator priceCalculator = new PriceCalculator();
    TrainService trainService = new TrainService();



    public Ticket getATicket(String start, String end) throws SQLException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Long id = (long) generateRandomNumber(1, 1634352424);
        List<Train> trains = trainService.checkForAvailableTrain(start);

        Ticket ticket = new Ticket();

        if (!trains.isEmpty()) {
            int i = generateRandomNumber(trains.get(0).getId(), trains.get(trains.size() - 1).getId());

            double priceBetweenTwoStations = priceCalculator.getPriceBetweenTwoStations(start, end);

            // Replace comma with period and format the price to have only two digits after the decimal point
            String formattedPrice = new DecimalFormat("#.##")
                    .format(priceBetweenTwoStations).replace(',', '.');
            double finalPrice = Double.parseDouble(formattedPrice);

            ticket.setBoughtAt(timestamp);
            ticket.setPrice(finalPrice);
            ticket.setStart(start);
            ticket.setEnd(end);
            ticket.setId(id);
            ticket.setTrainId((long) i);

            return ticket;
        }

        return ticket;
    }



    public static int generateRandomNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }

        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
