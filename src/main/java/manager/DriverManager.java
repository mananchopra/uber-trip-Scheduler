package src.main.java.manager;

import src.main.java.module.Driver;
import src.main.java.module.Location;
import src.main.java.config.DriverStatus;

public class DriverManager
{
    public static Driver createDriver( String name,
                                       String license,
                                       String phone,
                                       Location currentLocation )
    {
        Driver driver = new Driver( name, license, phone, currentLocation );
        driver.setStatus( DriverStatus.AVAILABLE );
        return driver;
    }
}
