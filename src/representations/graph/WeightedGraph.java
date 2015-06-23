package representations.graph;

import java.util.HashMap;
import java.util.Map;

import representations.primitives.Edge;

//Weighted Undirected Graph
public class WeightedGraph<V> 
	extends AbstractUndirectedGraph<V>
	implements IGraph<V> {
	
	private final Map<Edge<V>, Double> _weightMap;
	
	public WeightedGraph () {
		super();
		
		_weightMap = new HashMap<Edge<V>, Double>();
	}
	
	public void setEdgeWeight (V v1, V v2, double weight) {
		setEdgeWeight(new Edge<V>(v1, v2), weight);
		setEdgeWeight(new Edge<V>(v2, v1), weight);
	}
	
	public void setEdgeWeight(Edge<V> edge, double weight) {
		validateVertex(edge.getV1());
		validateVertex(edge.getV2());
		System.out.println(edge.hashCode());
		
		_weightMap.put(edge, weight);
	}
	
	public double getEdgeWeight (V v1, V v2) {
		Edge<V> e = new Edge<V>(v1, v2);
		return getEdgeWeight(e);
	}
	
	public double getEdgeWeight(Edge<V> edge)  {
		validateVertex(edge.getV1());
		validateVertex(edge.getV2());
		
		System.out.println(edge.hashCode());
		
		if (!_weightMap.containsKey(edge)) {
			
		}
		Double d = _weightMap.get(edge);
		
		return _weightMap.get(edge);
	}
}
