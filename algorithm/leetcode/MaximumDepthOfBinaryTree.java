import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        int depth = 0;
        Queue<Element> queue = new LinkedList<>();
        queue.add(new Element(root, depth));

        while(queue.size() > 0) {
            Element e = queue.poll();
            if(e.level > depth)
                depth = e.level;
            if(e.node.left != null) queue.add(new Element(e.node.left, e.level + 1));
            if(e.node.right != null) queue.add(new Element(e.node.right, e.level + 1));
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);

        root.left = a;
        root.right = b;
        b.right = c;

        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();
        System.out.println(solution.maxDepth(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Element {
    TreeNode node;
    int level;

    Element(TreeNode e, int level) {
        this.node = e;
        this.level = level;
    }
} 