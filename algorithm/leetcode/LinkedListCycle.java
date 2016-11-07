public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            if(fast == null || slow == null) break;
            fast = fast.next;
            if(fast != null) fast = fast.next;
            else break;
            slow = slow.next;
            if(fast == slow) return true;
        } while(fast != slow);
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        head.next = a;
        a.next = b;
        b.next = head;

        LinkedListCycle solution = new LinkedListCycle();
        System.out.println(solution.hasCycle(head));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}