import java.util.UUID;

public class Producer implements  Runnable {
    private Buffer theBuffer;

    public Producer(Buffer buffer) {
        this.theBuffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Generate a UUID and convert to string
                // as a means to create random data fo the packet.
                String uuidString = UUID.randomUUID().toString();
                Packet thePacket = new Packet(uuidString);
                theBuffer.insertPacket(thePacket);
                System.out.println("Created packet with data: " + thePacket);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
