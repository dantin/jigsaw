import java.util.HashMap;
import java.util.Map;

/**
 * java -Xmx32M -Xms32M -XX:+UseSerialGC -XX:+PrintGCDetails PretenureSizeTreshold
 *
 * default use TLAB
 * java -Xmx32M -Xms32M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:PretenureSizeThreshold=1000 PretenureSizeTreshold
 *
 * No use TLAB
 * java -Xmx32M -Xms32M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:PretenureSizeThreshold=1000 -XX:-UseTLAB PretenureSizeTreshold
 */
public class PretenureSizeTreshold {
    public static final int _1K = 1024;

    public static void main(String[] args) {
        Map<Integer, byte[]> map = new HashMap<>();
        for (int i = 0; i < 5 * _1K; i++) {
            byte[] b = new byte[_1K];
            map.put(i, b);
        }
    }
}