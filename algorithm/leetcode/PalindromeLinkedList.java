import java.util.Arrays;
import java.util.List;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;

        // find middle
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse tail part
        ListNode p = slow.next;
        ListNode last = null;
        while(p != null) {
            ListNode next = p.next;
            p.next = last;
            last = p;
            p = next;
        }

        // check palindrome
        ListNode p1 = head;
        ListNode p2 = last;
        travel(p1);
        travel(p2);
        while(p2 != null && p1.val == p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }

        // resume tail part
        p = last;
        last = null;
        while(p != null) {
            ListNode next = p.next;
            p.next = last;
            last = p;
            p = next;
        }
        // re-union list
        slow.next = last;

        return p2 == null;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1);
        ListNode head = toList(nums);

        System.out.print("Raw List: "); travel(head);

        PalindromeLinkedList solution = new PalindromeLinkedList();
        System.out.printf("%s palindrome linked list\n", solution.isPalindrome(head) ? "Is" : "Is NOT");
    }

    private static ListNode toList(List<Integer> nums) {
        ListNode head = null;
        ListNode tail = null;
        for(Integer x : nums) {
            ListNode node = new ListNode(x);
            if(tail == null) {
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
        while(head != null) {
            System.out.print(head.val);
            if(head.next != null) {
                System.out.print("->");
            } else {
                System.out.println();
            }
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