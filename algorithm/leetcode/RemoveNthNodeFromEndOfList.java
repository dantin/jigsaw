import java.util.Arrays;
import java.util.List;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthNodeFromEndOfList(ListNode head, int n) {
        ListNode cur = head;
        int step = 0;
        while(step < n && cur != null) {
            cur = cur.next;
            step++;
        }
        if(step == n && cur == null) {
            head = head.next;
            return head;
        }
        
        ListNode prev = head;
        while(cur != null && cur.next != null) {
            cur = cur.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = toList(Arrays.asList(1, 2));
        travel(head);

        int n = 1;
        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
        head = solution.removeNthNodeFromEndOfList(head, n);
        travel(head);
    }

    private static ListNode toList(List<Integer> contents) {
        ListNode head = null;
        ListNode tail = null;
        for (Integer x : contents) {
            ListNode node = new ListNode(x);
            if (tail == null) {
                head = node;
                tail = head;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        return head;
    }

    private static void travel(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print("->");
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