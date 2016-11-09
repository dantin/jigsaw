import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        if(pattern == null && str == null) return true;
        if(pattern == null || str == null) return false;
        String[] tokens = str.split("\\s+");
        if(tokens.length != pattern.length()) return false;
        Map<Comparable, Integer> map = new HashMap<>();
        for(int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            char c = pattern.charAt(i);
            System.out.println(token + " " + c);
            if(!Objects.equals(map.put(c, i), map.put(token, i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat dog";

        WordPattern solution = new WordPattern();
        System.out.println(solution.wordPattern(pattern, str));
    }
}