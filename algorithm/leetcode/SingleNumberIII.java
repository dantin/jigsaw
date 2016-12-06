import java.util.Arrays;

public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }

        int mark = 0;
        for(int i = 0; i < 32; i++) {
            if(((xor >> i) & 1) == 1) {
                mark = i;
            }
        }

        int half = 0;
        for(int i = 0; i < nums.length; i++) {
            if(((nums[i] >> mark) & 1) == 1) {
                half ^= nums[i];
            }
        }

        return new int[]{xor ^ half, half};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 3, 2, 5};

        System.out.println(Arrays.toString(nums));
        SingleNumberIII solution = new SingleNumberIII();
        System.out.println(Arrays.toString(solution.singleNumber(nums)));
    }
}