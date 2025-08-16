package src.main.java.module;

public class Location {
    private Double Latitude;
    private Double Longitude;
    private String address;
    private String city;
    private String State;
    private String Country;
    public Location(Double Latitude, Double Longitude, String address, String city, String State, String Country) {
        this.Latitude = Latitude;
        this.Longitude = Longitude;
        this.address = address;
        this.city = city;
        this.State = State;
        this.Country = Country;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return State;
    }

    public String getCountry() {
        return Country;
    }

    public void setLatitude(Double Latitude) {
        if (Latitude != null && (Latitude < -90 || Latitude > 90)) {
            throw new IllegalArgumentException("Latitude must be between -90 and 90");
        }
        this.Latitude = Latitude;
    }

    public void setLongitude(Double Longitude) {
        if (Longitude != null && (Longitude < -180 || Longitude > 180)) {
            throw new IllegalArgumentException("Longitude must be between -180 and 180");
        }
        this.Longitude = Longitude;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String State) {
        this.State = State;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String toString() {
        return "Location: " + address + "\nCity: " + city + "\nState: " + State + "\nCountry: " + Country;
    }

    public static Double getDistance(Location source, Location destination) {
        return 20.0;
    }
}