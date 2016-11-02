import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int x : nums1) {
            if(freqMap.containsKey(x)) {
                int count = freqMap.get(x);
                freqMap.put(x, count + 1);
            } else {
                freqMap.put(x, 1);
            }
        }
        List<Integer> intersection = new LinkedList<>();
        for(int x : nums2) {
            int count = 0;
            if((count = freqMap.getOrDefault(x, 0)) > 0) {
                intersection.add(x);
                freqMap.put(x, count - 1);
            }
        }

        int[] result = new int[intersection.size()];
        for(int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArraysII solution = new IntersectionOfTwoArraysII();
        Arrays.stream(solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})).forEach(System.out::println);
    }
}