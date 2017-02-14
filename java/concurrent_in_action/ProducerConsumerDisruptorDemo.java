import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WorkHandler;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * javac -cp disruptor-3.3.2.jar ProducerConsumerDisruptorDemo.java
 * java -cp disruptor-3.3.2.jar:. ProducerConsumerDisruptorDemo
 */
public class ProducerConsumerDisruptorDemo {

    public static class Producer {
        private final RingBuffer<PCData> ringBuffer;

        public Producer(RingBuffer<PCData> ringBuffer) {
            this.ringBuffer = ringBuffer;
        }

        public void pushData(ByteBuffer bb) {
            long sequence = ringBuffer.next();
            try {
                PCData event = ringBuffer.get(sequence);
                event.set(bb.getLong(0));
            } finally {
                ringBuffer.publish(sequence);
            }
        }
    }

    public static class Consumer implements WorkHandler<PCData> {
        @Override
        public void onEvent(PCData event) throws Exception {
            System.out.printf("%d: Event: -- %d --\n", Thread.currentThread().getId(), event.get() * event.get());
        }
    }

    public static class PCDataFactory implements EventFactory<PCData> {
        public PCData newInstance() {
            return new PCData();
        }
    }

    public static class PCData {
        private long value;

        public PCData() {
        }

        public void set(long value) {
            this.value = value;
        }

        public long get() {
            return this.value;
        }

        @Override
        public String toString() {
            return "data: " + value;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Executor executor = Executors.newCachedThreadPool();
        PCDataFactory factory = new PCDataFactory();
        int bufferSize = 1024;
        Disruptor<PCData> disruptor = new Disruptor<>(factory,
                bufferSize,
                executor,
                ProducerType.MULTI,
                new BlockingWaitStrategy());
        disruptor.handleEventsWithWorkerPool(
            new Consumer(),
            new Consumer(),
            new Consumer(),
            new Consumer());
        disruptor.start();

        RingBuffer<PCData> ringBuffer = disruptor.getRingBuffer();
        Producer producer = new Producer(ringBuffer);
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0; true; l++) {
            bb.putLong(0, l);
            producer.pushData(bb);
            Thread.sleep(100);
            System.out.printf("add data %d\n", l);
        }
    }
}