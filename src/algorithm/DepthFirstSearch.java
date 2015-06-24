package algorithm;

import java.util.Stack;

import representations.graph.IGraph;
import representations.graph.Path;

public class DepthFirstSearch<E> 
	extends AbstractPathFinder<E> {

	public DepthFirstSearch() {
		super();
	}

	public Path<E> run(IGraph<E> graph, E origin, E destination) {
		initialize(graph, origin, destination);
		
		runSearch(_origin);

		if (_foundDestination) {
			generatePath();
		}

		// TODO throw some exception here
		return _path;
	}

	private void runSearch(E current) {
		markVertexAsVisited(current);

		// TODO - equals
		if (current.equals(_destination)) {
			_foundDestination = true;
			return;
		}

		// iterate over current neighbors
		for (E neigh : _graph.adj(current)) {
			if (!vertexIsVisited(neigh)) {
				markVertexParent(neigh, current);
				runSearch(neigh);
			}
		}
	}

	protected void generatePath() {
		Stack<E> s = new Stack<E>();

		// start the inverse path from destination
		E current = _destination;
		while (!parentVertex(current).equals(current)) {
			s.push(current);
			current = parentVertex(current);
		}
		s.push(current);

		while (!s.empty()) {
			_path.add(s.pop());
		}
	}
}
