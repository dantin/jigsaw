import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        List<Integer> ans = new LinkedList<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                ans.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            cur = cur.right;
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, null, 2, null, null, 3);
        TreeNode root = toTree(input);

        BinaryTreePreorderTraversal solution = new BinaryTreePreorderTraversal();
        System.out.println(solution.preorderTraversal(root));
    }

    private static TreeNode toTree(List<Integer> input) {
        if(input == null || input.isEmpty()) return null;

        TreeNode[] array = new TreeNode[input.size()];
        for(int i = 0; i < array.length; i++) {
            if(input.get(i) != null) {
                array[i] = new TreeNode(input.get(i));
            } else {
                array[i] = null;
            }
        }
        for(int i = 0; i < array.length; i++) {
            if(array[i] == null) continue;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if(left < array.length) array[i].left = array[left];
            if(right < array.length) array[i].right = array[right];
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