package src.main.java.module;

import src.main.java.config.TripStatus;
import src.main.java.module.PriceStrategy;
import src.main.java.manager.TripManager;
import src.main.java.manager.PriceStrategyManager;

import java.util.Date;
import java.util.List;

public class Trip {
    private Location source;
    private Location destination;
    private String date;
    private String time;
    private Driver driver;
    private User user;
    private TripStatus status;
    private String id;
    private Double price;
    private int driverRating;
    private String feedback;
    private Location currentLocation;
    private Date startTime;
    private Date endTime;
    private Double distance;
    private Double etaDuration;
    private String etaArrivalTime;
    private Date createdDateTime;
    private Date lastModifiedDateTime;

    public Trip() {
        this.createdDateTime = new Date();
        this.lastModifiedDateTime = new Date();
        this.status = TripStatus.LOOKING_FOR_DRIVER;
    }

    public Trip(User user, Location source, Location destination) {
        this.user = user;
        this.source = source;
        this.destination = destination;
        this.createdDateTime = new Date();
        this.lastModifiedDateTime = new Date();
    }


    public String getDate()
    {
        return date;
    }


    public void setDate( final String date )
    {
        this.date = date;
    }


    public Location getSource()
    {
        return source;
    }


    public void setSource( final Location source )
    {
        this.source = source;
    }


    public Location getDestination()
    {
        return destination;
    }


    public void setDestination( final Location destination )
    {
        this.destination = destination;
    }


    public String getTime()
    {
        return time;
    }


    public void setTime( final String time )
    {
        this.time = time;
    }


    public Driver getDriver()
    {
        return driver;
    }


    public void setDriver( final Driver driver )
    {
        this.driver = driver;
    }


    public User getUser()
    {
        return user;
    }


    public void setUser( final User user )
    {
        this.user = user;
    }


    public TripStatus getStatus()
    {
        return status;
    }


    public void setStatus( final TripStatus status )
    {
        this.status = status;
    }


    public String getId()
    {
        return id;
    }


    public void setId( final String id )
    {
        this.id = id;
    }


    public Double getPrice()
    {
        return price;
    }


    public void setPrice( final Double price )
    {
        if (price != null && price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }


    public int getDriverRating()
    {
        return driverRating;
    }


    public void setDriverRating( final int driverRating )
    {
        if (driverRating < 0 || driverRating > 5) {
            throw new IllegalArgumentException("Driver rating must be between 0 and 5");
        }
        this.driverRating = driverRating;
    }


    public Date getStartTime()
    {
        return startTime;
    }


    public void setStartTime( final Date startTime )
    {
        this.startTime = startTime;
    }


    public String getFeedback()
    {
        return feedback;
    }


    public void setFeedback( final String feedback )
    {
        this.feedback = feedback;
    }


    public Location getCurrentLocation()
    {
        return currentLocation;
    }


    public void setCurrentLocation( final Location currentLocation )
    {
        this.currentLocation = currentLocation;
    }


    public Date getEndTime()
    {
        return endTime;
    }


    public void setEndTime( final Date endTime )
    {
        this.endTime = endTime;
    }


    public Double getEtaDuration()
    {
        return etaDuration;
    }


    public void setEtaDuration( final Double etaDuration )
    {
        this.etaDuration = etaDuration;
    }


    public Double getDistance()
    {
        return distance;
    }


    public void setDistance( final Double distance )
    {
        this.distance = distance;
    }


    public Date getCreatedDateTime()
    {
        return createdDateTime;
    }


    public void setCreatedDateTime( final Date createdDateTime )
    {
        this.createdDateTime = createdDateTime;
    }


    public Date getLastModifiedDateTime()
    {
        return lastModifiedDateTime;
    }


    public void setLastModifiedDateTime( final Date lastModifiedDateTime )
    {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }


    public String toString(){
       return "Trip Details " + "\nId: " + id + "\nSource: " + source + "\nDestination: " + destination + "\nDate: " + date + "\nTime: " + time + "\nDriver: " + driver + "\nUser: " + user + "\nStatus: " + status + "\nPrice: " + price + "\nDriverRating: " + driverRating + "\nFeedback: " + feedback + "\ncreatedDateTime: " + createdDateTime + "\nlastModifiedDateTime: " + lastModifiedDateTime;
    }
}