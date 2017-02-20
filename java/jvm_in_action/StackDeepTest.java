/**
 * java -Xss256k StackDeepTest
 *
 * 256K: deep of calling = 2486
 * 512K: deep of calling = 8906
 */
public class StackDeepTest {
    private static int count = 0;

    public static void recursion() {
        count++;
        recursion();
    }

    public static void main(String[] args) {
        try {
            recursion();
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("deep of calling = " + count);
        }
    }
}