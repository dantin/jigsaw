import java.util.Arrays;
import java.util.List;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int remaining = 0;

        while (l1 != null || l2 != null || remaining != 0) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (remaining != 0) {
                sum += remaining;
            }

            ListNode n = new ListNode(sum % 10);
            remaining = sum / 10;
            if (head == null) {
                head = n;
                tail = n;
            } else {
                tail.next = n;
                tail = tail.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();
        List<Integer> seq1 = Arrays.asList(2, 4, 3);
        List<Integer> seq2 = Arrays.asList(5, 6, 4);
        ListNode n1 = solution.create(seq1);
        ListNode n2 = solution.create(seq2);
        solution.travel(n1);
        solution.travel(n2);
        ListNode result = solution.addTwoNumbers(n1, n2);
        solution.travel(result);
    }

    private void travel(ListNode n) {
        while (n != null) {
            System.out.printf("%d ", n.val);
            n = n.next;
        }
        System.out.println();
    }

    private ListNode create(List<Integer> numbers) {
        ListNode head = null;
        ListNode tail = null;
        int i = 0;
        for (Integer number : numbers) {
            ListNode n = new ListNode(number);
            if (head == null) {
                head = n;
            }
            if (tail == null) {
                tail = n;
            } else {
                tail.next = n;
                tail = tail.next;
            }
        }

        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
