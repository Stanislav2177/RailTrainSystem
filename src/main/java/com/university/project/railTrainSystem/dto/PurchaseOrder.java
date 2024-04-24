package com.university.project.railTrainSystem.dto;

import com.university.project.railTrainSystem.engine.calculateprice.CardType;

import java.sql.Timestamp;

public class PurchaseOrder {
    private CardType cardType;
    private Long Id;
    private String start;
    private String end;
    private Double price;
    private Long trainId;
    private Timestamp boughtAt;
    private String firstName;

    private String lastName;

    private String email;


    public PurchaseOrder() {
    }

    public PurchaseOrder(CardType cardType, Long id, String start, String end, Double price, Long trainId, Timestamp boughtAt, String firstName, String lastName, String email) {
        this.cardType = cardType;
        Id = id;
        this.start = start;
        this.end = end;
        this.price = price;
        this.trainId = trainId;
        this.boughtAt = boughtAt;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public Timestamp getBoughtAt() {
        return this.boughtAt;
    }

    public void setBoughtAt(Timestamp boughtAt) {
        this.boughtAt = boughtAt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
