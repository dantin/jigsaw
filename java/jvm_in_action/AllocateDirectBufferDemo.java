import java.nio.ByteBuffer;

public class AllocateDirectBufferDemo {

    public void allocateDirect() {
        long starttime = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            ByteBuffer b = ByteBuffer.allocateDirect(1000);
        }
        long endtime = System.currentTimeMillis();
        System.out.printf("direct allocation: %d ms\n", endtime - starttime);
    }

    public void allocateHeap() {
        long starttime = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            ByteBuffer b = ByteBuffer.allocate(1000);
        }
        long endtime = System.currentTimeMillis();
        System.out.printf("heap allocation: %d ms\n", endtime - starttime);
    }

    public static void main(String[] args) {
        AllocateDirectBufferDemo demo = new AllocateDirectBufferDemo();
        demo.allocateHeap();
        demo.allocateDirect();

        demo.allocateHeap();
        demo.allocateDirect();
    }
}