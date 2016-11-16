import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;

        int[] is = toIntPattern(s.toCharArray());
        int[] it = toIntPattern(t.toCharArray());

        return Arrays.equals(is, it);
    }

    private int[] toIntPattern(char[] s) {
        int code = 0;
        Map<Character, Integer> cp = new HashMap<>();
        int[] pattern = new int[s.length];

        for(int i = 0; i < s.length; i++) {
            char c = s[i];
            if(!cp.containsKey(c)) {
                cp.put(c, code++);
            }
            pattern[i] = cp.get(c);
        }

        return pattern;
    }

    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";

        IsomorphicStrings solution = new IsomorphicStrings();
        System.out.println("String[1]: " + s);
        System.out.println("String[2]: " + t);
        System.out.printf("They %s isomorphic string.\n", solution.isIsomorphic(s, t) ? "are" : "are NOT");
    }
}