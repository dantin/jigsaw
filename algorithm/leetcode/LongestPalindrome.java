public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] charFreqs = new int[26 * 2];
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z') {
                charFreqs[c - 'a'] += 1;
            }
            if(c >= 'A' && c <= 'Z') {
                charFreqs[c - 'A' + 26] += 1;
            }
        }

        int sum = 0;
        boolean hasOdd = false;
        for(int i = 0; i < charFreqs.length; i++) {
            if(charFreqs[i] % 2 == 0) sum += charFreqs[i];
            else {

                sum += charFreqs[i] - 1;
                hasOdd = true;
            }
        }
        return hasOdd ? sum + 1 : sum;
    }

    public static void main(String[] args) {
        LongestPalindrome solution = new LongestPalindrome();
        System.out.println(solution.longestPalindrome("aaaAaaaa"));
    }
}