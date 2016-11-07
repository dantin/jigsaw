public class MinimumMovesToEqualArrayElements {

    public int minMoves(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int min = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < min) min = nums[i];
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i] - min;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        MinimumMovesToEqualArrayElements solution = new MinimumMovesToEqualArrayElements();
        System.out.println(solution.minMoves(nums));
    }
}