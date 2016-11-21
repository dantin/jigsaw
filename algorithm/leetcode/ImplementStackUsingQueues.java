import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        final int length = 5;
        MyStack stack = new MyStack();
        for (int i = 0; i < length; i++) {
            stack.push(i);
        }

        for (int i = 0; i < length; i++) {
            System.out.print(stack.top());
            stack.pop();
            if (!stack.empty()) {
                System.out.print(", ");
            } else {
                System.out.println();
            }
        }
    }
}

class MyStack {

    private Queue<Integer> q = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        q.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int size = q.size();
        for(int i = 1; i < size; i++) {
            q.offer(q.poll());
        }
        q.poll();
    }

    // Get the top element.
    public int top() {
        int size = q.size();
        for(int i = 1; i < size; i++) {
            q.offer(q.poll());
        }
        int top = q.peek();
        q.offer(q.poll());
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}

class MyStack2 {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        q2.offer(x);
        while(!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
    }

    // Removes the element on top of the stack.
    public void pop() {
        q1.poll();
    }

    // Get the top element.
    public int top() {
        return q1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}

class MyStack1 {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        q1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        q1.poll();

        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
    }

    // Get the top element.
    public int top() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int top = q1.peek();
        q2.offer(q1.poll());

        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;

        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}
