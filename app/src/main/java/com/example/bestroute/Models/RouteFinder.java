package com.example.bestroute.Models;

import java.util.ArrayList;

public class RouteFinder {
    public static void main(String[] args) {
        // Route distances in kilometers
        ArrayList<Double> distances = new ArrayList<>();
        distances.add(2.0);
        distances.add(1.0);
        distances.add(0.5);

        // Time taken for each route in minutes
        ArrayList<Double> times = new ArrayList<>();
        times.add(5.0);
        times.add(3.0);
        times.add(1.0);

        // Additional time due to traffic for each route in minutes
        ArrayList<Double> trafficTimes = new ArrayList<>();
        trafficTimes.add(1.0);
        trafficTimes.add(2.0);
        trafficTimes.add(3.0);

        // Vogel's Approximation Method
        int bestRouteIndex = vogelsApproximation(distances);

        // Calculate the time of arrival for the best route
        double totalTime = times.get(bestRouteIndex) + trafficTimes.get(bestRouteIndex);

        // Output the results
        System.out.println("Best Route (based on distance): Route " + (bestRouteIndex + 1));
        System.out.println("Time of Arrival: " + totalTime + " minutes");
    }

    private static int vogelsApproximation(ArrayList<Double> distances) {
        int bestRouteIndex = 0;
        double minDistance = distances.get(0);

        // Find the route with the shortest distance using Vogel's Approximation Method
        for (int i = 1; i < distances.size(); i++) {
            if (distances.get(i) < minDistance) {
                minDistance = distances.get(i);
                bestRouteIndex = i;
            }
        }

        return bestRouteIndex;
    }
}


