/**
 * java -Xmx10M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath="f.dump" LongFinalize
 */
public class LongFinalize {
    public static class LF {
        private byte[] content = new byte[512];

        // @Override
        // protected void finalize() {
        //     try {
        //         System.out.println(Thread.currentThread().getId());
        //         Thread.sleep(1000);
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        // }
    }

    public static void main(String[] args) {
        long b = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            LF f = new LF();
        }
        long e = System.currentTimeMillis();
        System.out.println(e - b);
    }
}