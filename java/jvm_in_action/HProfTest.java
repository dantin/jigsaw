public class HProfTest {
    public void slowMethod() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void slowerMethod() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fastMethod() {
        Thread.yield();
    }

    public static void main(String[] args) {
        HProfTest test = new HProfTest();
        test.fastMethod();
        test.slowMethod();
        test.slowerMethod();
    }
}