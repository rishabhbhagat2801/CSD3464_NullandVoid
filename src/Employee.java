public abstract class Employee {
    // employee details Private fields
    private String Name;
    private int BirthYear;
    private double MonthlyIncome;
    private double OccupationRate;
    int YearsOfExperience;
    int NoOfSubordinates;
    double ClientsBrought;
    int DaysTravelled;
    private int NbClients;
    private int NbTravelledDays;

    // Contracts

    private Contract contract;
    private Contract CurrentContract;

    private int HourlySalary;
    private int AccumulatedHours;

    // Constructor for employee details
    public Employee(String Name, int BirthYear, double MonthlyIncome, double OccupationRate) {
        this.Name = Name;
        this.BirthYear = BirthYear;
        this.MonthlyIncome = MonthlyIncome;
        setOccupationRate(OccupationRate);
    }

    // Constructor for additional employee details
    public Employee(String Name, int BirthYear, int YearsOfExperience, int NoofSubordinates, double ClientsBrought) {
        this.Name = Name;
        this.BirthYear = BirthYear;
        this.YearsOfExperience = YearsOfExperience;
        this.NoOfSubordinates = NoofSubordinates;
        this.ClientsBrought = ClientsBrought;
    }


    public Employee(String name, int birthYear, int yearsOfExperience) {
        this(name, birthYear, yearsOfExperience, 0);
    }

    // get and set methods
    public abstract String getOccupation();
    public String getName() {
        return Name;
    }

    public int getBirthYear() {
        return BirthYear;
    }

    public double getAge() {
        return 2018 - BirthYear;
    }

    public double getMonthlyIncome() {
        return MonthlyIncome;
    }

    public double getOccupationRate() {
        return OccupationRate;
    }
    public void setOccupationRate(double OccupationRate) {
        if (OccupationRate < 10) {
            this.OccupationRate = 10;
        } else if (OccupationRate > 100) {
            this.OccupationRate = 100;
        } else {
            this.OccupationRate = OccupationRate;
        }
    }

    public double annualIncome() {
        return 12 * MonthlyIncome * OccupationRate;
    }

    public int getNbClients() {
        return NbClients;
    }
    public int getNbTravelledDays() {
        return NbTravelledDays;
    }

    public int getHourlySalary() {
        return HourlySalary;
    }
    public int getAccumulatedHours() {
        return AccumulatedHours;
    }
    public void setContract(Contract contract) {
        this.CurrentContract = contract;
    }

    public Contract getCurrentContract() {
        return CurrentContract;
    }


    // Set the contract of the employees
    public void setContract(Permanent contract) {
        if (contract != null) {
            this.contract = contract;
            if (contract instanceof Permanent) {
                Permanent permanentContract = (Permanent) contract;
                this.NbClients = permanentContract.getNbClients();
                this.NbTravelledDays = permanentContract.getNbTravelledDays();
            }
        }
    }
    // Set the specific contract type of employees
    // sign the contract of the employees
    public void signContract(Contract contract) {
        this.CurrentContract = contract;
        if (contract instanceof Permanent) {
            Permanent permanentContract = (Permanent) contract;
            this.NbClients = permanentContract.getNbClients();
            this.NbTravelledDays = permanentContract.getNbTravelledDays();
        } else if (contract instanceof Temporary) {
            Temporary temporaryContract = (Temporary) contract;
            this.HourlySalary = temporaryContract.getHourlySalary();
            this.AccumulatedHours = temporaryContract.getAccumulatedHours();
        }
    }

    // display info about employee's contract details
    public String contractInfo() {
        if (CurrentContract != null) {
            if (CurrentContract instanceof Permanent) {
                Permanent permanentContract = (Permanent) CurrentContract;
                return this.getName() + " is a manager. " +
                        (permanentContract.getCivilStatus() ? "he" : "she") +
                        " is " + (permanentContract.getCivilStatus() ? "married" : "not married") +
                        " and " + (permanentContract.getCivilStatus() ? "he" : "she") +
                        "/she has " + permanentContract.getNoofChildren() + " children.\n" +
                        "He/She has worked for " + permanentContract.getDaysWorked() + " days and " +
                        "upon contract " + (permanentContract.getCivilStatus() ? "his" : "her") +
                        "/her monthly salary is " + permanentContract.getMonthlySalary() + ".\n";
            } else if (CurrentContract instanceof Temporary) {
                Temporary temporaryContract = (Temporary) CurrentContract;
                return this.getName() + " is a " + getOccupation() + ". " +
                        "He/She is a temporary employee with " + temporaryContract.getHourlyWage() +
                        " hourly salary and he/she has worked for " +
                        temporaryContract.getHoursWorked() + " hours\n";
            } else {
                return "";
            }
        } else {
            return "";
        }
    }
}