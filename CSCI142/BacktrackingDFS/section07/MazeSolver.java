package section07;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by robertstjacquesjr on 3/27/17.
 */
public class MazeSolver {

    public static List<Vertex<MazeCell>> solveMaze(Vertex<MazeCell> start,
                                                   Vertex<MazeCell> end) {
        Set<Vertex<MazeCell>> visited = new HashSet<>();
        visited.add(start);
        List<Vertex<MazeCell>> route = new LinkedList<>();
        route.add(start);
        return mazeSolverHelper(start, visited, route, end);
    }

    private static List<Vertex<MazeCell>> mazeSolverHelper(Vertex<MazeCell> current,
                                                           Set<Vertex<MazeCell>> visited,
                                                           List<Vertex<MazeCell>> route,
                                                           Vertex<MazeCell> end) {
        if(current == end) {
            return route;
        }
        else {
            for(Vertex<MazeCell> neighbor : current.getNeighbors()) {
                if(visited.contains(neighbor) == false) {
                    visited.add(neighbor);

//                    List<Vertex<MazeCell>> test_route = new LinkedList<>(route);
//                    test_route.add(neighbor);
//                    if(test_route.get(test_route.size() - 1).getData() == MazeCell.DEAD_END)

                    if(neighbor.getData() != MazeCell.DEAD_END)  {
                        List<Vertex<MazeCell>> test_route = new LinkedList<>(route);
                        test_route.add(neighbor);

                        List<Vertex<MazeCell>> a_route = mazeSolverHelper(neighbor,
                                visited, test_route, end);
                        if(a_route != null) {
                            return a_route;
                        }
                    }
                }
            }
            return null;
        }



    }

}
