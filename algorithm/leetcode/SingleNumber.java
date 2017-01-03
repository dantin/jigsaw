public class SingleNumber {

    public int singleNumber(int [] nums) {
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            target ^= nums[i];
        }
        return target;
    }

    public static void main(String[] args) {
        SingleNumber solution = new SingleNumber();
        System.out.println(solution.singleNumber(new int[] {5, 3, 6, 9, 5, 9, 3}));
    }
}