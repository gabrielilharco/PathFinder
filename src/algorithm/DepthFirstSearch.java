package algorithm;

import java.util.HashMap;
import java.util.Stack;

import representations.graph.IGraph;
import representations.graph.Path;

public class DepthFirstSearch<E> implements IAlgorithm<E> {
	// algorithm data structures
	private HashMap<E, E> _parents;
	private HashMap<E, Boolean> _visited;
	private Path<E> _path;

	private IGraph<E> _graph;
	private E _origin;
	private E _destination;
	private boolean _foundDestination;

	public DepthFirstSearch() {
		_parents = new HashMap<E, E>();
		_visited = new HashMap<E, Boolean>();
		_path = new Path<E>();

		// //TODO - local variable not used?
		// for (E v : _visited.keySet()) {
		// _visited.put(v, false);
		// }

		_origin = null;
		_destination = null;
		_foundDestination = false;
	}

	public Path<E> run(IGraph<E> graph, E origin, E destination) {
		// TODO check if origin exists in graph
		_origin = origin;
		_destination = destination;
		_graph = graph;

		markVertexParent(origin, origin);
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

	private void generatePath() {
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

	private void markVertexAsVisited(E vertex) {
		_visited.put(vertex, true);
	}

	private void markVertexParent(E vertex, E parent) {
		_parents.put(vertex, parent);
	}

	private boolean vertexIsVisited(E vertex) {
		return _visited.containsKey(vertex) && _visited.get(vertex);// _visited.get(vertex);
	}

	private E parentVertex(E vertex) {
		return _parents.get(vertex);
	}
}
