import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size() > 0) {
            LinkedList<TreeNode> sons = new LinkedList<>();
            while(queue.size() > 0) {
                TreeNode node = queue.poll();
                if(node == null) continue;
                sons.add(node.left);
                sons.add(node.right);
            }

            int i = 0;
            int j = sons.size() - 1;

            while(i < j && i < sons.size() && j >= 0) {
                if(
                    (sons.get(i) == null && sons.get(j) == null) || 
                    (sons.get(i) != null && sons.get(j) != null && sons.get(i).val == sons.get(j).val)) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
            queue = sons;
        }
        return true;
    }

    /*
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null) return right == null;
        if(right == null) return left == null;
        if(left.val != right.val) return false;
        if(!isSymmetric(left.left, right.right)) return false;
        if(!isSymmetric(left.right, right.left)) return false;
        return true;
    }
    */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(3);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;

        SymmetricTree solution = new SymmetricTree();
        System.out.println(solution.isSymmetric(root));
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