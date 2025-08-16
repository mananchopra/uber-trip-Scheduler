package src.main.java.module;

import src.main.java.module.PriceStrategy;
import src.main.java.module.Location;

public class DefaultPriceStrategy extends PriceStrategy {

    @Override
    public double calculatePrice(Location source, Location destination) {
        // Your calculation logic here
        return calculateBasePrice(source, destination);
    }

    private double calculateBasePrice(Location source, Location destination) {
        // Calculate base price based on distance
        double distance = calculateDistance(source, destination);
        return distance * 2.0; // $2 per unit distance
    }

    private double calculateDistance(Location source, Location destination) {
        // Implement distance calculation
        return Math.sqrt(Math.pow(destination.getLatitude() - source.getLatitude(), 2) +
                         Math.pow(destination.getLongitude() - source.getLongitude(), 2));
    }
}