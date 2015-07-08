package pathfinder.algorithm;

import pathfinder.representations.graph.IGraph;
import pathfinder.representations.graph.Path;
import pathfinder.representations.graph.WeightedGraph;
import pathfinder.utils.Pair;

public class AStarSearch<V>
	extends AbstractShortestPathFinder<V>
	implements BestFirstSearch<V> {
	Heuristic<V> _h;
	
	public void setHeuristic (Heuristic<V> h) {
		_h = h;
	}
	
	public Path<V> run (IGraph<V> graph, V origin, V destination) {
		if (_h == null) {
			throw new RuntimeException("A heuristic has not been set.");
		}
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
			//if (currentDist  > getVertexDistance(current)+ _h.f(current, _destination)) continue;
			for (V neigh : graph.adj(current)) {
				double currDist = getVertexDistance(current);
				double neighDist = getVertexDistance(neigh);
				double edgeWeight = _tempGraph.getEdgeWeight(current, neigh);
				
				if (currDist + edgeWeight < neighDist) {
					markVertexParent(neigh, current);
					setVertexDistance(neigh, currDist + edgeWeight);
					_pq.add(new Pair<Double, V>(currDist + edgeWeight + _h.f(neigh, _destination), neigh));
				}
			}
		}
		
		if (_foundDestination) {
			generatePath();
			_path.setTotalWeight(getVertexDistance(_destination));
		}
		
		return _path;
	}
}
