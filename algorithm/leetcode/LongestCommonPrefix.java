import java.util.Arrays;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        StringBuilder buf = new StringBuilder();
        for(int pos = 0; pos < strs[0].length(); pos++) {
            for(int i = 1; i < strs.length; i++) {
                if(pos >= strs[i].length() || strs[0].charAt(pos) != strs[i].charAt(pos)) {
                    return buf.toString();
                }
            }
            buf.append(strs[0].charAt(pos));
        }

        return buf.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[] {
            "abab",
            "aba",
            "a"
        };

        System.out.println("Strings: " + Arrays.toString(strs));
        LongestCommonPrefix solution = new LongestCommonPrefix();
        System.out.printf("LCP: %s\n", solution.longestCommonPrefix(strs));
    }
}