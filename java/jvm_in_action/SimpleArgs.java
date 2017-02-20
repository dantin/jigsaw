/**
 * java -Xmx32m SimpleArgs
 */
public class SimpleArgs {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.printf("参数(%d): %s\n", i, args[i]);
        }
        System.out.printf("-Xmx %dM\n", Runtime.getRuntime().maxMemory() / 1000 / 1000);
    }
}