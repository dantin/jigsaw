/**
 * 反编译class文件
 * javap -v Synchronized
 */
public class Synchronized {
    public static void main(String[] args) {
        synchronized (Synchronized.class) {
        }
        m();
    }

    public static synchronized void m() {
    }
}