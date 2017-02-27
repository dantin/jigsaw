import java.util.Vector;

/**
 * java -Xmx20m -Xms5m -XX:+HeapDumpOnOutOfMemoryError DumpOOM
 * java -Xmx20m -Xms5m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./a.dump DumpOOM
 */
public class DumpOOM {
    public static void main(String[] args) {
        Vector<byte[]> v = new Vector<>();
        for (int i = 0; i < 25; i++) {
            v.add(new byte[1 * 1024 * 1024]);
        }
    }
}