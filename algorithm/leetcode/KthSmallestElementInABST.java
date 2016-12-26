import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class KthSmallestElementInABST {

    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        int target = 0;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            count++;
            if (k == count) return cur.val;
            cur = cur.right;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, null, 3, null, null, 2);
        TreeNode root = toTree(input);

        KthSmallestElementInABST solution = new KthSmallestElementInABST();
        System.out.println(solution.kthSmallest(root, 2));
    }

    private static TreeNode toTree(List<Integer> input) {
        if (input == null || input.isEmpty()) return null;

        TreeNode[] array = new TreeNode[input.size()];
        for (int i = 0; i < array.length; i++) {
            if (input.get(i) != null) {
                array[i] = new TreeNode(input.get(i));
            } else {
                array[i] = null;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) continue;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < array.length) array[i].left = array[left];
            if (right < array.length) array[i].right = array[right];
        }

        return array[0];
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}