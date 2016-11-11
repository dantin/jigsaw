import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class BinaryTreePath {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        if (root == null) return paths;
        
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        if (left.size() == 0 && right.size() == 0) {
            paths.add(String.valueOf(root.val));
            return paths;
        } else {
            left.addAll(right);
            for (int i = 0; i < left.size(); i++) {
                StringBuilder buf = new StringBuilder();
                buf.append(root.val);
                buf.append("->");
                buf.append(left.get(i));
                paths.add(buf.toString());
            }
        }

        return paths;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(5);
        root.left = a;
        root.right = b;
        a.right = c;

        BinaryTreePath solution = new BinaryTreePath();
        System.out.println(solution.binaryTreePaths(root));
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