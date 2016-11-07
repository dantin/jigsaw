public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode current = null;
        ListNode first = null;
        ListNode second = null;
        ListNode tail = null;

        while (head != null) {
            first = head;
            second = first != null ? first.next : first;
            head = second != null ? second.next : first.next;

            if(tail != null) {
                tail.next = (second != null) ? second : first;
            }
            if(second != null) second.next = first;
            tail = first;
            tail.next = null;
            if (current == null) current = second == null ? first : second;
        }


        return current;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        head.next = a;
        a.next = b;
        b.next = c;
        traverse(head);

        SwapNodesInPairs solution = new SwapNodesInPairs();
        ListNode res = solution.swapPairs(head);
        traverse(res);

    }

    private static void traverse(ListNode n) {
        while (n != null) {
            System.out.print(n.val);
            if (n.next != null) System.out.print("->");
            else System.out.println();
            n = n.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}