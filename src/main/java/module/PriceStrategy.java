package src.main.java.module;
import src.main.java.module.Location;

public abstract class PriceStrategy {
    public abstract double calculatePrice(Location source, Location destination);
}