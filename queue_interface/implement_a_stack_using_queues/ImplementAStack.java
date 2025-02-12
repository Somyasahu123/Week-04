package queue_interface.implement_a_stack_using_queues;

import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueues {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    // Push element to stack
    public void push(int x) {
        queue1.add(x);
    }

    // Pop element from stack
    public int pop() {
        if (queue1.isEmpty()) return -1; // Stack is empty

        while (queue1.size() > 1) {
            queue2.add(queue1.poll()); // Move all except last element
        }

        int topElement = queue1.poll(); // Last element is popped

        // Swap queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    // Get top element
    public int top() {
        if (queue1.isEmpty()) return -1;

        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        int topElement = queue1.peek(); // Get the top element
        queue2.add(queue1.poll()); // Move it to queue2

        // Swap queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top Element: " + stack.top()); // 3
        System.out.println("Popped Element: " + stack.pop()); // 3
        System.out.println("Top Element: " + stack.top()); // 2
    }
}

