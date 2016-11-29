import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int x) {
        Integer top = min.peek();
        int num = (top == null) ? x : Math.min(top, x);
        stack.push(x);
        min.push(num);
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}