import java.util.List;
import java.util.LinkedList;

public class DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (ch) {
                        case '+':
                            ans.add(l + r);
                            break;
                        case '-':
                            ans.add(l - r);
                            break;
                        case '*':
                            ans.add(l * r);
                            break;
                        }
                    }
                }
            }
        }

        if (ans.size() == 0) {
            ans.add(Integer.parseInt(input));
        }
        return ans;
    }

    public static void main(String[] args) {
        String input = "2*3-4*5";

        DifferentWaysToAddParentheses solution = new DifferentWaysToAddParentheses();
        System.out.println(solution.diffWaysToCompute(input));
    }
}