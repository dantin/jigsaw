import java.util.Queue;
import java.util.LinkedList;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        Queue<Character> queue = new LinkedList<>();
        for(char x : s.toCharArray()) {
            queue.offer(x);
        }

        for(char x : t.toCharArray()) {
            if(!queue.isEmpty() && queue.peek() == x) {
                queue.poll();
            }
        }
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        String s = "";
        String t = "ahbgdc";

        System.out.printf("s = %s\n", s);
        System.out.printf("t = %s\n", t);
        IsSubsequence solution = new IsSubsequence();
        System.out.printf("s %s subsequence of t\n", solution.isSubsequence(s, t) ? "is" : "is NOT");
    }
}