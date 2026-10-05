package app;

import stackqueue.StackOperations;
import stackqueue.QueueOperations;

public class TestStackQueue {
    public static void main(String[] args) {
        System.out.println("--- Stack Operations ---");
        StackOperations stack = new StackOperations(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        stack.display();

        // empty stack test
        StackOperations emptyStack = new StackOperations(3);
        emptyStack.pop();
        emptyStack.peek();

        System.out.println("\n--- Queue Operations ---");
        QueueOperations queue = new QueueOperations(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.display();
        System.out.println("Front: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        queue.display();

        // empty queue test
        QueueOperations emptyQueue = new QueueOperations(3);
        emptyQueue.dequeue();
        emptyQueue.peek();
    }
}