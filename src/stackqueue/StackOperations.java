package stackqueue;

/**
 * Stack implemented using an array.
 * Supports push, pop, peek, and display. Handles empty stack conditions.
 */
public class StackOperations {

    private int[] data;
    private int top;
    private int capacity;

    public StackOperations(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        this.top = -1;
    }

    public boolean isEmpty() { return top == -1; }
    public boolean isFull() { return top == capacity - 1; }

    /** Pushes a value onto the stack. Returns false if the stack is full. */
    public boolean push(int value) {
        if (isFull()) {
            System.out.println("Error: Stack is full. Cannot push " + value + ".");
            return false;
        }
        data[++top] = value;
        return true;
    }

    /** Removes and returns the top value. Returns Integer.MIN_VALUE if empty (caller should check isEmpty first). */
    public int pop() {
        if (isEmpty()) {
            System.out.println("Error: Stack is empty. Cannot pop.");
            return Integer.MIN_VALUE;
        }
        return data[top--];
    }

    /** Returns the top value without removing it. */
    public int peek() {
        if (isEmpty()) {
            System.out.println("Error: Stack is empty. Cannot peek.");
            return Integer.MIN_VALUE;
        }
        return data[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack (top -> bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(data[i]);
            if (i > 0) System.out.print(", ");
        }
        System.out.println();
    }
}