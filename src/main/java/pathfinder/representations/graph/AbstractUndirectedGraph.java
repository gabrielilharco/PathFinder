package pathfinder.representations.graph;

import java.util.HashMap;
import java.util.NoSuchElementException;

public abstract class AbstractUndirectedGraph<V> {
	protected int _V;
	protected int _E;
	protected HashMap<V, AdjacencyList<V> > _adj;
	
	public void addEdge(V v1, V v2) {
//		System.out.println(ori.hashCode());

		if (!_adj.containsKey(v1)) {
			_V++;
			_adj.put(v1, new AdjacencyList<V>());
		}
		
		if (!_adj.containsKey(v2)) {
			_V++;
			_adj.put(v2, new AdjacencyList<V>());
		}
		
		_E++;
		
		_adj.get(v1).add(v2);
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
	
	protected void validateVertex(V v) {
		if (!_adj.containsKey(v))
			throw new NoSuchElementException();
	}
}
