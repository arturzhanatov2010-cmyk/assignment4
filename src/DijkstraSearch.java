import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private final Map<Vertex<V>, Double> distances = new HashMap<>();
    private final PriorityQueue<Vertex<V>> unsettledNodes;

    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> source) {
        super(source);
        unsettledNodes = new PriorityQueue<>(Comparator.comparing(this::getShortestDistance));

        distances.put(source, 0.0);
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Vertex<V> currentNode = unsettledNodes.poll();
            if (marked.contains(currentNode)) continue;
            marked.add(currentNode);

            for (Map.Entry<Vertex<V>, Double> entry : currentNode.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();

                double newDistance = getShortestDistance(currentNode) + weight;

                if (getShortestDistance(neighbor) > newDistance) {
                    distances.put(neighbor, newDistance);
                    edgeTo.put(neighbor, currentNode);
                    unsettledNodes.add(neighbor);
                }
            }
        }
    }

    private double getShortestDistance(Vertex<V> destination) {
        return distances.getOrDefault(destination, Double.MAX_VALUE);
    }
}
