package algorithm;

import java.util.HashMap;

import representations.graph.IGraph;
import representations.graph.Path;

abstract public class AbstractPathFinder<E>
	implements IAlgorithm<E> {
	// algorithm data structures
	final protected HashMap<E, E> _parents;
	final protected HashMap<E, Boolean> _visited;
	final protected Path<E> _path;
	
	protected IGraph<E> _graph;
	protected E _origin;
	protected E _destination;
	protected boolean _foundDestination;
	
	protected AbstractPathFinder() {
		_parents = new HashMap<E, E>();
		_visited = new HashMap<E, Boolean>();
		_path = new Path<E>();

		_origin = null;
		_destination = null;
		_foundDestination = false;
	}
	
	abstract public Path<E> run(IGraph<E> graph, E origin, E destination);
	
	abstract protected void generatePath();
	
	protected void initialize(IGraph<E> graph, E origin, E destination) {
		// TODO check if origin exists in graph
		_origin = origin;
		_destination = destination;
		_graph = graph;

		markVertexParent(origin, origin);
	}

	protected void markVertexAsVisited(E vertex) {
		_visited.put(vertex, true);
	}

	protected void markVertexParent(E vertex, E parent) {
		_parents.put(vertex, parent);
	}

	protected boolean vertexIsVisited(E vertex) {
		return _visited.containsKey(vertex) && _visited.get(vertex);// _visited.get(vertex);
	}

	protected E parentVertex(E vertex) {
		return _parents.get(vertex);
	}
}
