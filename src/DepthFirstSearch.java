
import java.util.*;
public class DepthFirstSearch<V> extends Search<V> {

    public DepthFirstSearch(UnweightedGraph<V> graph, Vertex<V> source) {
        super(source);
        dfs(source);
    }
    public DepthFirstSearch(WeightedGraph<V> graph, Vertex<V> source) {
        super(source);
        dfs(source);
    }
    private void dfs(Vertex<V> current) {
        marked.add(current);

        for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
            if (!marked.contains(neighbor)) {
                edgeTo.put(neighbor, current);
                dfs(neighbor);
            }
        }
    }
}

