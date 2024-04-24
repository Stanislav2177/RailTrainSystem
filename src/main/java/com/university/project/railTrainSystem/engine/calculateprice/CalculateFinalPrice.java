package com.university.project.railTrainSystem.engine.calculateprice;

import com.university.project.railTrainSystem.entity.User;
import com.university.project.railTrainSystem.repository.UserRepository;
import com.university.project.railTrainSystem.service.UserService;
import com.university.project.railTrainSystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.sql.Timestamp;
import java.util.Calendar;

@Service
public class CalculateFinalPrice {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/rail_train_system";
    static final String USER = "root";
    static final String PASS = "34153";
    TicketPriceCalculator ticketPriceCalculator = new TicketPriceCalculator();

    @Autowired
    UserService userService;


    public double getFinalPrice(String start, String end, User user) throws SQLException {
        // Base price
        Ticket aTicket = ticketPriceCalculator.getATicket(start, end);
        CardType userTypeCard = getUserTypeCard(user);

        Timestamp boughtAt = aTicket.getBoughtAt();

        // Check if the ticket was bought during peak hours
        boolean isPeakHours = isPeakHours(boughtAt);

        // Check the card type and apply discounts accordingly

        return applyDiscount(aTicket.getPrice(), userTypeCard, isPeakHours);
    }

    public double getFinalPrice(String start, String end, String  email) throws SQLException {
        // Base price


        User user = userService.getUser(email);
        Ticket aTicket = ticketPriceCalculator.getATicket(start, end);
        CardType userTypeCard = getUserTypeCard(user);

        Timestamp boughtAt = aTicket.getBoughtAt();

        // Check if the ticket was bought during peak hours
        boolean isPeakHours = isPeakHours(boughtAt);

        // Check the card type and apply discounts accordingly

        return applyDiscount(aTicket.getPrice(), userTypeCard, isPeakHours);
    }

    // Method to calculate final price based on dynamic pricing rules
    // Method to check if the ticket was bought during peak hours
    // Method to apply discounts based on card type and peak hours

    private boolean isPeakHours(Timestamp boughtAt) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(boughtAt.getTime());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // Check if the ticket was bought during peak hours (morning or evening rush)
        boolean isMorningRush = (hour >= 7 && hour < 9) || (hour == 9 && minute <= 30);
        boolean isEveningRush = (hour >= 16 && hour < 19) || (hour == 19 && minute <= 30);

        return isMorningRush || isEveningRush;
    }
    private double applyDiscount(double basePrice, CardType userTypeCard, boolean isPeakHours) {
            double discount = 0.0;

            // Apply discounts based on card type and peak hours
            if (userTypeCard == CardType.SENIOR) {
                discount = 0.34; // 34% discount for seniors
            } else if (userTypeCard == CardType.CHILD) {
                discount = 0.5; // 50% discount for children
            } else if (userTypeCard == CardType.FAMILY) {
                discount = isPeakHours ? 0.1 : 0.5; // 10% discount during peak hours, otherwise 50% discount
            } else {
                discount = isPeakHours ? 0 : 0.05; // 5% discount during off-peak hours
            }

            // Apply the discount to the base price
            double finalPrice = basePrice * (1 - discount);

            return finalPrice;
        }



    public CardType getUserTypeCard(User user) throws SQLException {
        String sql = "SELECT * FROM card WHERE user_id = ?";
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement pstsm = connection.prepareStatement(sql);
        pstsm.setString( 1, String.valueOf(user.getUserId()));

        ResultSet rs = pstsm.executeQuery();

        if (rs.next()) {
            String cardType = rs.getString(2);

            if (cardType.equals("family")) {
                return CardType.FAMILY;
            } else if (cardType.equals("default")) {
                return CardType.SENIOR;
            } else {
                return CardType.CHILD;
            }
        } else {
            // Handle the case when no card is found for the user
            return CardType.DEFAULT; // or throw an exception, depending on your requirements
        }
    }
}
