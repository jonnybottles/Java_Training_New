import java.util.concurrent.ArrayBlockingQueue;

// Class that represents a packet buffer
public class Buffer {
    // ArrayBlockingQueue implemented to avoid having to use
    // wait() / notify() // notifyall(), as the ArrayBlockingQueue
    // implements this under the hood, ultimately providing synchrinization
    private ArrayBlockingQueue<Packet> packetQueue;

    // Constructor
    public Buffer(int capacity) {
        this.packetQueue = new ArrayBlockingQueue<>(capacity);
    }

    // Wrapper method for adding packet to packetQueue
    public void insertPacket(Packet packet) throws InterruptedException {
        packetQueue.put(packet);
    }

    // Wrapper method for removing a packet fro the packetQueue
    public Packet removePacket() throws InterruptedException {
        return packetQueue.take();
    }

    public int getSize() {
        return packetQueue.size();
    }


}
