import java.util.ArrayList;
import java.util.List;

/**
 * java -Xmx50M SimpleHeapOOM
 */
public class SimpleHeapOOM {
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 1024; i++) {
            list.add(new byte[1024 * 1024]);
        }
    }
}