/**
 * java -Xmx20m -Xms5m -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:+UseSerialGC HeapAlloc
 */
public class HeapAlloc {
    public static void main(String[] args) {
        memory();

        byte[] b = new byte[1 * 1024 * 1024];
        System.out.println("分配1M空间");

        memory();

        b = new byte[4 * 1024 * 1024];
        System.out.println("分配4M空间");

        memory();
    }

    private static void memory() {
        System.out.printf("max memory:   %d bytes\n", Runtime.getRuntime().maxMemory());
        System.out.printf("free memory:  %d bytes\n", Runtime.getRuntime().freeMemory());
        System.out.printf("total memory: %d bytes\n", Runtime.getRuntime().totalMemory());
    }
}