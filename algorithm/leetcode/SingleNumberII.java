import java.util.Arrays;

public class SingleNumberII {

    public int singleNumber(int[] nums) {
        int num = 0;
        int[] bits = new int[32];
        for(int i = 0; i < 32; i++) {
            for(int j = 0; j < nums.length; j++) {
                bits[i] += (nums[j] >> i) & 1;
                bits[i] %= 3;
            }
            num |= (bits[i] << i);
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 3, 3};
        System.out.println("Input: " + Arrays.toString(nums));
        SingleNumberII solution = new SingleNumberII();
        System.out.printf("%d\n", solution.singleNumber(nums));
    }
}