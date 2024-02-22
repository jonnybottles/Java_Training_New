import java.util.Random;

public class Consumer implements Runnable {
    private Buffer theBuffer;

    public Consumer(Buffer buffer) {
        this.theBuffer = buffer;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            while (true) {
                Packet thePacket = theBuffer.removePacket();
                System.out.println("Consumed: " + thePacket.getData());
                int sleepTime = random.nextInt(1000);
                Thread.sleep(sleepTime);
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer interrupted.");
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.out.println("Another error in consumer occurred: " + e.getMessage());
        }

        System.out.println("Consumer has stopped running.");
    }


}
