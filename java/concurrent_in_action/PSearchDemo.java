import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class PSearchDemo {
    static int[] array;

    static ExecutorService pool = Executors.newCachedThreadPool();
    static final int THREAD_NUM = 2;
    static AtomicInteger result = new AtomicInteger(-1);

    public static int search(int target, int begin, int end) {
        int i = 0;
        for (i = begin; i < end; i++) {
            if (result.get() >= 0) {
                return result.get();
            }
            if (target == array[i]) {
                if (!result.compareAndSet(-1, i)) {
                    return result.get();
                }
                return i;
            }
        }
        return -1;
    }

    public static class SearchTask implements Callable<Integer> {

        private int begin, end, target;

        public SearchTask(int target, int begin, int end) {
            this.target = target;
            this.begin = begin;
            this.end = end;
        }

        @Override
        public Integer call() {
            return search(target, begin, end);
        }
    }

    public static int pSearch(int target) throws InterruptedException, ExecutionException {
        int subArraySize = array.length / THREAD_NUM + 1;
        List<Future<Integer>> re = new ArrayList<Future<Integer>>();
        for (int i = 0; i < array.length; i += subArraySize) {
            int end = i + subArraySize;
            if (end >= array.length) end = array.length;
            re.add(pool.submit(new SearchTask(target, i, end)));
        }
        for (Future<Integer> r : re) {
            if (r.get() >= 0) return r.get();
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        array = new int[] {3, 2, 4, 5, 9, 7, 8, 1, 13, 24};
        System.out.println(pSearch(4));
        pool.shutdown();
    }
}