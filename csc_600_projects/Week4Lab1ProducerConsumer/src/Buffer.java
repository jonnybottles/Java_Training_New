import java.util.concurrent.ArrayBlockingQueue;

public class Buffer {
    private ArrayBlockingQueue<Packet> queue;

    public Buffer(int capacity) {
        this.queue = new ArrayBlockingQueue<>(capacity);
    }

    public void insertPacket(Packet packet) throws InterruptedException {
        queue.put(packet);
    }

    public Packet removePacket() throws InterruptedException {
        return queue.take();
    }

    public int getSize() {
        return queue.size();
    }


}
