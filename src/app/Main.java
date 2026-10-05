package app;

import java.util.Scanner;

import array.IntArrayList;
import graph.GraphOperations;
import linkedlist.LinkedListOperations;
import model.SearchResult;
import searching.SearchOperations;
import stackqueue.QueueOperations;
import stackqueue.StackOperations;

/**
 * Data Structure and Graph Performance Analyzer.
 * Menu-driven console application integrating array, stack, queue,
 * linked list, searching and graph components.
 */
public class Main {

    private static final Scanner sc = new Scanner(System.in);

    private static final IntArrayList array = new IntArrayList();
    private static final StackOperations stack = new StackOperations(20);
    private static final QueueOperations queue = new QueueOperations(20);
    private static final LinkedListOperations list = new LinkedListOperations();
    private static final GraphOperations graph = new GraphOperations();

    // last performance results, for option 8 "Display All Results"
    private static SearchResult lastLinear, lastBinary;
    private static java.util.List<String> lastBfs, lastDfs;

    public static void main(String[] args) {
        int choice;
        do {
            printMainMenu();
            choice = readInt("Enter your choice: ", 1, 9);
            switch (choice) {
                case 1: arrayMenu(); break;
                case 2: stackMenu(); break;
                case 3: queueMenu(); break;
                case 4: linkedListMenu(); break;
                case 5: searchingMenu(); break;
                case 6: graphMenu(); break;
                case 7: performanceComparison(); break;
                case 8: displayAllResults(); break;
                case 9: System.out.println("Goodbye!"); break;
            }
        } while (choice != 9);
    }

    private static void printMainMenu() {
        System.out.println("\n=============================================");
        System.out.println(" DATA STRUCTURE & GRAPH ANALYZER");
        System.out.println("=============================================");
        System.out.println("1. Array Operations");
        System.out.println("2. Stack Operations");
        System.out.println("3. Queue Operations");
        System.out.println("4. Linked List Operations");
        System.out.println("5. Searching Operations");
        System.out.println("6. Graph Operations");
        System.out.println("7. Performance Comparison");
        System.out.println("8. Display All Results");
        System.out.println("9. Exit");
    }

