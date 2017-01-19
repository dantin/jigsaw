import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {
    public static void main(String[] args) throws Exception {
        File file = new File("/tmp/filelock.test");
        FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
        LockRunnable lockRunnable = new LockRunnable(channel);
        Thread thread = new Thread(lockRunnable);
        thread.start();

        while (thread.isAlive()) {
            lockRunnable.stopExecuting();
        }

        FileLock lock = channel.tryLock();
        System.out.println("OK");
        lock.release();
    }
}

class LockRunnable implements Runnable {
    FileChannel channel;
    private volatile boolean execute;

    public LockRunnable(FileChannel fc) {
        channel = fc;
    }

    public void stopExecuting() {
        this.execute = false;
    }

    @Override
    public void run() {
        FileLock lock = null;
        try {
            lock = channel.tryLock();
            // channel.lock();
            while (this.execute) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // release file lock
            //
            // java.nio.channels.OverlappingFileLockException
            if (lock != null) {
                try {
                    lock.release();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}