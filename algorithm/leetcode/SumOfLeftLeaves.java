import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        int current = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            if (node.left != null && node.left.left == null && node.left.right == null) {
                sum += node.left.val;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;

        SumOfLeftLeaves solution = new SumOfLeftLeaves();
        System.out.println(solution.sumOfLeftLeaves(root));
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
