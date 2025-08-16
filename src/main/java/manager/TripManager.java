package src.main.java.manager;

import src.main.java.module.Trip;
import src.main.java.module.User;
import src.main.java.module.Location;
import src.main.java.module.Driver;
import src.main.java.module.TripBuilder;
import src.main.java.module.TripUpdates;
import src.main.java.config.TripStatus;
import java.util.Date;
import java.util.List;
import src.main.java.module.PriceStrategy;

public class TripManager {
   
    // Create trip using Builder Pattern
    public static Trip createTrip(User user, Location source, Location destination) {
        Trip trip = new TripBuilder()
            .withUser(user)
            .withSource(source)
            .withDestination(destination)
            .withStatus(TripStatus.LOOKING_FOR_DRIVER)
            .build();
            
        // Calculate price and distance
        PriceStrategy priceStrategy = PriceStrategyManager.getPriceStrategy(source, destination, "rainy");
        trip.setPrice(priceStrategy.calculatePrice(source, destination));
        trip.setDistance(Location.getDistance(source, destination));
        
        return trip;
    }

    // Assign driver using TripUpdates
    public static Trip assignDriver(Trip trip, List<Driver> drivers) {
        if (drivers == null || drivers.isEmpty()) {
            throw new IllegalStateException("No drivers available");
        }
        return TripUpdates.assignDriver(trip, drivers.get(0));
    }

    // Start trip using TripUpdates
    public static Trip startTrip(Trip trip) {
        return TripUpdates.startTrip(trip);
    }

    // End trip using TripUpdates
    public static Trip endTrip(Trip trip) {
        return TripUpdates.endTrip(trip);
    }

    // Cancel trip using TripUpdates
    public static Trip cancelTrip(Trip trip) {
        return TripUpdates.cancelTrip(trip);
    }
}
