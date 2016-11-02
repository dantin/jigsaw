import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class RomanToInteger {

    private static final Map<Character, Integer> numbers = Collections.unmodifiableMap(new HashMap<Character, Integer>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    });

    public int romanToInteger(String s) {
        int sum = 0;
        int prev = 0;
        int i = s.length();
        while(i > 0) {
            int n = numbers.get(s.charAt(--i));
            System.out.println(n);

            int sig = (n < prev) ? -1 : 1;
            sum += sig * n;
            prev = n;
        }
        
        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger solution = new RomanToInteger();
        System.out.println(solution.romanToInteger("IX"));
    }
}