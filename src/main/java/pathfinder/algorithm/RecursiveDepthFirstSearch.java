package pathfinder.algorithm;

import pathfinder.representations.graph.IGraph;
import pathfinder.representations.graph.Path;

//Straight-forward DFS recursive implementation
public class RecursiveDepthFirstSearch<E> 
	extends AbstractPathFinder<E> {

	public RecursiveDepthFirstSearch() {
		super();
	}

	public Path<E> run(IGraph<E> graph, E origin, E destination) {
		initialize(graph, origin, destination);
		
		runRecursiveSearch(_origin);

		if (_foundDestination) {
			generatePath();
		}

		// TODO throw some exception here
		return _path;
	}

	private void runRecursiveSearch(E current) {
		markVertexAsVisited(current);

		if (current.equals(_destination)) {
			_foundDestination = true;
			return;
		}

		// iterate over current's neighbors
		for (E neigh : _graph.adj(current)) {
			if (!vertexIsVisited(neigh)) {
				markVertexParent(neigh, current);
				//recursively visit each neighbor
				runRecursiveSearch(neigh);
			}
		}
	}
}
