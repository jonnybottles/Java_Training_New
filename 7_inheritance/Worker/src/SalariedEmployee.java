public class SalariedEmployee extends Employee{

    double annualSalary;
    boolean isRetired;

    public SalariedEmployee(String name, String birthDate, String endDate, long employeeId, String hireDate, double annualSalary, boolean isRetired) {
        super(name, birthDate, endDate, employeeId, hireDate);
        this.annualSalary = annualSalary;
        this.isRetired = isRetired;
    }

    @Override
    public double collectPay() {
        return annualSalary / 24;
    }

    public void retire() {
        terminate("today");
        isRetired = true;
    }

}
