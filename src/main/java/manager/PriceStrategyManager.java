package src.main.java.manager;

import src.main.java.module.PriceStrategy;
import src.main.java.module.Location;
import src.main.java.module.WeatherPriceStrategy;
import src.main.java.module.DefaultPriceStrategy;
import src.main.java.config.PriceStrategies;

public class PriceStrategyManager {
    
    public static PriceStrategy getPriceStrategy(Location source, Location destination, String weather) {
        if(weather.equals("rainy")) {
            return new WeatherPriceStrategy(weather);
        } else {
            return new DefaultPriceStrategy();
        }
    }
    
    public static PriceStrategy getPriceStrategy(Location source, Location destination, PriceStrategies strategy) {
        switch (strategy) {
            case WEATHER_BASED:
                return new WeatherPriceStrategy("sunny"); // Default weather
            case SURGE_PRICING:
                return new DefaultPriceStrategy(); // Could be enhanced with surge logic
            case TIME_BASED:
                return new DefaultPriceStrategy(); // Could be enhanced with time logic
            case DISTANCE_BASED:
                return new DefaultPriceStrategy(); // Could be enhanced with distance logic
            case PEAK_HOURS:
                return new DefaultPriceStrategy(); // Could be enhanced with peak hours logic
            case OFF_PEAK_HOURS:
                return new DefaultPriceStrategy(); // Could be enhanced with off-peak logic
            case DEFAULT:
            default:
                return new DefaultPriceStrategy();
        }
    }
}