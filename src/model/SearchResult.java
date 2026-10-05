package model;

/**
 * Holds the outcome and performance info of a search operation.
 */
public class SearchResult {
    private final boolean found;
    private final int index;
    private final int steps;

    public SearchResult(boolean found, int index, int steps) {
        this.found = found;
        this.index = index;
        this.steps = steps;
    }

    public boolean isFound() { return found; }
    public int getIndex() { return index; }
    public int getSteps() { return steps; }

    @Override
    public String toString() {
        return found
                ? "Found at index " + index + " (steps taken: " + steps + ")"
                : "Not found (steps taken: " + steps + ")";
    }
}