package src.main.java.module;

import java.util.List;

public interface DriverAllocationStrategy {
    Driver allocateDriver(Trip trip, List<Driver> availableDrivers);
}

