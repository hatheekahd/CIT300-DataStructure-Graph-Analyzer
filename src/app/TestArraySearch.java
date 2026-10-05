package app;

import array.IntArrayList;
import model.SearchResult;
import searching.SearchOperations;

public class TestArraySearch {
    public static void main(String[] args) {
        IntArrayList list = new IntArrayList();
        int[] values = {45, 12, 78, 3, 90, 23, 56, 1, 67, 34};
        for (int v : values) list.insert(v);

        System.out.println("--- Array Operations ---");
        list.display();
        System.out.println("Search 78 present: " + list.search(78));
        System.out.println("Delete 12: " + list.delete(12));
        list.display();

        System.out.println("\n--- Searching Comparison ---");
        int[] unsorted = list.toArray();
        int[] sorted = list.toSortedArray();
        int target = 90;

        SearchResult linear = SearchOperations.linearSearch(unsorted, target);
        SearchResult binary = SearchOperations.binarySearch(sorted, target);

        System.out.println("Linear Search for " + target + ": " + linear);
        System.out.println("Binary Search for " + target + ": " + binary);
        System.out.println("(Binary search usually takes fewer steps because the array is sorted.)");
    }
}