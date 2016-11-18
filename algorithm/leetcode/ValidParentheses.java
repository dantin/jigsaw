import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {

    public boolean isValid(String s) {
        String left = "([{";
        String right = ")]}";

        Deque<Character> stack = new ArrayDeque<>();
        int pos;

        for (char c : s.toCharArray()) {
            if (left.indexOf(c) != -1) {
                stack.push(c);
            } else {
                Character x = stack.peek();
                if (x != null && (pos = left.indexOf(x)) != -1 && c == right.charAt(pos)) {
                    stack.pop();
                } else return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "]";

        ValidParentheses solution = new ValidParentheses();
        System.out.printf("%s %s valid.\n", s, solution.isValid(s) ? "is" : "is NOT");
    }
}