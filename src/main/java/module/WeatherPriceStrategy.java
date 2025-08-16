package src.main.java.module;

import src.main.java.module.PriceStrategy;
import src.main.java.module.Location;

public class WeatherPriceStrategy extends PriceStrategy {

    private String weather;

    public WeatherPriceStrategy(String weather) {
        this.weather = weather;
    }

    @Override
    public double calculatePrice(Location source, Location destination) {
        // Your calculation logic here
        double basePrice = calculateBasePrice(source, destination);
        double weatherMultiplier = getWeatherMultiplier();

        return basePrice * weatherMultiplier;
    }

    private double calculateBasePrice(Location source, Location destination) {
        // Calculate base price based on distance
        double distance = calculateDistance(source, destination);
        return distance * 2.0; // $2 per unit distance
    }

    private double getWeatherMultiplier() {
        // Get weather conditions and return multiplier
        // For example: sunny = 1.0, rainy = 1.2, snowy = 1.5
        return 2.0; // Default multiplier
    }

    private double calculateDistance(Location source, Location destination) {
        // Implement distance calculation
        return Math.sqrt(Math.pow(destination.getLatitude() - source.getLatitude(), 2) +
                         Math.pow(destination.getLongitude() - source.getLongitude(), 2));
    }
}