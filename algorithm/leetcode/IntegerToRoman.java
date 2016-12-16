import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

    private static final String[] symbol = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] values = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public String intToRoman(int num) {
        StringBuilder buffer = new StringBuilder();
        int i = 0;
        while(num > 0 && i < symbol.length) {
            while(num >= values[i]) {
                int count = num / values[i];
                num %= values[i];
                for(int j = 0; j < count; j++)
                    buffer.append(symbol[i]);
            }
            i++;
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        int num = 2048;

        IntegerToRoman solution = new IntegerToRoman();
        System.out.printf("%d: %s\n", num, solution.intToRoman(num));
    }
}