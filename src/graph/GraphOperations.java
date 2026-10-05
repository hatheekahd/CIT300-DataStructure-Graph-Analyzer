package graph;

import java.util.*;

/**
 * Graph implemented using an adjacency list.
 * Supports adding vertices, adding edges, display, and BFS/DFS traversal.
 */
public class GraphOperations {

    private Map<String, List<String>> adjList = new LinkedHashMap<>();

    /** Adds a vertex. Returns false if it already exists. */
    public boolean addVertex(String vertex) {
        String v = vertex.toLowerCase();
        if (adjList.containsKey(v)) return false;
        adjList.put(v, new ArrayList<>());
        return true;
    }

    /** Adds an undirected edge between two vertices. Returns false on invalid input. */
    public boolean addEdge(String from, String to) {
        String a = from.toLowerCase(), b = to.toLowerCase();
        if (!adjList.containsKey(a) || !adjList.containsKey(b)) return false; // vertex missing
        if (a.equals(b) || adjList.get(a).contains(b)) return false;          // self loop / duplicate
        adjList.get(a).add(b);
        adjList.get(b).add(a);
        return true;
    }

    public void display() {
        if (adjList.isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }
        System.out.println("--- Graph (Adjacency List) ---");
        for (Map.Entry<String, List<String>> entry : adjList.entrySet()) {
            System.out.println(entry.getKey() + " -> " +
                    (entry.getValue().isEmpty() ? "(no edges)" : entry.getValue()));
        }
    }

    /** Breadth-first traversal. Returns visit order and counts steps (vertices visited). */
    public List<String> bfs(String start) {
        String s = start.toLowerCase();
        List<String> order = new ArrayList<>();
        if (!adjList.containsKey(s)) {
            System.out.println("Vertex not found.");
            return order;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(s);
        queue.add(s);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            order.add(current);
            for (String neighbour : adjList.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        return order;
    }

    /** Depth-first traversal (recursive). Returns visit order. */
    public List<String> dfs(String start) {
        String s = start.toLowerCase();
        List<String> order = new ArrayList<>();
        if (!adjList.containsKey(s)) {
            System.out.println("Vertex not found.");
            return order;
        }
        dfsHelper(s, new HashSet<>(), order);
        return order;
    }

    private void dfsHelper(String current, Set<String> visited, List<String> order) {
        visited.add(current);
        order.add(current);
        for (String neighbour : adjList.get(current)) {
            if (!visited.contains(neighbour)) {
                dfsHelper(neighbour, visited, order);
            }
        }
    }

    public int getVertexCount() {
        return adjList.size();
    }
}