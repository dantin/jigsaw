/**
 * 串行GC
 *
 * java -XX:+PrintGCDetails -XX:+UseSerialGC ScavengeBeforeFullGC
 *
 * 并行GC：并行GC前额外触发新生代GC
 *
 * java -XX:+PrintGCDetails -XX:+UseParallelOldGC ScavengeBeforeFullGC
 * java -XX:+PrintGCDetails -XX:+UseParallelOldGC -XX:-ScavengeBeforeFullGC ScavengeBeforeFullGC
 */
public class ScavengeBeforeFullGC {
    public static void main(String[] args) {
        System.gc();
    }
}