public class Tester extends Employee {
    // specific field to tester
    private int BugsManaged;
    Vehicle PreferredVehicle;

    //constructor based on information of tester
    public Tester(String Name, int BirthYear, int Age, int BugsManaged) {
        super(Name, BirthYear, Age, BugsManaged);
        this.BugsManaged = BugsManaged;
    }
    //constructor based on additional information of tester
    public Tester(String name, int birthYear, int yearsOfExperience) {
        super(name, birthYear, yearsOfExperience);
    }

    public Tester(String name, int birthYear, int yearsOfExperience, double clientsBrought) {
        super(name, birthYear, yearsOfExperience, clientsBrought);
    }

    public Tester(String name, int birthYear, int yearsOfExperience, double clientsBrought, Vehicle preferredVehicle) {
        super(name, birthYear, yearsOfExperience, clientsBrought);
        this.PreferredVehicle = PreferredVehicle;
    }

// get and set methods
    public int getBugsManaged() {
        return BugsManaged;
    }

    public void setBugsManaged(int bugsManaged) {
        this.BugsManaged = bugsManaged;
    }

    @Override
    public String getOccupation() {
        return "Tester";
    }

    // overiding the tostring method to provide the additional info about tester
    public String toString() {
        String vehicleInfo = "";
        // check the type of vehicle
        if (PreferredVehicle instanceof Car) {
            Car car = (Car) PreferredVehicle;
            vehicleInfo = "\nEmployee has a car" +
                    "\n- make: " + car.make +
                    "\n- plate: " + car.plate +
                    "\n- color: " + car.color +
                    "\n- category: " + car.type +
                    "\n- gear type: " + car.gearType +
                    "\n- type: " + car.carType;
            // check the type of vehicle
        } else if (PreferredVehicle instanceof Motorcycle) {
            Motorcycle motorcycle = (Motorcycle) PreferredVehicle;
            vehicleInfo = "\nEmployee has a motorcycle" +
                    "\n- make: " + motorcycle.make +
                    "\n- plate: " + motorcycle.plate +
                    "\n- color: " + motorcycle.color +
                    "\n- category: " + motorcycle.type +
                    (motorcycle.sidecar ? "\n- with sidecar" : "\n- without sidecar");
        }
// returning string with tester information
        return "-------------------------" +
                "\nName: " + getName() + ", a Manager" +
                "\nAge: " + getAge() +
                vehicleInfo +
                "\n" + getOccupation() +
                "\nOccupation rate: " + getOccupationRate() + "%" +
                "\nHis/Her estimated annual income is " + getMonthlyIncome() +
                "\n-------------------------";
    }
}