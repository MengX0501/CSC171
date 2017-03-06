import java.util.*;

/**
 * Created by robertstjacquesjr on 3/6/17.
 */
public class Graph<T> {

    private Map<T, Vertex<T>> graph;

    public Graph() {
        graph = new HashMap<>();
    }

    public void addVertex(T data) {
        Vertex<T> vertex = new Vertex<>(data);
        graph.put(data, vertex);
    }

    public void connect(T data1, T data2) {
        Vertex<T> vertex1 = graph.get(data1);
        Vertex<T> vertex2 = graph.get(data2);

        vertex1.addNeighbor(vertex2);
        vertex2.addNeighbor(vertex1);
    }

    public boolean pathExists(T start, T end) {
        Queue<Vertex<T>> vertices = new LinkedList<>();
        Set<Vertex<T>> visited = new HashSet<>();

        Vertex<T> starting = graph.get(start);
        Vertex<T> ending = graph.get(end);

        vertices.add(starting);
        visited.add(starting);

        while(vertices.isEmpty() == false) {
            Vertex<T> vertex = vertices.poll();

            if(vertex == ending) {
                return true;
            }
            else {
                for(Vertex<T> neighbor : vertex.getNeighbors()) {
                    if(visited.contains(neighbor) == false) {
                        visited.add(neighbor);
                        vertices.add(neighbor);
                    }
                }
            }
        }

        return false;
    }

}
