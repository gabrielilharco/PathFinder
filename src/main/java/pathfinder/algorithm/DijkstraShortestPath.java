package pathfinder.algorithm;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

import pathfinder.representations.graph.IGraph;
import pathfinder.representations.graph.Path;
import pathfinder.representations.graph.WeightedGraph;
import pathfinder.utils.Pair;

public class DijkstraShortestPath<V>
	extends AbstractPathFinder<V> {
	
	Queue<Pair<Double, V>> _pq;
	HashMap<V, Double> _dist;
	
	//TODO
	WeightedGraph<V> _tempGraph;
	
	public DijkstraShortestPath() {
		super();
		
		_pq = new PriorityQueue<Pair<Double, V>>();
		_dist = new HashMap<V, Double>();
	}
	
	@Override
	public Path<V> run(IGraph<V> graph, V origin, V destination) {
		initialize(graph, origin, destination);
		
		//TODO FOR NOWW!!!
		_tempGraph = (WeightedGraph<V>) graph;
		
		_pq.add(new Pair<Double,V>(0.0, _origin));
		setVertexDistance(_origin, 0.0);
		
		while(!_pq.isEmpty()) {
			Pair<Double, V> next = _pq.remove();
			
			double currentDist = next.getFirst();
			V current = next.getSecond();
			
			if (current.equals(destination)) {
				_foundDestination = true;
				break;
			}
			
			//important check: avoid analyzing same vertex twice
			if (currentDist  > getVertexDistance(current));
			for (V neigh : graph.adj(current)) {
				double currDist = getVertexDistance(current);
				double neighDist = getVertexDistance(neigh);
				double edgeWeight = _tempGraph.getEdgeWeight(current, neigh);
				
				if (currDist + edgeWeight < neighDist) {
					
					markVertexParent(neigh, current);
					setVertexDistance(neigh, currDist + edgeWeight);
					_pq.add(new Pair<Double, V>(currDist + edgeWeight, neigh));
				}
			}
		}
		
		if (_foundDestination) {
			generatePath();
			_path.setTotalWeight(getVertexDistance(_destination));
		}
		
		return _path;
	}
	
	private void setVertexDistance(V v, double dist) {
		_dist.put(v, dist);
	}
	
	private double getVertexDistance(V v) {
		if (!_dist.containsKey(v)) {
			return Double.POSITIVE_INFINITY;
		}
		
		return _dist.get(v);
	}
}
