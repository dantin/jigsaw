import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PSortDemo {
    /**
     * bubble sort
     */
    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * insert sort
     */
    public static void insertSort(int[] array) {
        int length = array.length;
        int i, j, key;
        for (i = 1; i < length; i++) {
            key = array[i];
            j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    /**
     * serial odd even sort from bubble sort
     */
    public static void oddEvenSort(int[] array) {
        int start = 0;
        boolean exchangeFlag = true;
        while (exchangeFlag == true || start == 1) {
            exchangeFlag = false;
            for (int i = start; i < array.length - 1; i += 2) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    exchangeFlag = true;
                }

            }
            if (start == 0) {
                start = 1;
            } else {
                start = 0;
            }
        }
    }

    static int[] array;
    static boolean exchangeFlag = true;

    static ExecutorService pool = Executors.newCachedThreadPool();
    static synchronized void setExchangeFlag(boolean flag) {
        exchangeFlag = flag;
    }
    static synchronized boolean getExchangeFlag() {
        return exchangeFlag;
    }
    public static class OddEvenSortTask implements Runnable {
        int i;
        CountDownLatch latch;
        public OddEvenSortTask(int i, CountDownLatch latch) {
            this.i = i;
            this.latch = latch;
        }
        @Override
        public void run() {
            if (array[i] > array[i + 1]) {
                int tmp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = tmp;
                setExchangeFlag(true);
            }
            latch.countDown();
        }
    }

    /**
     * parallel odd even sort
     */
    public static void pOddEvenSort(int[] array) throws InterruptedException {
        int start = 0;
        while (getExchangeFlag() == true || start == 1) {
            setExchangeFlag(false);
            CountDownLatch latch = new CountDownLatch(array.length / 2 - (array.length % 2 == 0 ? start : 0));
            for (int i = start; i < array.length - 1; i += 2) {
                pool.submit(new OddEvenSortTask(i, latch));
            }
            latch.await();
            if (start == 0) {
                start = 1;
            } else {
                start = 0;
            }
        }
    }

    /**
     * shell sort
     */
    public static void shellSort(int[] array) {
        int h = 1;
        while (h <= array.length / 3) {
            h = 3 * h + 1;
        }

        while (h > 0) {
            for (int i = h; i < array.length; i++) {
                if (array[i] < array[i - h]) {
                    int key = array[i];
                    int j = i - h;
                    while (j >= 0 && array[j] > key) {
                        array[j + h] = array[j];
                        j -= h;
                    }
                    array[j + h] = key;
                }
            }
            h = (h - 1) / 3;
        }
    }

    public static class ShellSortTask implements Runnable {
        int i = 0;
        int h = 0;
        CountDownLatch latch;

        public ShellSortTask(int i, int h, CountDownLatch latch) {
            this.i = i;
            this.h = h;
            this.latch = latch;
        }
        @Override
        public void run() {
            if (array[i] < array[i - h]) {
                int key = array[i];
                int j = i - h;
                while (j >= 0 && array[j] > key) {
                    array[j + h] = array[j];
                    j -= h;
                }
                array[j + h] = key;
            }
            latch.countDown();
        }
    }

    /**
     * parallel shell short
     */
    public static void pShellSort(int[] array) throws InterruptedException {
        int h = 1;
        CountDownLatch latch = null;
        while (h <= array.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            System.out.printf("h=%d\n", h);
            if (h > 4) {
                latch = new CountDownLatch(array.length - h);
            }
            for (int i = h; i < array.length; i++) {
                if (h > 4) {
                    pool.execute(new ShellSortTask(i, h, latch));
                } else {
                    if (array[i] < array[i - h]) {
                        int key = array[i];
                        int j = i - h;
                        while (j >= 0 && array[j] > key) {
                            array[j + h] = array[j];
                            j -= h;
                        }
                        array[j + h] = key;
                    }
                }
            }
            latch.await();
            h = (h - 1) / 3;
        }

    }
}