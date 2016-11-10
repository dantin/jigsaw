import java.util.Stack;

public class ImplementQueueUsingStacks {

    public static void main(String[] args) {
        final int length = 5;
        MyQueue queue = new MyQueue();
        for(int i = 0; i < length; i++) {
            queue.push(i + 1);
        }

        for(int i = 0; i < length; i++) {
            System.out.print(queue.peek());
            queue.pop();
            if(!queue.empty())
                System.out.print(", ");
            else
                System.out.println();
        }
    }
}

class MyQueue {

    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        in.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(out.empty()) {
            while(!in.empty()) {
                out.push(in.pop());
            }
        }
        out.pop();
    }

    // Get the front element.
    public int peek() {
        if(out.empty()) {
            while(!in.empty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return in.empty() && out.empty();
    }
}

class MyQueue1 {

    Stack<Integer> stack = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        while(!stack.empty()) {
            temp.push(stack.pop());
        }
        stack.push(x);
        while(!temp.empty()) {
            stack.push(temp.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.empty();
    }
}