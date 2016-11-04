public class MergeTwoSortedLists {

    public ListNode mergeTowSortedLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = null;
        ListNode tail = null;

        while(l1 != null && l2 != null) {
            ListNode n = null;
            if(l1.val <= l2.val) {
                n = l1;
                l1 = l1.next;
            } else {
                n = l2;
                l2 = l2.next;
            }
            if(head == null) {
                head = n;
                tail = n;
            } else {
                tail.next = n;
                tail = n;
            }
        }

        if(l1 != null) tail.next = l1;
        if(l2 != null) tail.next = l2;

        return head;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        traval(a1);
        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(3);
        b1.next = b2;
        traval(b1);

        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNode r = solution.mergeTowSortedLists(a1, b1);
        traval(r);
    }

    private static void traval(ListNode h) {
        while(h != null) {
            System.out.print(h.val);
            if(h.next != null) System.out.print("->");
            else System.out.println();
            h = h.next;
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