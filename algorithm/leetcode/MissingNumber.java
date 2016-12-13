import java.util.Arrays;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int xor = 0;
        for(int i = 0; i < nums.length; i++) {
            xor ^= i;
            xor ^= nums[i];
        }
        xor ^= nums.length;
        return xor;
    }

    public int missingNumber2(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += i;
            sum -= nums[i];
        }
        sum += nums.length;
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 3};
        System.out.println(Arrays.toString(nums));

        MissingNumber solution = new MissingNumber();
        System.out.printf("missing %d\n", solution.missingNumber(nums));
    }
}