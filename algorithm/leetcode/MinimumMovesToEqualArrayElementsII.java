import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class MinimumMovesToEqualArrayElementsII {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length/2];
        int sum = 0;
        for(int x : nums) {
            sum += Math.abs(x - mid);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};

        System.out.println(Arrays.toString(nums));
        MinimumMovesToEqualArrayElementsII solution = new MinimumMovesToEqualArrayElementsII();
        System.out.printf("%d's move\n", solution.minMoves2(nums));
    }
}