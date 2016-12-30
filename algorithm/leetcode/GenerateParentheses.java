import java.util.List;
import java.util.LinkedList;

public class GenerateParentheses {

    public List<String> generateParentheses(int n) {
        List<String> ans = new LinkedList<>();
        String sample = new String();

        dfs(ans, sample, n, n);
        return ans;
    }

    private void dfs(List<String> collection, String sample, int left, int right) {
        if (left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            collection.add(sample.toString());
            return;
        }

        if (left > 0) {
            dfs(collection, sample + "(", left - 1, right);
        }

        if (right > 0) {
            dfs(collection, sample + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;

        GenerateParentheses solution = new GenerateParentheses();
        solution.generateParentheses(n).forEach(System.out::println);
    }
}