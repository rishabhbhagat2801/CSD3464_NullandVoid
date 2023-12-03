// enum for different car type
enum CarType {
    Sport,
    Sedan,
    SUV,
    Hatchback,
    Minivan
}
// enum for different vehicle type
enum VehicleType {
    MOTORCYCLE,
    CAR,
    RACE,
    NOT_FOR_RACE,
    Family,
    Sport
}
// enum for different gear type
enum Gear {
    Manual,
   Automatic
}

class Vehicle {
    //specific field to vehicle
    String make;
    String plate;
    String color;
    VehicleType type;

    // vehicle info constructor
    public Vehicle(String make, String plate, String color, VehicleType type) {
        this.make = make;
        this.plate = plate;
        this.color = color;
        this.type = type;
    }
}

class Car extends Vehicle {
    Gear gearType;
    CarType carType;

// car info constructor
    public Car(String make, String plate, String color, VehicleType type, Gear gearType, CarType carType) {
        super(make, plate, color, type);
        this.gearType = gearType;
        this.carType = carType;
    }
}

class Motorcycle extends Vehicle {
    boolean sidecar;
    VehicleType type;

    // contructor for Motorcylce infor
    public Motorcycle(String make, String plate, String color, VehicleType type, boolean sidecar) {
        super(make, plate, color, type);
        this.sidecar = sidecar;
        this.type = type;
    }
}