import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        // Collections.addAll(set, nums1);
        for(int i = 0; i < nums1.length; i++)
            set.add(nums1[i]);
        Set<Integer> r = new HashSet<>();
        for(int i = 0; i < nums2.length; i++)
            if(set.contains(nums2[i])) r.add(nums2[i]);
        int[] result = new int[r.size()];
        int i = 0;
        for(Integer x : r) {
            result[i++] = x;
        }
        return result;
    }
    public static void main(String[] args) {
        IntersectionOfTwoArrays solution = new IntersectionOfTwoArrays();
        Arrays.stream(solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})).forEach(System.out::println);
    }
}