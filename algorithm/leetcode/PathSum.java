import java.util.Arrays;
import java.util.List;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return sum == 0;
        System.out.println(root.val);
        if(sum - root.val == 0 && root.left == null && root.right == null) return true;
        // if(sum - root.val < 0) return false;
        if(root.left != null && hasPathSum(root.left, sum - root.val)) return true;
        if(root.right != null && hasPathSum(root.right, sum - root.val)) return true;

        return false;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(-2, null, -3);
        TreeNode root = toTree(input);
        int sum = -5;

        PathSum solution = new PathSum();
        System.out.println(solution.hasPathSum(root, sum));
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