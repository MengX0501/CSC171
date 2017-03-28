import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by robertstjacquesjr on 3/27/17.
 */
public class MazeSolver {
    public static List<Vertex<?>> solveMaze(Vertex<?> start, Vertex<?> goal) {
        List<Vertex<?>> path = new LinkedList<>();
        path.add(start);
        Set<Vertex<?>> visited = new HashSet<>();
        return mazeSolverHelper(start, path, visited, goal);
    }

    private static List<Vertex<?>> mazeSolverHelper(Vertex<?> current,
                                                    List<Vertex<?>> currentPath,
                                                    Set<Vertex<?>> visited,
                                                    Vertex<?> goal) {
        if(current == goal) {
            return currentPath;
        }
        else {
            for(Vertex<?> neighbor : current.getNeighbors()) {
                if(visited.contains(neighbor) == false) {
                    List<Vertex<?>> test_path = new LinkedList<>(currentPath);

                    // in our pretend code, we can ask a vertex if it
                    // is a dead end; if true, stop and move to the next
                    // neighbor
                    //
                    // otherwise...
                    test_path.add(neighbor);
                    visited.add(neighbor);
                    List<Vertex<?>> route = mazeSolverHelper(neighbor,
                                                            test_path,
                                                            visited,
                                                            goal);
                    if(route != null) {
                        return route;
                    }
                }
            }
            return null;
        }
    }
}
