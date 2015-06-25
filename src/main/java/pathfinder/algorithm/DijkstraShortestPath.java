package pathfinder.algorithm;

import pathfinder.representations.graph.IGraph;
import pathfinder.representations.graph.Path;

public class DijkstraShortestPath<V>
	extends AbstractShortestPathFinder<V> {
	
	@Override
	public Path<V> run(IGraph<V> graph, V origin, V destination) {
		return new AStarSearch<V>().run(graph, origin, destination,
				new Heuristic<V>() {
			public double f(V curr, V dest) {
				return 0.0;
			};
		});
	}
}
