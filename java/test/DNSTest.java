import java.net.InetAddress;
import java.net.UnknownHostException;

public class DNSTest {

    private static final String TEST_HOST = "s1-esf-test.esf.fdd";

    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run() {
                while(true) {
                    try {
                        System.out.println(InetAddress.getByName(TEST_HOST));
                        Thread.sleep(1000);
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        t.start();
    }
}