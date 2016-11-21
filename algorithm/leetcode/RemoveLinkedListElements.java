import java.util.Arrays;
import java.util.List;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode h = null;
        ListNode tail = null;

        while(head != null) {

            if(head.val == val) {
                head = head.next;
                continue;
            }

            if(tail == null) {
                h = head;
                tail = h;
            } else {
                tail.next = head;
                tail = tail.next;
            }
            head = head.next;
        }
        if(tail != null && tail.next != null) tail.next = null;

        return h;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 6, 3, 4, 5, 6);
        ListNode head = toList(nums);
        int target = 6;

        System.out.print("Linked List: ");
        travel(head);
        RemoveLinkedListElements solution = new RemoveLinkedListElements();
        ListNode nodes = solution.removeElements(head, target);
        System.out.printf("After Remove %d: ", target);
        travel(nodes);
    }

    private static ListNode toList(List<Integer> elements) {
        ListNode head = null;
        ListNode tail = null;
        for (Integer x : elements) {
            ListNode node = new ListNode(x);
            if (tail == null) {
                head = node;
                tail = head;
            } else {
                tail.next = node;
                tail = tail.next;
            }
        }

        return head;
    }

    private static void travel(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null)
                System.out.print("->");
            else
                System.out.println();
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