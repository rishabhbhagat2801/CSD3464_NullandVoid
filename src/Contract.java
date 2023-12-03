
public abstract class Contract {
// specific fields for contract
    public abstract double getMonthlyIncome();
    public abstract void signContract();
}
class Permanent extends Contract{
    private int DaysWorked;
    private double MonthlySalary;
    private int NoofChildren;
    private boolean CivilStatus;
    private double MonthlyPremium;
    private int NbClients;
    private int NbTravelledDays;

    // contructor to intialize the permanent contract info
    public Permanent(int NoofChildren, boolean CivilStatus, double MonthlySalary, double MonthlyPremium, int DaysWorked){
        this.DaysWorked = DaysWorked;
        this.MonthlySalary = MonthlySalary;
        this.NoofChildren = NoofChildren;
        this.CivilStatus = CivilStatus;
        this.MonthlyPremium = MonthlyPremium;
    }

    // get and set methods
    public void setDaysWorked(int DaysWorked) {
        this.DaysWorked = DaysWorked;
    }

    public void setCivilStatus(boolean CivilStatus) {
        this.CivilStatus = CivilStatus;
    }

    public void setMonthlyPremium(double MonthlyPremium) {
        this.MonthlyPremium = MonthlyPremium;
    }

    public void setMonthlySalary(double MonthlySalary) {
        this.MonthlySalary = MonthlySalary;
    }

    public void setNoofChildren(int NoofChildren) {
        this.NoofChildren = NoofChildren;
    }

    public double getMonthlyPremium() {
        return MonthlyPremium;
    }

    public double getMonthlySalary() {
        return MonthlySalary;
    }

    public int getDaysWorked() {
        return DaysWorked;
    }

    public int getNoofChildren() {
        return NoofChildren;
    }
    public boolean getCivilStatus(){
        return CivilStatus;
    }

    // overriding the getMonthlyIncome to return the income
    @Override
    public double getMonthlyIncome() {
        if (getCivilStatus()){
            return (getMonthlySalary()+(getNoofChildren() * getMonthlyPremium()))*((double) getDaysWorked() / 20);
        }
        else{
            return (getMonthlySalary()) * ((double) getDaysWorked() /20);
        }
    }
    public int getNbClients() {
        return NbClients;
    }
    public int getNbTravelledDays() {
        return NbTravelledDays;
    }
    @Override
    public void signContract() {
    }


}

class Temporary extends Contract{
    // specific fields to temporary
    private int HoursWorked;
    private double HourlyWage;
    private int HourlySalary;
    private int AccumulatedHours;

// constructor for temporary contract
    public Temporary(double HourlyWage,int HoursWorked){
        this.HoursWorked = HoursWorked;
        this.HourlyWage = HourlyWage;
    }
    // get and set method
    public void setHourlyWage(double HourlyWage) {
        this.HourlyWage = HourlyWage;
    }

    public void setHoursWorked(int HoursWorked) {
        this.HoursWorked = HoursWorked;
    }

    public double getHourlyWage() {
        return HourlyWage;
    }

    public int getHoursWorked() {
        return HoursWorked;
    }

    public int getHourlySalary() {
        return HourlySalary;
    }
    public int getAccumulatedHours() {
        return AccumulatedHours;
    }
    @Override
    public double getMonthlyIncome() {
        return getHourlyWage() * getHoursWorked();
    }
    @Override
    public void signContract() {
    }

}
