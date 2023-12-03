class Programmer extends Employee {
    String PreferredTechnology;
    Vehicle PreferredVehicle;
    public Programmer(String Name, int BirthYear, int YearsofExperience) {
        super(Name, BirthYear, YearsofExperience);
    }

    public Programmer(String Name, int BirthYear, int YearsofExperience, double ClientsBrought) {
        super(Name, BirthYear, YearsofExperience, ClientsBrought);
    }

    public Programmer(String Name, int BirthYear, int YearsofExperience, double ClientsBrought, String PreferredTechnology) {
        super(Name, BirthYear, YearsofExperience, ClientsBrought);
        this.PreferredTechnology = PreferredTechnology;
    }

public Programmer(String name, int birthYear, int yearsOfExperience, Vehicle PreferredVehicle) {
    super(name, birthYear, yearsOfExperience);
    this.PreferredVehicle = PreferredVehicle;
}

    public Programmer(String Name, int BirthYear, int YearsofExperience, double ClientsBrought, Vehicle PreferredVehicle) {
        super(Name, BirthYear, YearsofExperience, ClientsBrought);
        this.PreferredVehicle = PreferredVehicle;
    }

    @Override
    public String getOccupation() {
        return "Programmer";
    }

    public String toString() {
        String vehicleInfo = "";
        if (PreferredVehicle instanceof Car) {
            Car car = (Car) PreferredVehicle;
            vehicleInfo = "\nEmployee has a car" +
                    "\n- make: " + car.make +
                    "\n- plate: " + car.plate +
                    "\n- color: " + car.color +
                    "\n- category: " + car.type +
                    "\n- gear type: " + car.gearType +
                    "\n- type: " + car.carType;
        } else if (PreferredVehicle instanceof Motorcycle) {
            Motorcycle motorcycle = (Motorcycle) PreferredVehicle;
            vehicleInfo = "\nEmployee has a motorcycle" + "\n- make: " + motorcycle.make + "\n- plate: " + motorcycle.plate +  "\n- color: " + motorcycle.color + "\n- category: " + motorcycle.type +
                    (motorcycle.sidecar ? "\n- with sidecar" : "\n- without sidecar");
        }

        return "-------------------------" +
                "\nName: " + getName() + ", a Programmer" + "\nAge: " + getAge() +
                vehicleInfo + "\n"+getName()+ " has an Occupation rate: " + getOccupationRate() + "%" + " and completed " + YearsOfExperience + " projects."
                +"\nHis/Her estimated annual income is " + getMonthlyIncome() +  "\n-------------------------";
    }
}