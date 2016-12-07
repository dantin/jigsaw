import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkedListRandomNode {
    public static void main(String[] args) {
        // Init a singly linked list [1,2,3].
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Solution solution = new Solution(head);

        // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
        System.out.println(solution.getRandom());
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class Solution {
    private ListNode head;
    private Random random = new Random();

    Solution(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int res = head.val;
        int i = 2;
        ListNode cur = head.next;
        while(cur != null) {
            int r = random.nextInt(i);
            if(r == 0) res = cur.val;
            ++i;
            cur = cur.next;
        }
        return res;
    }

}