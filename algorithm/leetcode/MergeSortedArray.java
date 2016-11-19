import java.util.Arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m , int[] nums2, int n) {
        if(n == 0) return;
        if(m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }

        int pos = m + n;
        int i = m - 1;
        int j = n - 1;

        while(pos > 0 && i >= 0 && j >= 0) {
            if(nums1[i] < nums2[j]) {
                nums1[--pos] = nums2[j--];
            } else {
                nums1[--pos] = nums1[i--];
            }
        }
   
        if(j != -1) System.arraycopy(nums2, 0, nums1, 0, j + 1);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 4, 5, 6};
        int[] nums2 = new int[]{3};
        int[] nums = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, nums, 0, nums1.length);

        System.out.println("nums1:  " + Arrays.toString(nums));
        System.out.println("nums2:  " + Arrays.toString(nums2));

        MergeSortedArray solution = new MergeSortedArray();
        solution.merge(nums, nums1.length, nums2, nums2.length);
        System.out.println("merged: " + Arrays.toString(nums));
    }
}