public class Holden extends Car{
    public Holden(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public void startEngine() {
        System.out.println("Holden engine started");
    }

    @Override
    public void accelerate() {
        System.out.println("Holden accelerates");
    }

    @Override
    public void brake() {
        System.out.println("Holden brakes");
    }

}
