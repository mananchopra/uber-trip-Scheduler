# Uber Trip Scheduler - Low Level Design Solution

## 🚗 Overview

This project is a comprehensive solution to the **Low Level Design (LLD) problem** of designing an Uber Trip Scheduler system. The application demonstrates object-oriented design principles, design patterns, and system architecture concepts commonly used in ride-sharing platforms.

## 📋 Problem Statement

Design a ride-sharing application (similar to Uber) that handles:
- User and Driver management
- Trip creation and management
- Dynamic pricing strategies
- Driver allocation algorithms
- Real-time trip status tracking
- Location-based services

## 🏗️ System Architecture

The application follows a **Manager-based architecture** with **Strategy Pattern** implementation for flexible pricing and driver allocation algorithms.

### Core Components

#### 1. **Entity Classes**
- **User**: Represents passengers with basic information (ID, name, phone, email)
- **Driver**: Represents drivers with vehicle details, location, availability, and ratings
- **Trip**: Central entity managing trip lifecycle, status, pricing, and location tracking
- **Location**: Geographic coordinates and address information

#### 2. **Manager Classes**
- **UserManager**: Handles user CRUD operations and user-related queries
- **DriverManager**: Manages driver operations, availability updates, and location tracking
- **TripManager**: Orchestrates trip lifecycle, driver assignment, and status management
- **PriceStrategyManager**: Manages different pricing strategies and calculations

#### 3. **Strategy Pattern Implementation**

##### Driver Allocation Strategies
- **DriverAllocationStrategy** (Interface)
  - **NearestDriverAllocationStrategy**: Allocates the closest available driver
  - **RatingDriverAllocationStrategy**: Prioritizes drivers based on ratings
  - **DriverAllocationManager**: General allocation manager

##### Pricing Strategies
- **PriceStrategy** (Abstract Class)
  - **DistancePricingStrategy**: Price based on distance calculation
  - **SurgePricingStrategy**: Dynamic pricing during high demand
  - **WeatherPricingStrategy**: Price adjustments based on weather conditions
  - **DefaultPriceStrategy**: Base pricing algorithm

#### 4. **Configuration Classes**
- **TripStatus**: Enum defining all possible trip states
- **DriverStatus**: Driver availability states
- **PriceStrategies**: Pricing strategy configurations

## 🎯 Key Features

### 1. **Trip Lifecycle Management**
```
LOOKING_FOR_DRIVER → DRIVER_ASSIGNED → DRIVER_ARRIVED → 
TRIP_STARTED → TRIP_IN_PROGRESS → TRIP_COMPLETED
```

### 2. **Dynamic Pricing System**
- **Distance-based**: Calculates price based on source-destination distance
- **Surge Pricing**: Adjusts prices during peak hours/demand
- **Weather-based**: Price modifications for weather conditions
- **Extensible**: Easy to add new pricing strategies

### 3. **Intelligent Driver Allocation**
- **Nearest Driver**: Minimizes pickup time
- **Rating-based**: Prioritizes high-rated drivers
- **Availability Check**: Ensures driver is available and online

### 4. **Real-time Tracking**
- Current location updates
- ETA calculations
- Trip status monitoring
- Driver and user location synchronization

### 5. **Rating and Feedback System**
- Driver ratings (1-5 scale)
- Trip feedback collection
- Quality assurance mechanisms

## 🛠️ Technical Implementation

### Design Patterns Used

1. **Strategy Pattern**: For pricing and driver allocation algorithms
2. **Manager Pattern**: Centralized business logic management
3. **Builder Pattern**: Trip object construction
4. **Observer Pattern**: Trip status updates and notifications

### Code Structure
```
src/main/java/
├── Application.java                 # Main application entry point
├── config/                         # Configuration classes
│   ├── DriverStatus.java
│   ├── PriceStrategies.java
│   └── TripStatus.java
├── manager/                        # Business logic managers
│   ├── DriverManager.java
│   ├── PriceStrategyManager.java
│   ├── TripManager.java
│   └── UserManager.java
└── module/                         # Core entities and strategies
    ├── DefaultPriceStrategy.java
    ├── Driver.java
    ├── DriverAllocationStrategy.java
    ├── Location.java
    ├── PriceStrategy.java
    ├── Trip.java
    ├── TripBuilder.java
    ├── TripUpdates.java
    ├── User.java
    └── WeatherPriceStrategy.java
```

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- Maven (for dependency management)

### Running the Application

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd uber-trip-schedular
   ```

2. **Compile and run**
   ```bash
   javac -cp . src/main/java/Application.java
   java -cp . src.main.java.Application
   ```

### Sample Usage

The application includes a demo in `Application.java` that demonstrates:
- User creation
- Driver registration
- Trip creation and management
- Driver assignment
- Trip lifecycle (start → end)

## 📊 UML Class Diagram

<img width="1698" height="891" alt="Screenshot 2025-08-17 at 12 44 30 AM" src="https://github.com/user-attachments/assets/b764ecd7-b952-4f56-a17a-f08870c4811e" />


The system design is documented through a comprehensive UML class diagram that shows:
- **Class relationships**: Composition, aggregation, and associations
- **Method signatures**: Public interfaces for each class
- **Attributes**: Data members and their types
- **Design patterns**: Strategy pattern implementation
- **System boundaries**: Clear separation of concerns

## 🔧 Extensibility

The application is designed for easy extension:

### Adding New Pricing Strategies
```java
public class TimeBasedPricingStrategy extends PriceStrategy {
    @Override
    public double calculatePrice(Location source, Location destination) {
        // Implement time-based pricing logic
    }
}
```

### Adding New Driver Allocation Strategies
```java
public class ExperienceBasedAllocationStrategy implements DriverAllocationStrategy {
    @Override
    public Driver allocateDriver(Trip trip, List<Driver> availableDrivers) {
        // Implement experience-based allocation
    }
}
```

## 🧪 Testing Considerations

The design supports comprehensive testing:
- **Unit Tests**: Individual class testing
- **Integration Tests**: Manager interactions
- **Strategy Tests**: Different pricing/allocation algorithms
- **End-to-End Tests**: Complete trip lifecycle

## 📈 Scalability Features

1. **Stateless Design**: Managers can be easily distributed
2. **Strategy Pattern**: Easy to swap algorithms without code changes
3. **Modular Architecture**: Independent components for horizontal scaling
4. **Configuration-driven**: Easy to modify behavior without redeployment

## 🎓 Learning Outcomes

This project demonstrates:
- **Object-Oriented Design**: Proper encapsulation, inheritance, and polymorphism
- **Design Patterns**: Strategy, Manager, and Builder patterns
- **System Design**: Scalable architecture for real-world applications
- **Java Best Practices**: Clean code, proper package structure, and naming conventions
- **UML Modeling**: Visual representation of system design

## 🤝 Contributing

This is a learning project demonstrating LLD concepts. Feel free to:
- Add new pricing strategies
- Implement additional driver allocation algorithms
- Enhance the trip lifecycle
- Add persistence layer
- Implement real-time features

## 📝 License

This project is created for educational purposes to demonstrate Low Level Design concepts and patterns.

---

**Note**: This is a demonstration project focusing on design patterns and system architecture. For production use, additional considerations like database persistence, authentication, real-time communication, and security measures would be required.
