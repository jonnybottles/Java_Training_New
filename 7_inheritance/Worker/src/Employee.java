public class Employee extends Worker{

    long employeeId;
    String hireDate;

    public Employee() {

    }

    public Employee(String name, String birthDate, String endDate, long employeeId, String hireDate) {
        super(name, birthDate, endDate);
        this.employeeId = employeeId;
        this.hireDate = hireDate;
    }
}
