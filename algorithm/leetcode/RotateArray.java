import java.util.Arrays;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while(i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        int k = 1;

        System.out.println("Array:  " + Arrays.toString(nums));
        RotateArray solution = new RotateArray();
        solution.rotate(nums, k);
        System.out.println("Rotate: " + Arrays.toString(nums));
    }
}