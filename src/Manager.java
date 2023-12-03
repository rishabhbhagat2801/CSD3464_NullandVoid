class Manager extends Employee {
    // fields specific to manager
    private Vehicle PreferredVehicle;

    private static final double WORKING_DAYS_PER_MONTH = 20.0;
    private static final int GAIN_FACTOR_CLIENT = 500;
    private static final int GAIN_FACTOR_TRAVEL = 100;

// contructor for manager information
    public Manager(String Name, int BirthYear, int YearsofExperience, int NoofSubordinates) {
        super(Name, BirthYear, YearsofExperience, NoofSubordinates);
    }
    // contructor for manager's  additional information
    public Manager(String Name, int BirthYear, int YearsofExperience, int NoOfSubordinates, Vehicle PreferredVehicle) {
        super(Name, BirthYear, YearsofExperience, NoOfSubordinates);
        this.PreferredVehicle = PreferredVehicle;
    }

    public Manager(String Name, int BirthYear, int YearsofExperience, int NoofSubordinates, int ClientsBrought, Vehicle PreferredVehicle) {
        super(Name, BirthYear, YearsofExperience, NoofSubordinates, ClientsBrought);
        this.PreferredVehicle = PreferredVehicle;
    }

// get and set methods
    public Vehicle getPreferredVehicle() {
        return PreferredVehicle;
    }

    public void setPreferredVehicle(Vehicle PreferredVehicle) {
        this.PreferredVehicle = PreferredVehicle;
    }

    // overriding the getoccupation method
    @Override
    public String getOccupation() {
        return "Manager";
    }

    // overriding the annualIncome method
    public double annualIncome() {
        double BaseYearlyIncome = super.annualIncome();
        double BonusForClients = ClientsBrought * GAIN_FACTOR_CLIENT;
        double ExpenditureForTravel = DaysTravelled * GAIN_FACTOR_TRAVEL;

        return BaseYearlyIncome + BonusForClients + ExpenditureForTravel;
    }

    // overriding the tostring method to print info about manager
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
            vehicleInfo = "\nEmployee has a motorcycle" +
                    "\n- make: " + motorcycle.make +
                    "\n- plate: " + motorcycle.plate +
                    "\n- color: " + motorcycle.color +
                    "\n- category: " + motorcycle.type +
                    (motorcycle.sidecar ? "\n- with sidecar" : "\n- without sidecar");
        }

        return "-------------------------" +
                "\nName: " + getName() + ", a Manager" +
                "\nAge: " + getAge() +
                vehicleInfo +
                "\n"+getName() +" has an Occupation rate: " + (getOccupationRate())  +
                " He/She travelled "+DaysTravelled +" days and has brought "+ClientsBrought+ " new clients." +
                "\nHis/Her estimated annual income is "+ annualIncome() +
                "\n-------------------------";
    }



}
