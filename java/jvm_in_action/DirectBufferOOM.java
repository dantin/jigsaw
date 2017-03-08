import java.nio.ByteBuffer;

/**
 * java -XX:MaxDirectMemorySize=1m DirectBufferOOM
 */
public class DirectBufferOOM {
    public static void main(String[] args) {
        for (int i = 0; i < 1024; i++) {
            ByteBuffer.allocateDirect(1024 * 1024);
            System.out.println(i);
        }
    }
}