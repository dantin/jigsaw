public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int len = 0;
        while(i < nums.length) {
            if(nums[i] == val) i++;
            else nums[len++] = nums[i++];
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        int value = 3;

        RemoveElement solution = new RemoveElement();
        System.out.println(solution.removeElement(nums, value));
    }
}