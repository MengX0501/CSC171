package section07;

import java.util.List;

/**
 * Created by robertstjacquesjr on 3/27/17.
 */
public class Vertex<T> {
    private T data;

    private List<Vertex<T>> neighbors;

    public Vertex(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public List<Vertex<T>> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Vertex<T> neighbor) {
        neighbors.add(neighbor);
    }
}
