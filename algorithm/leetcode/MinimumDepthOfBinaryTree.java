import java.util.Arrays;
import java.util.List;

public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if(left == 0 || right == 0) return Math.max(left, right) + 1;
        return Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2);
        TreeNode root = toTree(input);

        MinimumDepthOfBinaryTree solution = new MinimumDepthOfBinaryTree();

        System.out.println("Minimum Depth of Tree: " + solution.minDepth(root));
    }

    private static TreeNode toTree(List<Integer> input) {
        if(input == null || input.size() == 0) return null;

        TreeNode[] nArray = new TreeNode[input.size()];
        for(int i = 0; i < nArray.length; i++) {
            if(input.get(i) != null)
                nArray[i] = new TreeNode(input.get(i));
            else
                nArray[i] = null;
        }
        for(int i = 0; i < nArray.length; i++) {
            if(nArray[i] == null) continue;
            int left = 2 * (i + 1) - 1;
            int right = 2 * (i + 1);
            if(left < nArray.length) nArray[i].left = nArray[left];
            if(right < nArray.length) nArray[i].right = nArray[right];
        }

        return nArray[0];
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