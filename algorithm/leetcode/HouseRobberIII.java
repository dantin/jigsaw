import java.util.Arrays;
import java.util.List;

public class HouseRobberIII {

    public int rob(TreeNode root) {
        if (root == null) return 0;
        int val = 0;
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(root.val + val, rob(root.left) + rob(root.right));
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(3, 2, 3, null, 3, null, 1);
        TreeNode root = toTree(input);

        HouseRobberIII solution = new HouseRobberIII();
        System.out.println(solution.rob(root));
    }

    private static TreeNode toTree(List<Integer> input) {
        if (input == null || input.isEmpty()) return null;

        TreeNode[] array = new TreeNode[input.size()];
        for (int i = 0; i < array.length; i++) {
            if (input.get(i) != null) {
                array[i] = new TreeNode(input.get(i));
            } else {
                array[i] = null;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) continue;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < array.length) array[i].left = array[left];
            if (right < array.length) array[i].right = array[right];
        }

        return array[0];
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