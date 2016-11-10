public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int val = getBalanced(root);
        if(val == -1) return false;
        return true;
    }

    private int getBalanced(TreeNode node) {
        if(node == null) return 0;
        int left = getBalanced(node.left);
        if(left == -1) return -1;
        int right = getBalanced(node.right);
        if(right == -1) return -1;
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left + 1, right + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        root.left = a;
        root.right = b;
        a.left = c;

        BalancedBinaryTree solution = new BalancedBinaryTree();
        System.out.println(solution.isBalanced(root));
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