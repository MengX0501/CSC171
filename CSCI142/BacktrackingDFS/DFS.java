import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by robertstjacquesjr on 3/27/17.
 */
public class DFS {

    public static boolean depthFirstSearch(Vertex<?> start, Vertex<?> finish) {
        Set<Vertex<?>> visited = new HashSet<>();
        visited.add(start);
        dfsHelper(start, visited);
        return visited.contains(finish);
    }

    private static void dfsHelper(Vertex<?> vertex, Set<Vertex<?>> visited) {
        for(Vertex<?> neighbor : vertex.getNeighbors()) {
            if(visited.contains(neighbor) == false) {
                visited.add(neighbor);
                dfsHelper(neighbor, visited);
            }
        }
    }

    public static Stack<Vertex<?>> buildPathDFS(Vertex<?> start, Vertex<?> finish) {
        Set<Vertex<?>> visited = new HashSet<>();
        visited.add(start);
        return buildPathDFSHelper(start, visited, finish);
    }

    public static Stack<Vertex<?>> buildPathDFSHelper(Vertex<?> vertex,
                                                      Set<Vertex<?>> visited,
                                                      Vertex<?> finish) {
        if(vertex == finish) {
            Stack<Vertex<?>> stack = new Stack<>();
            stack.push(vertex);
            return stack;
        }
        else {
            for(Vertex<?> neighbor : vertex.getNeighbors()) {
                if(visited.contains(neighbor) == false) {
                    visited.add(neighbor);
                    Stack<Vertex<?>> path = buildPathDFSHelper(neighbor, visited, finish);
                    path.push(vertex);
                    return path;
                }
            }
            return null;
        }


    }
}
