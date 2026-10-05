package app;

import graph.GraphOperations;
import java.util.List;

public class TestGraph {
    public static void main(String[] args) {
        GraphOperations graph = new GraphOperations();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        System.out.println("Duplicate vertex add: " + graph.addVertex("a"));

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");
        graph.addEdge("D", "E");

        System.out.println("Edge to missing vertex: " + graph.addEdge("A", "Z"));

        graph.display();

        System.out.println("\n--- Traversal Comparison ---");
        List<String> bfsOrder = graph.bfs("A");
        List<String> dfsOrder = graph.dfs("A");

        System.out.println("BFS from A: " + bfsOrder + " (steps: " + bfsOrder.size() + ")");
        System.out.println("DFS from A: " + dfsOrder + " (steps: " + dfsOrder.size() + ")");
        System.out.println("(BFS explores level by level, DFS explores depth first; "
                + "the visit order can differ even though both visit all reachable vertices.)");
    }
}