public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> citiesNetwork = new WeightedGraph<>(true);
        fillGraphData(citiesNetwork);

        Vertex<String> startPoint = citiesNetwork.getVertex("Almaty");
        Vertex<String> endPoint = citiesNetwork.getVertex("Kyzylorda");

        if (startPoint == null || endPoint == null) {
            System.out.println("Error: One of the specified cities was not found.");
            return;
        }

        System.out.println("=== Dijkstra Shortest Path ===");
        Search<String> dijkstra = new DijkstraSearch<>(citiesNetwork, startPoint);
        displayPath(dijkstra, endPoint);

        System.out.println("\n======================\n");

        System.out.println("=== Depth-First Search (DFS) ===");
        Search<String> dfs = new DepthFirstSearch<>(citiesNetwork, startPoint);
        displayPath(dfs, endPoint);

        System.out.println("\n======================\n");

        System.out.println("=== Breadth-First Search (BFS) ===");
        Search<String> bfs = new BreadthFirstSearch<>(citiesNetwork, startPoint);
        displayPath(bfs, endPoint);
    }

    public static void fillGraphData(WeightedGraph<String> targetGraph) {
        targetGraph.addEdge("Almaty", "Astana", 2.1);
        targetGraph.addEdge("Shymkent", "Atyrau", 7.8);
        targetGraph.addEdge("Atyrau", "Astana", 7.1);
        targetGraph.addEdge("Almaty", "Shymkent", 7.2);
        targetGraph.addEdge("Shymkent", "Astana", 3.9);
        targetGraph.addEdge("Astana", "Kostanay", 3.5);
        targetGraph.addEdge("Shymkent", "Kyzylorda", 5.4);
    }

    public static void displayPath(Search<String> search, Vertex<String> destination) {
        Iterable<Vertex<String>> path = search.pathTo(destination);

        if (path == null) {
            System.out.println("No route available.");
            return;
        }

        StringBuilder roadBuilder = new StringBuilder();
        for (Vertex<String> step : path) {
            if (roadBuilder.length() > 0) {
                roadBuilder.append(" => ");
            }
            roadBuilder.append(step.getData());
        }
        System.out.println(roadBuilder.toString());
    }
}
