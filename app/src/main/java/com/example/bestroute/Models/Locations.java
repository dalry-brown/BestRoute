package com.example.bestroute.Models;

public class Locations {
    private int id;
    private String location1;
    private String location2;

    public Locations(int id, String location1, String location2) {
        this.id = id;
        this.location1 = location1;
        this.location2 = location2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation1() {
        return location1;
    }

    public void setLocation1(String location1) {
        this.location1 = location1;
    }

    public String getLocation2() {
        return location2;
    }

    public void setLocation2(String location2) {
        this.location2 = location2;
    }
}
