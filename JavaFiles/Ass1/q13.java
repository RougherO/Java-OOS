package Ass1;

public class q13 {
    public static void main(String[] args) {
        Truck myTruck = new Truck("Volvo", "Truck", 120,
                75000.0, 12.5, "TRK123",
                5000, "Open", 8);

        Car myCar = new Car("Toyota", "Sedan", 160,
                30000.0, 25.0, "CAR456",
                4, 5);

        System.out.println("Truck Details:");
        System.out.println("Make: " + myTruck.getMake());
        System.out.println("Type: " + myTruck.getType());
        System.out.println("Max Speed: " + myTruck.getMaxSpeed() + " km/h");
        System.out.println("Price: " + myTruck.getPrice() + " INR");
        System.out.println("Mileage: " + myTruck.getMileage() + " km/l");
        System.out.println("Registration Number: " + myTruck.getRegistrationNumber());
        System.out.println("Capacity: " + myTruck.getCapacity() + " kg");
        System.out.println("Hood Type: " + myTruck.getHoodType());
        System.out.println("Number of Wheels: " + myTruck.getNoOfWheels());

        System.out.println();

        System.out.println("Car Details:");
        System.out.println("Make: " + myCar.getMake());
        System.out.println("Type: " + myCar.getType());
        System.out.println("Max Speed: " + myCar.getMaxSpeed() + " km/h");
        System.out.println("Price: " + myCar.getPrice() + " INR");
        System.out.println("Mileage: " + myCar.getMileage() + " km/l");
        System.out.println("Registration Number: " + myCar.getRegistrationNumber());
        System.out.println("Number of Doors: " + myCar.getNoOfDoors());
        System.out.println("Seating Capacity: " + myCar.getSeatingCapacity());

    }
}

class Automobile {
    private final String make;
    private final String type;
    private final int maxSpeed;
    private final double price;
    private final double mileage;
    private final String registrationNumber;

    public Automobile(String make, String type, int maxSpeed,
            double price, double mileage, String registrationNumber) {
        this.make = make;
        this.type = type;
        this.maxSpeed = maxSpeed;
        this.price = price;
        this.mileage = mileage;
        this.registrationNumber = registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public String getType() {
        return type;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getPrice() {
        return price;
    }

    public double getMileage() {
        return mileage;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}

class Truck extends Automobile {
    private final int capacity;
    private final String hoodType;
    private final int noOfWheels;

    public Truck(String make, String type, int maxSpeed,
            double price, double mileage, String registrationNumber,
            int capacity, String hoodType, int noOfWheels) {
        super(make, type, maxSpeed, price, mileage, registrationNumber);
        this.capacity = capacity;
        this.hoodType = hoodType;
        this.noOfWheels = noOfWheels;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getHoodType() {
        return hoodType;
    }

    public int getNoOfWheels() {
        return noOfWheels;
    }
}

class Car extends Automobile {
    private final int noOfDoors;
    private final int seatingCapacity;

    public Car(String make, String type, int maxSpeed, double price, double mileage, String registrationNumber,
            int noOfDoors, int seatingCapacity) {
        super(make, type, maxSpeed, price, mileage, registrationNumber);
        this.noOfDoors = noOfDoors;
        this.seatingCapacity = seatingCapacity;
    }

    public int getNoOfDoors() {
        return noOfDoors;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }
}