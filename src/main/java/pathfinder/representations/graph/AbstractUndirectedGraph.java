package pathfinder.representations.graph;

import java.util.HashMap;
import java.util.NoSuchElementException;

public abstract class AbstractUndirectedGraph<V> {
	protected int _V;
	protected int _E;
	protected HashMap<V, AdjacencyList<V> > _adj;
	
	
	public void addVertex(V v) {
		_adj.put(v, new AdjacencyList<V>());
		_V++;
	}
	
	public void addEdge(V v1, V v2) {
		validateVertex(v1);
		validateVertex(v2);

		//Undirected edges
		_adj.get(v1).add(v2);
		_adj.get(v2).add(v1);
		_E++;
	}
	
	protected AbstractUndirectedGraph () {
		_V = 0;
		_E = 0;
		_adj = new HashMap<V, AdjacencyList<V>>();
	}
	
	public int degree (V v) {
		validateVertex(v);
		return _adj.get(v).size();
	}
	
	public Iterable<V> adj(V v) {
		validateVertex(v);
		return _adj.get(v);
	}
	
	public int V () {
		return _V;
	}
	
	public int E () {
		return _E;
	}
	
	public void validateVertex(V v) {
		if (!_adj.containsKey(v))
			throw new NoSuchElementException();
	}
}
