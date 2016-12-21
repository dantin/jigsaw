public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        int sum = 0;

        ListNode head = null, tail = null;
        while(l1 != null || l2 != null || sum != 0) {
            int num1 = 0, num2 = 0;

            if(l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }

            sum += num1 + num2;
            ListNode node = new ListNode(sum % 10);
            sum /= 10;
            if(head == null) {
                tail = node;
                head = tail;
            } else {
                tail.next = node;
                tail = tail.next;
            }
        }

        return reverse(head);
    }

    private ListNode toListNode(int value) {
        ListNode head = null, tail = null;
        while(value != 0) {
            ListNode node = new ListNode(value%10);
            value /= 10;
            if(head == null) {
                tail = node;
                head = tail;
            } else {
                tail.next = node;
                tail = tail.next;
            }
        }

        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        int num1 = 7243;
        int num2 = 564;

        AddTwoNumbersII solution = new AddTwoNumbersII();
        ListNode l1 = solution.toListNode(num1);
        ListNode l2 = solution.toListNode(num2);

        print(l1);
        print(l2);

        print(solution.addTwoNumbers(l1, l2));
    }

    private static void print(ListNode head) {
        while(head != null) {
            System.out.print(head.val);
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