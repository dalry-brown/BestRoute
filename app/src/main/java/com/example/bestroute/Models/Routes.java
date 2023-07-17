package com.example.bestroute.Models;

public class Routes {
    private int routes_id;
    private int location_id;
    private String lm1;
    private String lm2;
    private String lm3;
    private String lm4;
    private int distance;
    private int duration;

    //lm stands for land marks


    public Routes(int routes_id, int location_id, String lm1, String lm2, String lm3, String lm4, int distance, int duration) {
        this.routes_id = routes_id;
        this.location_id = location_id;
        this.lm1 = lm1;
        this.lm2 = lm2;
        this.lm3 = lm3;
        this.lm4 = lm4;
        this.distance = distance;
        this.duration = duration;
    }

    public int getRoutes_id() {
        return routes_id;
    }

    public void setRoutes_id(int routes_id) {
        this.routes_id = routes_id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public String getLm1() {
        return lm1;
    }

    public void setLm1(String lm1) {
        this.lm1 = lm1;
    }

    public String getLm2() {
        return lm2;
    }

    public void setLm2(String lm2) {
        this.lm2 = lm2;
    }

    public String getLm3() {
        return lm3;
    }

    public void setLm3(String lm3) {
        this.lm3 = lm3;
    }

    public String getLm4() {
        return lm4;
    }

    public void setLm4(String lm4) {
        this.lm4 = lm4;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
