import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new LinkedList<>();
        Deque<Integer> stack = new LinkedList<>();

        dfs(k, n, 1, stack, ans);

        return ans;
    }

    private void dfs(int k, int n, int level, Deque<Integer> stack, List<List<Integer>> ans) {
        if (n < 0) return;
        if (n == 0 && stack.size() == k) {
            List<Integer> copy = new LinkedList<>(stack);
            Collections.sort(copy);
            ans.add(copy);
        }
        for (int i = level; i < 10; i++) {
            stack.push(i);
            dfs(k, n - i, i + 1, stack, ans);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 9;

        CombinationSumIII solution = new CombinationSumIII();
        solution.combinationSum3(k, n).forEach(System.out::println);
    }
}