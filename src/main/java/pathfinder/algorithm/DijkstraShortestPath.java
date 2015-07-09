package pathfinder.algorithm;

import pathfinder.representations.graph.IGraph;
import pathfinder.representations.graph.Path;

//Dijkstra shortest path implementation using the AStar
//with heuristic equal to zero.
public class DijkstraShortestPath<V>
	extends AbstractShortestPathFinder<V> {
	
	@Override
	public Path<V> run(IGraph<V> graph, V origin, V destination) {
		AStarSearch<V> astar = new AStarSearch<V>();
		astar.setHeuristic(		
				new Heuristic<V>() {
					public double f(V curr, V dest) {
						return 0.0;
					}});
		
		return astar.run(graph, origin, destination);
	}
}
