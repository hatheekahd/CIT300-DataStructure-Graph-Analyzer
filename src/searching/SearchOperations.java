package searching;

import model.SearchResult;

/**
 * Linear and binary search implementations with step counting,
 * used to demonstrate algorithmic complexity differences.
 */
public class SearchOperations {

    /** Linear search: checks each element one by one. O(n). */
    public static SearchResult linearSearch(int[] arr, int target) {
        int steps = 0;
        for (int i = 0; i < arr.length; i++) {
            steps++;
            if (arr[i] == target) {
                return new SearchResult(true, i, steps);
            }
        }
        return new SearchResult(false, -1, steps);
    }

    /** Binary search: array MUST be sorted first. O(log n). */
    public static SearchResult binarySearch(int[] sortedArr, int target) {
        int steps = 0;
        int low = 0, high = sortedArr.length - 1;
        while (low <= high) {
            steps++;
            int mid = (low + high) / 2;
            if (sortedArr[mid] == target) {
                return new SearchResult(true, mid, steps);
            } else if (sortedArr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new SearchResult(false, -1, steps);
    }
}