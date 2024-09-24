    import java.util.*;

    // Graph.java
    public class Graph {
        private int V; // Number of vertices
        private List<List<Edge>> adjList; // Adjacency list to store edges

        // Constructor to initialize the graph
        public Graph(int V) {
            this.V = V;
            adjList = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        // Method to add an edge to the graph
        public void addEdge(int src, int dest, int weight) {
            adjList.get(src).add(new Edge(dest, weight)); // Add directed edge
        }

        // Method to implement the Floyd-Warshall algorithm
        public void floydWarshall() {
            // Step 1: Initialize the distance matrix
            int[][] dist = new int[V][V];

            // Initialize distances based on the adjacency list
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (i == j) {
                        dist[i][j] = 0; // Distance to self is 0
                    } else {
                        dist[i][j] = Integer.MAX_VALUE; // Set to infinity initially
                    }
                }
            }

            // Populate initial distances based on edges in the graph
            for (int u = 0; u < V; u++) {
                for (Edge edge : adjList.get(u)) {
                    dist[u][edge.dest] = edge.weight; // Set direct edge weights
                }
            }

            // Step 2: Main Floyd-Warshall Loop
            for (int k = 0; k < V; k++) { // Iterate over all intermediate vertices
                for (int i = 0; i < V; i++) { // Iterate over all source vertices
                    for (int j = 0; j < V; j++) { // Iterate over all destination vertices
                        // Check if a shorter path exists through vertex k
                        if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        }
                    }
                }
            }

            // Print the resulting distance matrix
            printDistanceMatrix(dist);
        }

        // Method to print the distance matrix
        private void printDistanceMatrix(int[][] dist) {
            System.out.println("Distance matrix:");
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][j] == Integer.MAX_VALUE) {
                        System.out.print("INF "); // Print 'INF' for unreachable distances
                    } else {
                        System.out.print(dist[i][j] + " "); // Print the shortest distance
                    }
                }
                System.out.println();
            }
        }
    }


