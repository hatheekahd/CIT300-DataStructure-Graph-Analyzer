package array;

import java.util.Arrays;

/**
 * Dynamic integer array supporting insert, delete, search and display.
 */
public class IntArrayList {

    private int[] data;
    private int size;

    public IntArrayList() {
        data = new int[10];
        size = 0;
    }

    public int getSize() { return size; }
    public boolean isEmpty() { return size == 0; }

    /** Inserts a value at the end of the array. */
    public void insert(int value) {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2); // resize
        }
        data[size++] = value;
    }

    /** Deletes the first occurrence of a value. Returns true if deleted. */
    public boolean delete(int value) {
        int index = indexOf(value);
        if (index == -1) return false;
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return true;
    }

    /** Linear index lookup used internally by delete. */
    private int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) return i;
        }
        return -1;
    }

    /** Simple presence search (not the algorithmic demo search). */
    public boolean search(int value) {
        return indexOf(value) != -1;
    }

    public void display() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Array: [");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    /** Returns a copy of the current elements (used by searching/graph modules). */
    public int[] toArray() {
        return Arrays.copyOf(data, size);
    }

    /** Returns a sorted copy (needed for binary search demonstration). */
    public int[] toSortedArray() {
        int[] copy = toArray();
        Arrays.sort(copy);
        return copy;
    }
}