package algorithm;

import java.util.HashMap;
import java.util.Stack;

import representations.Graph;
import representations.Path;
import representations.Vertex;

public class DepthFirstSearch<E> implements IAlgorithm<E> {
	//algorithm data structures
	private HashMap<Vertex<E>, Vertex<E>> _parents;
	private HashMap<Vertex<E>, Boolean> _visited;
	private Path<E> _path;
	
	private Graph<E> _graph;
	private Vertex<E> _origin;
	private Vertex<E> _destination;
	private boolean _foundDestination;
	
	public DepthFirstSearch() {
		_parents = new HashMap<Vertex<E>, Vertex<E>>();
		_visited = new HashMap<Vertex<E>, Boolean>();
		_path = new Path<E>();
	
//		//TODO - local variable not used?
//		for (Vertex<E> v : _visited.keySet()) {
//			_visited.put(v, false);
//		}
		
		_origin = null;
		_destination = null;
		_foundDestination = false;
	}
	
	public Path<E> run (Graph<E> graph, Vertex<E> origin, Vertex<E> destination) {
		//TODO check if origin exists in graph
		_origin = origin;
		_destination = destination;
		_graph = graph;
		
		markVertexParent(origin, origin);
		runSearch(_origin);
		
		if (_foundDestination) {
			generatePath();
		}

		//TODO throw some exception here
		return _path;
	}
	
	private void runSearch(Vertex<E> current) {
		markVertexAsVisited(current);
		
		//TODO - equals
		if (current.equals(_destination)) {
			_foundDestination = true;
			return;
		}
		
		//iterate over current neighbors
		for (Vertex<E> neigh : _graph.adj(current)) {
			if (!vertexIsVisited(neigh)) {
				markVertexParent(neigh, current);
				runSearch(neigh);
			}
		}
	}
	
	private void generatePath() {
		Stack<Vertex<E>> s = new Stack<Vertex<E>>();
		
		//start the inverse path from destination
		Vertex<E> current = _destination;
		while (!parentVertex(current).equals(current)) {
			s.push(current);
			current = parentVertex(current);
		}
		s.push(current);
		
		while (!s.empty()) {
			_path.add(s.pop().get());
		}
	}
	
	private void markVertexAsVisited(Vertex<E> vertex) {
		_visited.put(vertex, true);
	}
	
	private void markVertexParent(Vertex<E> vertex, Vertex<E> parent) {
		_parents.put(vertex, parent);
	}
	private boolean vertexIsVisited(Vertex<E> vertex) {
		return  _visited.containsKey(vertex) && 
					_visited.get(vertex);//_visited.get(vertex);
	}
	
	private Vertex<E> parentVertex(Vertex<E> vertex) {
		return _parents.get(vertex);
	}
}
