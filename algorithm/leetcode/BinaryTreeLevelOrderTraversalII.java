import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.add(root);
        }

        while(queue.size() > 0) {
            Queue<TreeNode> sons = new LinkedList<>();
            List<Integer> level = new ArrayList<>();
            while(queue.size() > 0) {
                TreeNode n = queue.poll();
                level.add(n.val);
                if(n.left != null) sons.add(n.left);
                if(n.right != null) sons.add(n.right);
            }

            if(level.size() > 0) levels.add(level);
            queue = sons;
        }

        Collections.reverse(levels);
        return levels;
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

        BinaryTreeLevelOrderTraversalII solution = new BinaryTreeLevelOrderTraversalII();
        solution.levelOrderBottom(root).forEach((x) -> {
            x.forEach(System.out::print);
            System.out.println();
        });
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