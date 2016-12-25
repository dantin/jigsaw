import java.util.Arrays;

public class ReconstructOriginalDigitsFromEnglish {

    public String originalDigits(String s) {
        int[] cache = new int[128];
        for (char c : s.toCharArray()) {
            cache[c]++;
        }
        int[] nums = new int[10];
        nums[0] = cache['z'];
        nums[2] = cache['w'];
        nums[4] = cache['u'];
        nums[6] = cache['x'];
        nums[8] = cache['g'];
        nums[1] = cache['o'] - nums[0] - nums[2] - nums[4];
        nums[3] = cache['h'] - nums[8];
        nums[5] = cache['f'] - nums[4];
        nums[7] = cache['s'] - nums[6];
        nums[9] = cache['i'] - nums[6] - nums[8] - nums[5];

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i]; j++) {
                ans.append(i);
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "egith";

        System.out.println("Input: " + s);
        ReconstructOriginalDigitsFromEnglish solution = new ReconstructOriginalDigitsFromEnglish();
        System.out.println(solution.originalDigits(s));
    }
}