import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestorOfABinarySearchTree {

    private boolean find(TreeNode root, TreeNode target, Deque<TreeNode> stack) {
        if(root == null) return false;
        if(root == target) {
            stack.push(root);
            return true;
        }
        
        if(find(root.left, target, stack)) {stack.push(root); return true;}
        if(find(root.right, target, stack)) {stack.push(root); return true;}
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> sp = new ArrayDeque<>();
        Deque<TreeNode> sq = new ArrayDeque<>();
        
        find(root, p, sp);
        find(root, q, sq);

        TreeNode ancestor = null;
        while(sp.size() > 0 && sq.size() > 0) {
            TreeNode ph = sp.pop();
            TreeNode qh = sq.pop();
            if(ph == qh) ancestor = ph;
        }

        return ancestor;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(8);
        TreeNode c = new TreeNode(0);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(9);
        TreeNode g = new TreeNode(3);
        TreeNode h = new TreeNode(5);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        d.left = g;
        d.right = h;

        TreeNode p = a;
        TreeNode q = d;

        LowestCommonAncestorOfABinarySearchTree solution = new LowestCommonAncestorOfABinarySearchTree();
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        System.out.printf("LCA: %d\n", lca.val);
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