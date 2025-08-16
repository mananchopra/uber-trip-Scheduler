package src.main.java;

import src.main.java.module.Driver;
import src.main.java.module.Trip;
import src.main.java.module.User;
import src.main.java.module.Location;
import src.main.java.config.TripStatus;
import src.main.java.manager.DriverManager;
import src.main.java.manager.TripManager;
import src.main.java.manager.UserManager;

import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        User user1 = UserManager.createUser("Rachel Green", 30, "123 Main St", "555-555-5555");
        User user2 = UserManager.createUser("Manan Chopra", 30, "123 Main St", "555-555-5555");
        User user3 = UserManager.createUser("Chandler Bing", 30, "123 Main St", "555-555-5555");
        
        Location driverLocation = new Location(34.123, -118.456, "123 Main St", "Los Angeles", "CA", "USA");
        Location source = new Location(22.123, -118.456, "88 Main St", "Los Angeles", "CA", "USA");
        Location destination = new Location(13.123, -118.456, "456 Elm St", "Los Angeles", "CA", "USA");

        Driver driver1 = DriverManager.createDriver("Krish", "RJ19CD3434", "4343434343", driverLocation);
        Driver driver2 = DriverManager.createDriver("Ross", "RJ19CD3434", "4343434343", driverLocation);
        Driver driver3 = DriverManager.createDriver("Joey", "RJ19CD3434", "4343434343", driverLocation);

        Trip trip = TripManager.createTrip(user1, source, destination);
        List<Driver> drivers = new ArrayList<>();
        drivers.add(driver1);
        drivers.add(driver2);
        drivers.add(driver3);
        
        trip = TripManager.assignDriver(trip, drivers);
        trip = TripManager.startTrip(trip);
        trip = TripManager.endTrip(trip);
        System.out.println(trip);
    }
}