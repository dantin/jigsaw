import java.util.List;
import java.util.LinkedList;

public class GenerateParentheses {

    public List<String> generateParentheses(int n) {
        List<String> ans = new LinkedList<>();
        StringBuilder sample = new StringBuilder();

        dfs(ans, sample, n, n);
        return ans;
    }

    private void dfs(List<String> collection, StringBuilder sample, int left, int right) {
        if (left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            collection.add(sample.toString());
            return;
        }

        if (left > 0) {
            sample.append('(');
            dfs(collection, sample, left - 1, right);
            int last = sample.length() - 1;
            sample.deleteCharAt(last);
        }

        if (right > 0) {
            sample.append(')');
            dfs(collection, sample, left, right - 1);
            int last = sample.length() - 1;
            sample.deleteCharAt(last);
        }
    }

    public static void main(String[] args) {
        int n = 3;

        GenerateParentheses solution = new GenerateParentheses();
        solution.generateParentheses(n).forEach(System.out::println);
    }
}