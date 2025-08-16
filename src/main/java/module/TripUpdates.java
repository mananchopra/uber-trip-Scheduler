package src.main.java.module;

import src.main.java.config.DriverStatus;
import src.main.java.config.TripStatus;
import src.main.java.module.Driver;
import src.main.java.module.Trip;

import java.util.Date;

public final class TripUpdates {
    private TripUpdates() {} // Prevent instantiation
    
    public static Trip startTrip(Trip trip) {
        validateStartTrip(trip);
        return new TripBuilder()
            .withTrip(trip)
            .withStatus(TripStatus.TRIP_STARTED)
            .withStartTime(new Date())
            .build();
    }
    
    public static Trip endTrip(Trip trip) {
        validateEndTrip(trip);
        return new TripBuilder()
            .withTrip(trip)
            .withStatus(TripStatus.TRIP_COMPLETED)
            .withEndTime(new Date())
            .build();
    }
    
    public static Trip cancelTrip(Trip trip) {
        validateCancelTrip(trip);
        return new TripBuilder()
            .withTrip(trip)
            .withStatus(TripStatus.TRIP_CANCELLED)
            .build();
    }
    
    public static Trip assignDriver(Trip trip, Driver driver) {
        validateAssignDriver(trip, driver);
        return new TripBuilder()
            .withTrip(trip)
            .withDriver(driver)
            .withStatus(TripStatus.DRIVER_ASSIGNED)
            .build();
    }
    
    // Private validation methods
    private static void validateStartTrip(Trip trip) {
        if (trip.getDriver() == null) {
            throw new IllegalStateException("Cannot start trip without driver");
        }
        if (trip.getStatus() != TripStatus.DRIVER_ASSIGNED) {
            throw new IllegalStateException("Trip must be in DRIVER_ASSIGNED status to start");
        }
    }
    
    private static void validateEndTrip(Trip trip) {
        if (trip.getStartTime() == null) {
            throw new IllegalStateException("Cannot end trip that hasn't started");
        }
    }
    
    private static void validateCancelTrip(Trip trip) {
        if (trip.getStatus() == TripStatus.TRIP_COMPLETED) {
            throw new IllegalStateException("Cannot cancel completed trip");
        }
    }
    
    private static void validateAssignDriver(Trip trip, Driver driver) {
        if (trip.getStatus() != TripStatus.LOOKING_FOR_DRIVER) {
            throw new IllegalStateException("Can only assign driver when looking for driver");
        }
        if (driver.getStatus() != DriverStatus.AVAILABLE) {
            throw new IllegalStateException("Driver must be available");
        }
    }
}