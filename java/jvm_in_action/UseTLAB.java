/**
 * java -XX:+UseTLAB -Xcomp -XX:-BackgroundCompilation -XX:-DoEscapeAnalysis -server UseTLAB
 *
 * java -XX:-UseTLAB -Xcomp -XX:-BackgroundCompilation -XX:-DoEscapeAnalysis -server UseTLAB
 *
 * java -XX:+UseTLAB -XX:+PrintTLAB -XX:+PrintGC -XX:TLABSize=102400 -XX:-ResizeTLAB -XX:TLABRefillWasteFraction=100 -XX:-DoEscapeAnalysis -server -XX:+UseSerialGC UseTLAB
 */
public class UseTLAB {

    private static void alloc() {
        byte[] b = new byte[2];
        b[0] = 1;
    }

    public static void main(String[] args) {
        long b = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
        long e = System.currentTimeMillis();
        System.out.println(e - b);
    }
}