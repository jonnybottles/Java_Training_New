import java.util.Random;

// Producer class that provides the necessary methods / attributes to produce packets
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
                // Removes packet when packets are available to be removed
                // and retrieves data from the packet printing to terminal
                Packet thePacket = theBuffer.removePacket();
                System.out.println("Consumed: " + thePacket.getData());

                // Put the thread to sleep at random intervals of 1000ms
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
