import java.util.Arrays;

public class MoveZeroes {

    public void moveZeros(int[] nums) {
        int i = 0;
        int seek = 0;
        while(seek < nums.length) {
            if(nums[seek] != 0) {
                nums[i++] = nums[seek];
            }
            seek++;
        }
        for(seek = i; seek < nums.length; seek++) {
            nums[seek] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};

        MoveZeroes solution = new MoveZeroes();
        solution.moveZeros(nums);
        Arrays.stream(nums).forEach(i -> System.out.print(i + " "));
    }
}