    // ---------- Input helpers ----------

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(line);
                if (v >= min && v <= max) return v;
                System.out.println("Please enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static int readAnyInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    private static String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Input cannot be empty.");
        }
    }

    // ---------- 1. Array ----------

    private static void arrayMenu() {
        int choice;
        do {
            System.out.println("\n--------------- ARRAY OPERATIONS ------------");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            choice = readInt("Enter your choice: ", 1, 5);
            switch (choice) {
                case 1 -> array.insert(readAnyInt("Enter value to insert: "));
                case 2 -> {
                    int v = readAnyInt("Enter value to delete: ");
                    System.out.println(array.delete(v) ? "Deleted." : "Value not found.");
                }
                case 3 -> {
                    int v = readAnyInt("Enter value to search: ");
                    System.out.println(array.search(v) ? "Found in array." : "Not found.");
                }
                case 4 -> array.display();
            }
        } while (choice != 5);
    }

    // ---------- 2. Stack ----------

    private static void stackMenu() {
        int choice;
        do {
            System.out.println("\n--------------- STACK OPERATIONS ------------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            choice = readInt("Enter your choice: ", 1, 5);
            switch (choice) {
                case 1 -> stack.push(readAnyInt("Enter value to push: "));
                case 2 -> {
                    if (!stack.isEmpty()) System.out.println("Popped: " + stack.pop());
                    else stack.pop(); // prints its own empty-stack error
                }
                case 3 -> {
                    if (!stack.isEmpty()) System.out.println("Top: " + stack.peek());
                    else stack.peek();
                }
                case 4 -> stack.display();
            }
        } while (choice != 5);
    }

    // ---------- 3. Queue ----------

    private static void queueMenu() {
        int choice;
        do {
            System.out.println("\n--------------- QUEUE OPERATIONS ------------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek/Front");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            choice = readInt("Enter your choice: ", 1, 5);
            switch (choice) {
                case 1 -> queue.enqueue(readAnyInt("Enter value to enqueue: "));
                case 2 -> {
                    if (!queue.isEmpty()) System.out.println("Dequeued: " + queue.dequeue());
                    else queue.dequeue();
                }
                case 3 -> {
                    if (!queue.isEmpty()) System.out.println("Front: " + queue.peek());
                    else queue.peek();
                }
                case 4 -> queue.display();
            }
        } while (choice != 5);
    }

    // ---------- 4. Linked List ----------

    private static void linkedListMenu() {
        int choice;
        do {
            System.out.println("\n--------------- LINKED LIST OPERATIONS ------------");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            choice = readInt("Enter your choice: ", 1, 5);
            switch (choice) {
                case 1 -> list.insert(readAnyInt("Enter value to insert: "));
                case 2 -> {
                    int v = readAnyInt("Enter value to delete: ");
                    System.out.println(list.delete(v) ? "Deleted." : "Value not found.");
                }
                case 3 -> {
                    int v = readAnyInt("Enter value to search: ");
                    int idx = list.search(v);
                    System.out.println(idx == -1 ? "Not found." : "Found at position " + idx);
                }
                case 4 -> list.display();
            }
        } while (choice != 5);
    }

    // ---------- 5. Searching ----------

    private static void searchingMenu() {
        int choice;
        do {
            System.out.println("\n--------------- SEARCHING OPERATIONS ------------");
            System.out.println("1. Linear Search (uses current array contents)");
            System.out.println("2. Binary Search (uses current array contents, sorted)");
            System.out.println("3. Return to Main Menu");
            choice = readInt("Enter your choice: ", 1, 3);
            switch (choice) {
                case 1 -> {
                    int target = readAnyInt("Enter value to search: ");
                    lastLinear = SearchOperations.linearSearch(array.toArray(), target);
                    System.out.println("Linear Search result: " + lastLinear);
                }
                case 2 -> {
                    int target = readAnyInt("Enter value to search: ");
                    lastBinary = SearchOperations.binarySearch(array.toSortedArray(), target);
                    System.out.println("Binary Search result: " + lastBinary);
                }
            }
        } while (choice != 3);
    }

    // ---------- 6. Graph ----------

    private static void graphMenu() {
        int choice;
        do {
            System.out.println("\n--------------- GRAPH OPERATIONS ------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Return to Main Menu");
            choice = readInt("Enter your choice: ", 1, 6);
            switch (choice) {
                case 1 -> {
                    String v = readText("Enter vertex name: ");
                    System.out.println(graph.addVertex(v) ? "Vertex added." : "Vertex already exists.");
                }
                case 2 -> {
                    String a = readText("From vertex: ");
                    String b = readText("To vertex: ");
                    System.out.println(graph.addEdge(a, b) ? "Edge added."
                            : "Error: invalid edge (missing vertex, self-loop, or duplicate).");
                }
                case 3 -> graph.display();
                case 4 -> {
                    String start = readText("Start vertex for BFS: ");
                    lastBfs = graph.bfs(start);
                    if (!lastBfs.isEmpty())
                        System.out.println("BFS order: " + lastBfs + " (steps: " + lastBfs.size() + ")");
                }
                case 5 -> {
                    String start = readText("Start vertex for DFS: ");
                    lastDfs = graph.dfs(start);
                    if (!lastDfs.isEmpty())
                        System.out.println("DFS order: " + lastDfs + " (steps: " + lastDfs.size() + ")");
                }
            }
        } while (choice != 6);
    }

    // ---------- 7. Performance Comparison ----------

    private static void performanceComparison() {
        if (array.isEmpty()) {
            System.out.println("Array is empty. Please insert values first (option 1).");
            return;
        }
        int target = readAnyInt("Enter a value to compare search performance: ");
        lastLinear = SearchOperations.linearSearch(array.toArray(), target);
        lastBinary = SearchOperations.binarySearch(array.toSortedArray(), target);

        System.out.println("\n=============================================");
        System.out.println(" PERFORMANCE COMPARISON");
        System.out.println("=============================================");
        System.out.printf("%-20s%-20s%-10s%n", "Operation", "Algorithm", "Steps");
        System.out.println("------------------------------------------------");
        System.out.printf("%-20s%-20s%-10d%n", "Search", "Linear Search", lastLinear.getSteps());
        System.out.printf("%-20s%-20s%-10d%n", "Search", "Binary Search", lastBinary.getSteps());

        if (lastBfs != null) {
            System.out.printf("%-20s%-20s%-10d%n", "Graph Traversal", "BFS", lastBfs.size());
        }
        if (lastDfs != null) {
            System.out.printf("%-20s%-20s%-10d%n", "Graph Traversal", "DFS", lastDfs.size());
        }
        System.out.println("=============================================");
        System.out.println("Explanation: Linear search checks elements one by one (O(n)), so its\n"
                + "steps grow with array size. Binary search repeatedly halves the search\n"
                + "range on a sorted array (O(log n)), so it generally needs far fewer steps\n"
                + "on larger arrays. BFS and DFS both visit every reachable vertex once\n"
                + "(O(V+E)), but differ in the order they explore the graph: BFS expands\n"
                + "level by level using a queue, while DFS goes as deep as possible first\n"
                + "using recursion (an implicit stack).");
    }

    // ---------- 8. Display All Results ----------

    private static void displayAllResults() {
        System.out.println("\n=============================================");
        System.out.println(" ALL CURRENT RESULTS");
        System.out.println("=============================================");

        System.out.print("Array:     "); array.display();
        System.out.print("Stack:     "); stack.display();
        System.out.print("Queue:     "); queue.display();
        System.out.print("LinkedList:"); list.display();
        graph.display();

        System.out.println("\nLast Linear Search: " + (lastLinear == null ? "N/A" : lastLinear));
        System.out.println("Last Binary Search: " + (lastBinary == null ? "N/A" : lastBinary));
        System.out.println("Last BFS order: " + (lastBfs == null ? "N/A" : lastBfs));
        System.out.println("Last DFS order: " + (lastDfs == null ? "N/A" : lastDfs));
    }
}