public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while(current != null) {
             head = current;
             current = current.next;
             head.next = prev;
             prev = head;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        head.next = a;
        a.next = b;

        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode n = solution.reverseList(head);

        while(n != null) {
            System.out.print(n.val);
            if(n.next != null) {
                System.out.print(" --> ");
            } else {
                System.out.println();
            }
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