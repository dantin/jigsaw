public class DaemonTest {
    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run() {
                while(true) {
                    ;
                }
            }
        };
        t.setDaemon(true);
        t.start();
    }
}