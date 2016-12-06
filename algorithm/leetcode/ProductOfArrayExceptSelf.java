import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        long product = 1L;
        for(int i = 0; i < nums.length; i++) {
            output[i] = (int)product;
            product *= nums[i];
        }
        product = 1L;
        for(int i = nums.length - 1; i >=0; i--) {
            output[i] *= (int)product;
            product *= nums[i];
        }

        return output;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(nums));
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(solution.productExceptSelf(nums)));
    }
}