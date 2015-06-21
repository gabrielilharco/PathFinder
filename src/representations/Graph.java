package representations;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class Graph<E> {
	private int _V;
	private int _E;
	HashMap<Vertex<E>, AdjacencyList<Vertex<E>> > _adj;
	
	public Graph () {
		_V = 0;
		_E = 0;
		_adj = new HashMap<Vertex<E>, AdjacencyList<Vertex<E>>>();
	}
	
	public void addEdge(Vertex<E> ori, Vertex<E> dest) {
//		System.out.println(ori.hashCode());

		if (!_adj.containsKey(ori)) {
			_V++;
			_adj.put(ori, new AdjacencyList<Vertex<E>>());
		}
		
		if (!_adj.containsKey(dest)) {
			_V++;
			_adj.put(dest, new AdjacencyList<Vertex<E>>());
		}
		
		_E++;
		_adj.get(ori).add(dest);
	}
	
	private void validateVertex(Vertex<E> vertex) {
		if (!_adj.containsKey(vertex))
			throw new NoSuchElementException();
	}
	
	public int degree (Vertex<E> vertex) {
		validateVertex(vertex);
		return _adj.get(vertex).size();
	}
	
	public Iterable<Vertex<E>> adj(Vertex<E> vertex) {
		validateVertex(vertex);
		return _adj.get(vertex);
	}
	
	public int V () {
		return _V;
	}
	
	public int E () {
		return _E;
	}
	
}
