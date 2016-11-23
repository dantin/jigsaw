import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode pa = headA;
        ListNode pb = headB;

        ListNode ta = null;
        ListNode tb = null;
        while(true) {
            if(pa == null) pa = headB;
            if(pb == null) pb = headA;

            if(pa.next == null) ta = pa;
            if(pb.next == null) tb = pb;

            if(ta != null && tb != null && ta != tb) return null;
            if(pa == pb) return pa;

            pa = pa.next;
            pb = pb.next;
        }
    }

    public static void main(String[] args) {
        List<Integer> elements = Arrays.asList(1, 2, 3, 4, 5, 6);
        ListNode headB = createList(elements);
        ListNode headA = new ListNode(9);
        ListNode t = new ListNode(8);
        headA.next = t;
        t.next = headB.next.next.next;

        System.out.print("List A: ");travel(headA);
        System.out.print("List B: ");travel(headB);

        IntersectionOfTwoLinkedLists solution = new IntersectionOfTwoLinkedLists();
        ListNode intersection = solution.getIntersectionNode(headA, headB);
        if(intersection != null) {
            System.out.println("Intersection node: " + intersection.val);
        } else {
            System.out.println("NO intersection node!");
        }
    }

    private static ListNode createList(List<Integer> elements) {
        ListNode head = null;
        ListNode tail = null;

        for(Integer x : elements) {
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