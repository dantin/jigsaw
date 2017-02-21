/**
 * java -XX:+PrintGC LocalVarGcDemo
 */
public class LocalVarGcDemo {

    public void localvarGc1() {
        byte[] a = new byte[6 * 1024 * 1024];
        System.gc();
    }

    public void localvarGc2() {
        byte[] a = new byte[6 * 1024 * 1024];
        a = null;
        System.gc();
    }

    public void localvarGc3() {
        {
            byte[] a = new byte[6 * 1024 * 1024];
        }
        System.gc();
    }

    public void localvarGc4() {
        {
            byte[] a = new byte[6 * 1024 * 1024];
        }
        int c = 10;
        System.gc();
    }

    public void localvarGc5() {
        localvarGc1();
        System.gc();
    }

    public static void main(String[] args) {
        LocalVarGcDemo demo = new LocalVarGcDemo();
        System.out.println("GC 1");
        demo.localvarGc1();
        System.out.println("GC 2");
        demo.localvarGc2();
        System.out.println("GC 3");
        demo.localvarGc3();
        System.out.println("GC 4");
        demo.localvarGc4();
        System.out.println("GC 5");
        demo.localvarGc5();
    }
}