import java.util.Arrays;
import java.util.List;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;

        ListNode odd = head, oddHead = head;
        ListNode even = head.next, evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return oddHead;
    }

    public static void main(String[] args) {
        ListNode head = makeList(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        print(head);

        OddEvenLinkedList solution = new OddEvenLinkedList();
        head = solution.oddEvenList(head);
        print(head);
    }

    private static ListNode makeList(List<Integer> list) {
        ListNode head = null, tail = null;

        for (Integer x : list) {
            ListNode node = new ListNode(x);
            if (tail == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        return head;
    }

    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print("->");
            }
            head = head.next;
        }
        System.out.println();
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}