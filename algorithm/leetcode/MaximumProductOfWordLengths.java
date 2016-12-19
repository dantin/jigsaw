public class MaximumProductOfWordLengths {

    public int maximumProductOfWordLengths(String[] words) {
        int ans = 0;
        int[] mask = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            for(char c : words[i].toCharArray()) {
                mask[i] |= 1 << (c - 'a');
            }
            for(int j = 0; j < i; j++) {
                if((mask[i] & mask[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"};

        MaximumProductOfWordLengths solution = new MaximumProductOfWordLengths();
        System.out.println(solution.maximumProductOfWordLengths(words));
    }
}