import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class TraceCanReliveObj {

    public static TraceCanReliveObj obj;

    static ReferenceQueue<TraceCanReliveObj> phantomQueue = null;

    public static class CheckRefQueue extends Thread {
        @Override
        public void run() {
            while (true) {
                if (phantomQueue != null) {
                    PhantomReference<TraceCanReliveObj> obj = null;
                    try {
                        obj = (PhantomReference<TraceCanReliveObj>) phantomQueue.remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (obj != null) {
                        System.out.println("TraceCanReliveObj is deleted by GC");
                    }
                }
            }
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("TraceCanReliveObj finalize called");
        obj = this;
    }

    @Override
    public String toString() {
        return "I am TraceCanReliveObj";
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new CheckRefQueue();
        t.setDaemon(true);
        t.start();

        phantomQueue = new ReferenceQueue<TraceCanReliveObj>();
        obj = new TraceCanReliveObj();
        PhantomReference<TraceCanReliveObj> phantomRef = new PhantomReference<>(obj, phantomQueue);

        obj = null;
        System.gc();
        Thread.sleep(1000);
        if (obj == null) {
            System.out.println("obj为null");
        } else {
            System.out.println("obj可用");
        }
        System.out.println("第2次GC");
        obj = null;
        System.gc();
        Thread.sleep(1000);
        if (obj == null) {
            System.out.println("obj为null");
        } else {
            System.out.println("obj可用");
        }
    }
}