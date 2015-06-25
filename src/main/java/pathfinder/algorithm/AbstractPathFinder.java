package pathfinder.algorithm;

import java.util.HashMap;
import java.util.Stack;

import pathfinder.representations.graph.IGraph;
import pathfinder.representations.graph.Path;

abstract public class AbstractPathFinder<V>
	implements IAlgorithm<V> {
	// algorithm data structures
	final protected HashMap<V, V> _parents;
	final protected HashMap<V, Boolean> _visited;
	final protected Path<V> _path;
	
	protected IGraph<V> _graph;
	protected V _origin;
	protected V _destination;
	protected boolean _foundDestination;
	
	protected AbstractPathFinder() {
		_parents = new HashMap<V, V>();
		_visited = new HashMap<V, Boolean>();
		_path = new Path<V>();

		_origin = null;
		_destination = null;
		_foundDestination = false;
	}
	
	abstract public Path<V> run(IGraph<V> graph, V origin, V destination);
		
	protected void initialize(IGraph<V> graph, V origin, V destination) {
		graph.validateVertex(origin);
		graph.validateVertex(destination);
		
		_origin = origin;
		_destination = destination;
		_graph = graph;

		markVertexParent(_origin, _origin);
	}

	protected void markVertexAsVisited(V vertex) {
		_visited.put(vertex, true);
	}

	protected void markVertexParent(V vertex, V parent) {
		_parents.put(vertex, parent);
	}

	protected boolean vertexIsVisited(V vertex) {
		return _visited.containsKey(vertex) && _visited.get(vertex);
	}

	protected V parentVertex(V vertex) {
		return _parents.get(vertex);
	}
	
	protected void generatePath() {
		Stack<V> s = new Stack<V>();

		// start the inverse path from destination
		V current = _destination;
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
