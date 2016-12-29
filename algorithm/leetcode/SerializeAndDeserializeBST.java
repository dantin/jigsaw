import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class SerializeAndDeserializeBST {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(5, 2, 7, 1, 3, 6, 8, null, null, null, 4);
        TreeNode root = toTree(input);

        Codec codec = new Codec();

        String encodedString = codec.serialize(root);
        System.out.println(encodedString);
        TreeNode decodedRoot = codec.deserialize(encodedString);
        preOrder(decodedRoot);
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

    private static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> order = new LinkedList<>();
        preOrder(root, order);
        StringBuilder buf = new StringBuilder();
        Iterator<Integer> iter = order.iterator();
        while (iter.hasNext()) {
            buf.append(iter.next());
            if (iter.hasNext()) buf.append(",");
        }
        return buf.toString();
    }

    private void preOrder(TreeNode root, List<Integer> order) {
        if (root == null) return;
        order.add(root.val);
        preOrder(root.left, order);
        preOrder(root.right, order);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;

        LinkedList<TreeNode> nstack = new LinkedList<>();
        Deque<Integer> rstack = new LinkedList<>();
        rstack.add(Integer.MAX_VALUE);
        for (String s : data.split(",")) {
            int val = Integer.parseInt(s);
            // System.out.println("current value: " + val);
            TreeNode node = new TreeNode(val);

            if (!nstack.isEmpty()) {
                TreeNode ntop = nstack.peek();
                if (val < ntop.val) {
                    ntop.left = node;
                    rstack.push(ntop.val);
                } else {
                    // System.out.println(val + ", " +rstack.peek());
                    while (val > rstack.peek()) {
                        // System.out.println(nstack.size());
                        while (nstack.get(0).val > nstack.get(1).val) {
                            nstack.pop();
                        }
                        rstack.pop();
                        nstack.pop();
                    }
                    nstack.peek().right = node;
                }
            }
            nstack.push(node);

            // System.out.println(nstack);
            // System.out.println(rstack);
            // System.out.println();
        }
        // System.out.println(nstack.peekLast().val);
        return nstack.peekLast();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}