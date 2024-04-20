package com.university.project.railTrainSystem.engine.tickets;

import java.sql.Timestamp;

public class Ticket {

    private Long Id;
    private String start;
    private String end;
    private Double price;
    private String trainId;
    private Timestamp boughtAt;

    public Ticket(Long id, String start, String end, Double price, String trainId, Timestamp boughtAt) {
        Id = id;
        this.start = start;
        this.end = end;
        this.price = price;
        this.trainId = trainId;
        this.boughtAt = boughtAt;
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

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public Timestamp getBoughtAt() {
        return boughtAt;
    }

    public void setBoughtAt(Timestamp boughtAt) {
        this.boughtAt = boughtAt;
    }
}
