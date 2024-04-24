package com.university.project.railTrainSystem.controller;


import com.university.project.railTrainSystem.dto.PurchaseOrder;
import com.university.project.railTrainSystem.engine.calculateprice.CalculateFinalPrice;
import com.university.project.railTrainSystem.engine.calculateprice.CardType;
import com.university.project.railTrainSystem.engine.calculateprice.Ticket;
import com.university.project.railTrainSystem.engine.calculateprice.TicketPriceCalculator;
import com.university.project.railTrainSystem.entity.User;
import com.university.project.railTrainSystem.service.UserService;
import com.university.project.railTrainSystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class TicketController {

    TicketPriceCalculator ticketPriceCalculator;
    CalculateFinalPrice calculator;

    UserService service;

    public TicketController(TicketPriceCalculator ticketPriceCalculator, CalculateFinalPrice calculator, UserService service) {
        this.ticketPriceCalculator = ticketPriceCalculator;
        this.calculator = calculator;
        this.service = service;
    }

    @GetMapping("/get-ticket")
    public ResponseEntity<PurchaseOrder> getOrderForAUser(
            @RequestParam String email,
            @RequestParam String start,
            @RequestParam String end) throws SQLException {

        PurchaseOrder purchaseOrder = new PurchaseOrder();

        double finalPrice = calculator.getFinalPrice(start, end, email);
        Ticket aTicket = ticketPriceCalculator.getATicket(start, end);
        User user = service.getUser(email);

        purchaseOrder.setBoughtAt(aTicket.getBoughtAt());
        purchaseOrder.setEmail(email);
        purchaseOrder.setId(aTicket.getTrainId());
        purchaseOrder.setPrice(finalPrice);
        purchaseOrder.setStart(start);
        purchaseOrder.setEnd(end);
        purchaseOrder.setFirstName(user.getFirstName());
        purchaseOrder.setLastName(user.getLastName());
        CardType userTypeCard = calculator.getUserTypeCard(user);
        purchaseOrder.setCardType(userTypeCard);

        return ResponseEntity.ok(purchaseOrder);
    }

}
