package section07;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by robertstjacquesjr on 3/27/17.
 */
public class DepthFirstSearcher {


    public static boolean depthFirstSearch(Vertex<?> start, Vertex<?> end) {
        Set<Vertex<?>> visited = new HashSet<>();
        visited.add(start);

        dfsHelper(start, visited);

        return visited.contains(end);
    }

    public static void dfsHelper(Vertex<?> current, Set<Vertex<?>> visited) {
        for(Vertex<?> neighbor : current.getNeighbors()) {
            if(visited.contains(neighbor) == false) {
                visited.add(neighbor);
                dfsHelper(neighbor, visited);
            }
        }
    }

    public static Stack<Vertex<?>> buildPathDFS(Vertex<?> start, Vertex<?> end) {
        Set<Vertex<?>> visited = new HashSet<>();
        visited.add(start);
        return buildPathDFSHelper(start, visited, end);
    }

    public static Stack<Vertex<?>> buildPathDFSHelper(Vertex<?> current, Set<Vertex<?>> visited,
                                                      Vertex<?> end) {
        if(current == end) {
            Stack<Vertex<?>> path = new Stack<>();
            path.push(current);
            return path;
        }
        else {
            for(Vertex<?> neighbor : current.getNeighbors()) {
                if(visited.contains(neighbor) == false) {
                    visited.add(neighbor);

                    Stack<Vertex<?>> path = buildPathDFSHelper(neighbor, visited, end);
                    if(path != null) {
                        path.push(current);
                        return path;
                    }
                }
            }
            return null;
        }
    }

}
