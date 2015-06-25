package pathfinder.algorithm;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

import pathfinder.representations.graph.WeightedGraph;
import pathfinder.utils.Pair;

abstract public class AbstractShortestPathFinder<V>
	extends AbstractPathFinder<V>{
	
	Queue<Pair<Double, V>> _pq;
	HashMap<V, Double> _dist;
	
	//TODO
	WeightedGraph<V> _tempGraph;
	
	public AbstractShortestPathFinder() {
		super();
		
		_pq = new PriorityQueue<Pair<Double, V>>();
		_dist = new HashMap<V, Double>();
	}
	
	protected void setVertexDistance(V v, double dist) {
		_dist.put(v, dist);
	}
	
	protected double getVertexDistance(V v) {
		if (!_dist.containsKey(v)) {
			return Double.POSITIVE_INFINITY;
		}
		
		return _dist.get(v);
	}
}
