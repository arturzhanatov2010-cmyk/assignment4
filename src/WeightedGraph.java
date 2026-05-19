import java.util.*;

public class WeightedGraph<V> {
    private final boolean undirected;
    private final Map<V, Vertex<V>> nodes = new HashMap<>();

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(V data) {
        nodes.putIfAbsent(data, new Vertex<>(data));
    }

    public void addEdge(V sourceData, V destData, double weight) {
        addVertex(sourceData);
        addVertex(destData);

        Vertex<V> source = nodes.get(sourceData);
        Vertex<V> dest = nodes.get(destData);

        source.addAdjacentVertex(dest, weight);
        if (undirected) {
            dest.addAdjacentVertex(source, weight);
        }
    }

    public Vertex<V> getVertex(V data) {
        return nodes.get(data);
    }

    public Collection<Vertex<V>> getVertices() {
        return nodes.values();
    }
}
