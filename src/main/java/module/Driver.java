package src.main.java.module;

import src.main.java.config.DriverStatus;
import src.main.java.module.Location;

public class Driver {

    private String name;
    private String license;
    private String phone;
    private Location currentLocation;
    private DriverStatus status;
    private int rating;

    public Driver(String name, String license, String phone, Location currentLocation) {
        this.name = name;
        this.license = license;
        this.phone = phone;
        this.currentLocation = currentLocation;
        this.status = DriverStatus.AVAILABLE;
        this.rating = 5; // Default rating
    }

    public static Driver createDriver(String name, String license, String phone, Location currentLocation) {
        return new Driver(name, license, phone, currentLocation);
    }

    public String getName() {
        return name;
    }

    public String getLicense() {
        return license;
    }

    public String getPhone() {
        return phone;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public int getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }

    public void setRating(int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Driver: " + name + "\nLicense: " + license + "\nPhone: " + phone + "\nLocation: " + currentLocation + "\nStatus: " + status;
    }
}