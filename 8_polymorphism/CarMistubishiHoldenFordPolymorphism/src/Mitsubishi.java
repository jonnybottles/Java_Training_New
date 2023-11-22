public class Mitsubishi extends Car{
    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public void startEngine() {
        System.out.println("Mitsubishi engine started");
    }

    @Override
    public void accelerate() {
        System.out.println("Mitsubishi accelerates");
    }

    @Override
    public void brake() {
        System.out.println("Mitsubishi brakes");
    }

}
