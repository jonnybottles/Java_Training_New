public class Worker {

    private String name;
    private String birthDate;
    private String endDate;

    public Worker() {

    }

    public Worker(String name, String birthDate, String endDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.endDate = endDate;
    }

    public int getAge() {
        return 2023 - getBirthYear();
    }

    private int getBirthYear() {
        return Integer.parseInt(birthDate.substring(birthDate.length() - 4));
    }

    public double collectPay() {
        return 0.0;
    }

    public void terminate(String endDate) {
        this.endDate = endDate;
        System.out.println("Employee will be terminated on " + endDate);
    }




}
