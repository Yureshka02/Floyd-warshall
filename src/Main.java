// Main.java
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(4); // Create a graph with 4 vertices
        graph.addEdge(0, 1, 5); // Add edge with weight
        graph.addEdge(0, 2, 10);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 0, 3); // Add edges in both directions if the graph is undirected

        graph.floydWarshall(); // Run the Floyd-Warshall algorithm
    }
}
