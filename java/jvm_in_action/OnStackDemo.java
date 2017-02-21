/**
 * 默认开启栈上分配
 *
 * java -server -Xmx10m -Xms10m -XX:+PrintGC OnStackDemo
 * java -server -Xmx10m -Xms10m -XX:+DoEscapeAnalysis -XX:-UseTLAB -XX:+EliminateAllocations -XX:+PrintGC OnStackDemo
 *
 * 区别
 *
 * java -server -Xmx10m -Xms10m -XX:-DoEscapeAnalysis -XX:-UseTLAB -XX:-EliminateAllocations -XX:+PrintGC OnStackDemo
 */
public class OnStackDemo {

    public static class User {
        public int id = 0;
        public String name = "";
    }

    public static void alloc() {
        User u = new User();
        u.id = 5;
        u.name = "dd";
    }

    public static void main(String[] args) {
        long b = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long e = System.currentTimeMillis();
        System.out.println(e - b);
    }
}