/**
 * java -Xmx64M -Xms64M -XX:+PrintGCDetails -XX:+UseSerialGC AllocEden
 */
public class AllocEden {
    public static final int _1K = 1024;

    public static void main(String[] args) {
        for (int i = 0; i < 5 * _1K; i++) {
            byte[] b = new byte[_1K];
        }
    }
}