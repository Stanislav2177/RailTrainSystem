package com.university.project.railTrainSystem.engine.trains;


import java.sql.Date;
import java.sql.Time;


public class Train {
    private int id;
    private String cityStart;
    private String cityEnd;
    private Time start;
    private Time finish;

    private String type;
    private boolean problem;


    public Train() {
    }

    public Train(int id, String cityStart, String cityEnd, Time start, Time finish, String type, boolean problem) {
        this.id = id;
        this.cityStart = cityStart;
        this.cityEnd = cityEnd;
        this.start = start;
        this.finish = finish;
        this.type = type;
        this.problem = problem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityStart() {
        return cityStart;
    }

    public void setCityStart(String cityStart) {
        this.cityStart = cityStart;
    }

    public String getCityEnd() {
        return cityEnd;
    }

    public void setCityEnd(String cityEnd) {
        this.cityEnd = cityEnd;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getFinish() {
        return finish;
    }

    public void setFinish(Time finish) {
        this.finish = finish;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isProblem() {
        return problem;
    }

    public void setProblem(boolean problem) {
        this.problem = problem;
    }


}
