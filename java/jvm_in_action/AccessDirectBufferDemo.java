import java.nio.ByteBuffer;

public class AccessDirectBufferDemo {

    public void directAccess() {
        long starttime = System.currentTimeMillis();
        ByteBuffer b = ByteBuffer.allocateDirect(500);
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 99; j++) {
                b.putInt(j);
            }
            b.flip();
            for (int j = 0; j < 99; j++) {
                b.getInt();
            }
            b.clear();
        }
        long endtime = System.currentTimeMillis();
        System.out.printf("direct memory read/write: %d ms\n", endtime - starttime);
    }

    public void bufferAccess() {
        long starttime = System.currentTimeMillis();
        ByteBuffer b = ByteBuffer.allocate(500);
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 99; j++) {
                b.putInt(j);
            }
            b.flip();
            for (int j = 0; j < 99; j++) {
                b.getInt();
            }
            b.clear();
        }
        long endtime = System.currentTimeMillis();
        System.out.printf("heap memory read/write: %d ms\n", endtime - starttime);
    }

    public static void main(String[] args) {
        AccessDirectBufferDemo demo = new AccessDirectBufferDemo();
        demo.bufferAccess();
        demo.directAccess();

        demo.bufferAccess();
        demo.directAccess();
    }
}