import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        List<Integer> ans = new LinkedList<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, null, 2, null, null,3);
        TreeNode root = toTree(input);
        BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();
        System.out.println(solution.inorderTraversal(root));
    }

    private static TreeNode toTree(List<Integer> input) {
        if(input == null || input.size() == 0) return null;

        TreeNode[] nArray = new TreeNode[input.size()];
        for(int i = 0; i < nArray.length; i++) {
            if(input.get(i) != null) {
                nArray[i] = new TreeNode(input.get(i));
            } else {
                nArray[i] = null;
            }
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