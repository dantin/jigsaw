import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        List<List<Integer>> res = new LinkedList<>();
        while (queue.size() > 0) {
            LinkedList<TreeNode> sons = new LinkedList<>();
            List<Integer> level = new LinkedList<>();
            while (queue.size() > 0) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) sons.add(node.left);
                if (node.right != null) sons.add(node.right);
            }
            queue = sons;
            if (level.size() > 0) res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode a = new TreeNode(9);
        TreeNode b = new TreeNode(20);
        TreeNode c = new TreeNode(15);
        TreeNode d = new TreeNode(7);
        root.left = a;
        root.right = b;
        b.left = c;
        b.right = d;

        BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
        System.out.println(solution.levelOrder(root));
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
