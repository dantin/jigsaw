import java.util.HashMap;
import java.util.Map;

public class HashMapMultiThread {
    static Map<String, String> map = new HashMap<>();

    public static class AddThread implements Runnable {

        private int start;

        public AddThread(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            for(int i = start; i < 100000; i += 2) {
                map.put(Integer.toString(i), Integer.toBinaryString(i));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread even = new Thread(new AddThread(0));
        Thread odd = new Thread(new AddThread(1));
        even.start();
        odd.start();
        even.join();
        odd.join();
        System.out.println(map.size());
    }
}