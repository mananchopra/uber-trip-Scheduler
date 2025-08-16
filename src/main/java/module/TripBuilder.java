package src.main.java.module;

import src.main.java.config.TripStatus;
import java.util.Date;
import java.util.UUID;

public class TripBuilder {
    private User user;
    private Location source;
    private Location destination;
    private String date;
    private String time;
    private Driver driver;
    private TripStatus status;
    private String id;
    private Double price;
    private Integer driverRating;
    private String feedback;
    private Location currentLocation;
    private Date startTime;
    private Date endTime;
    private Double distance;
    private Double etaDuration;
    private Date createdDateTime;
    private Date lastModifiedDateTime;

    public TripBuilder() {
        this.status = TripStatus.LOOKING_FOR_DRIVER;
    }

    // Method to update existing trip
    public TripBuilder withTrip(Trip trip) {
        this.user = trip.getUser();
        this.source = trip.getSource();
        this.destination = trip.getDestination();
        this.date = trip.getDate();
        this.time = trip.getTime();
        this.driver = trip.getDriver();
        this.status = trip.getStatus();
        this.id = trip.getId();
        this.price = trip.getPrice();
        this.driverRating = trip.getDriverRating();
        this.feedback = trip.getFeedback();
        this.currentLocation = trip.getCurrentLocation();
        this.startTime = trip.getStartTime();
        this.endTime = trip.getEndTime();
        this.distance = trip.getDistance();
        this.etaDuration = trip.getEtaDuration();
        this.createdDateTime = trip.getCreatedDateTime();
        this.lastModifiedDateTime = new Date(); // Always update last modified
        return this;
    }

    public TripBuilder withUser(User user) {
        this.user = user;
        return this;
    }

    public TripBuilder withSource(Location source) {
        this.source = source;
        return this;
    }

    public TripBuilder withDestination(Location destination) {
        this.destination = destination;
        return this;
    }

    public TripBuilder withDriver(Driver driver) {
        this.driver = driver;
        return this;
    }

    public TripBuilder withPrice(Double price) {
        if (price != null && price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
        return this;
    }

    public TripBuilder withDistance(Double distance) {
        if (distance != null && distance < 0) {
            throw new IllegalArgumentException("Distance cannot be negative");
        }
        this.distance = distance;
        return this;
    }

    public TripBuilder withStatus(TripStatus status) {
        this.status = status;
        return this;
    }

    public TripBuilder withStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public TripBuilder withEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public TripBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public TripBuilder withDriverRating(Integer driverRating) {
        if (driverRating != null && (driverRating < 1 || driverRating > 5)) {
            throw new IllegalArgumentException("Driver rating must be between 1 and 5");
        }
        this.driverRating = driverRating;
        return this;
    }

    public TripBuilder withFeedback(String feedback) {
        this.feedback = feedback;
        return this;
    }

    public TripBuilder withCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
        return this;
    }

    public TripBuilder withEtaDuration(Double etaDuration) {
        this.etaDuration = etaDuration;
        return this;
    }



    public Trip build() {
        Trip trip = new Trip();
        
        // Set ID (generate new one if not provided)
        if (this.id == null) {
            trip.setId(UUID.randomUUID().toString());
        } else {
            trip.setId(this.id);
        }
        
        // Set all other properties
        trip.setUser(user);
        trip.setSource(source);
        trip.setDestination(destination);
        trip.setDate(date);
        trip.setTime(time);
        trip.setDriver(driver);
        trip.setPrice(price);
        trip.setDistance(distance);
        trip.setStatus(status);
        if (driverRating != null && driverRating >= 1 && driverRating <= 5) {
            trip.setDriverRating(driverRating);
        }
        if (feedback != null) {
            trip.setFeedback(feedback);
        }
        trip.setCurrentLocation(currentLocation);
        trip.setStartTime(startTime);
        trip.setEndTime(endTime);
        trip.setEtaDuration(etaDuration);
        
        // Set timestamps
        if (this.createdDateTime == null) {
            trip.setCreatedDateTime(new Date());
        } else {
            trip.setCreatedDateTime(this.createdDateTime);
        }
        trip.setLastModifiedDateTime(this.lastModifiedDateTime != null ? this.lastModifiedDateTime : new Date());
        
        return trip;
    }
}
