public class MajorityElement {

    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(candidate == nums[i]) {
                count++;
            } else {
                count--;
                if(count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();
        System.out.println(solution.majorityElement(new int[] {1, 1, 1, 0, 3}));
    }
}