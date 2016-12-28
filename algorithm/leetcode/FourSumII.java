import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FourSumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> cache = new HashMap<>();
        int ans = 0;
        int key;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                key = A[i] + B[j];
                if (cache.containsKey(key)) {
                    cache.put(key, cache.get(key) + 1);
                } else {
                    cache.put(key, 1);
                }
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                key = -1 * (C[i] + D[j]);
                ans += cache.getOrDefault(key, 0);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = new int[] {1, 2};
        int[] B = new int[] { -2, -1};
        int[] C = new int[] { -1, 2};
        int[] D = new int[] {0, 2};

        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
        System.out.println(Arrays.toString(C));
        System.out.println(Arrays.toString(D));

        FourSumII solution = new FourSumII();
        System.out.println(solution.fourSumCount(A, B, C, D));
    }
}