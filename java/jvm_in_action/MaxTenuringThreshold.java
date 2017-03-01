import java.util.HashMap;
import java.util.Map;

/**
 * java -Xmx1G -Xms1G -XX:+PrintGCDetails -XX:MaxTenuringThreshold=15 -XX:+PrintHeapAtGC -XX:+UseSerialGC MaxTenuringThreshold
 * java -Xmx1G -Xms1G -XX:+PrintGCDetails -XX:MaxTenuringThreshold=15 -XX:TargetSurvivorRatio=15 -XX:+PrintHeapAtGC -XX:+UseSerialGC MaxTenuringThreshold
 */
public class MaxTenuringThreshold {
    public static final int _1M = 1024 * 1024;
    public static final int _1K = 1024;

    public static void main(String[] args) {
        Map<Integer, byte[]> map = new HashMap<>();
        for (int i = 0; i < 5 * _1K; i++) {
            byte[] b = new byte[_1K];
            map.put(i, b);
        }

        for (int i = 0; i < 17; i++) {
            for (int k = 0; k < 270; k++) {
                byte[] b = new byte[_1M];
            }
        }
    }
}