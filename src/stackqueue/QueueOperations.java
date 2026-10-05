package stackqueue;

/**
 * Queue implemented using a circular array.
 * Supports enqueue, dequeue, peek/front, and display. Handles empty queue conditions.
 */
public class QueueOperations {

    private int[] data;
    private int front, rear, size, capacity;

    public QueueOperations(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == capacity; }

    /** Adds a value to the rear of the queue. Returns false if the queue is full. */
    public boolean enqueue(int value) {
        if (isFull()) {
            System.out.println("Error: Queue is full. Cannot enqueue " + value + ".");
            return false;
        }
        rear = (rear + 1) % capacity;
        data[rear] = value;
        size++;
        return true;
    }

    /** Removes and returns the front value. Returns Integer.MIN_VALUE if empty. */
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Error: Queue is empty. Cannot dequeue.");
            return Integer.MIN_VALUE;
        }
        int value = data[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    /** Returns the front value without removing it. */
    public int peek() {
        if (isEmpty()) {
            System.out.println("Error: Queue is empty. Cannot peek.");
            return Integer.MIN_VALUE;
        }
        return data[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue (front -> rear): ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(data[index]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println();
    }
}