import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public boolean containsDuplicate(int[] nums, int k) {
        Map<Integer, Integer> freqs = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int freq = 0;

            if(i > k) {
                int out = nums[i - k - 1];
                freq = freqs.getOrDefault(out, 0);
                if(--freq == 0) {
                    freqs.remove(out);
                } else {
                    freqs.put(out, freq);
                }
            }

            if(freqs.containsKey(num)) {
                freq = freqs.get(num);
                freqs.put(num, ++freq);
                if(freq > 1) return true;
            } else {
                freqs.put(num, 1);
            }

        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1};
        int k = 1;

        ContainsDuplicateII solution = new ContainsDuplicateII();
        System.out.println(Arrays.toString(nums));
        System.out.println("k: " + k);
        System.out.printf("%s duplicates.\n", solution.containsDuplicate(nums, k) ? "Contains" : "Not contains");
    }
}