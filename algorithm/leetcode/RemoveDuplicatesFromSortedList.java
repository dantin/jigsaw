public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode h = head;
        while(h != null) {
            if(h.next != null && h.val == h.next.val) {
                h.next = h.next.next;
            } else {
                h = h.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        head.next = n1;
        n1.next = n2;
        travel(head);

        RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();
        head = solution.deleteDuplicates(head);
        travel(head);
    }

    private static void travel(ListNode head) {
        while(head != null) {
            System.out.print(head.val);
            if(head.next != null) System.out.print("->");
            else System.out.println();
            head = head.next;
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