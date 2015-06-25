package pathfinder;

import junit.framework.TestCase;
import pathfinder.representations.graph.IGraph;
import pathfinder.representations.graph.Path;
import pathfinder.representations.graph.WeightedGraph;

public abstract class PathFinderTestCase 
	extends TestCase{
	
	static final String V1 = "v1";
   	static final String V2 = "v2";
   	static final String V3 = "v3";
   	static final String V4 = "v4";
   	static final String V5 = "v5";
   	static final String V6 = "v6";
   
   	abstract public Path<String> findPathBetween(IGraph<String> g, 
   									 		String ori,
   									 		String dest);
   	
   	protected IGraph<String> createGraph() {
   		WeightedGraph<String> g = new WeightedGraph<String>();
   		
   		g.addVertex(V1);
   		g.addVertex(V2);
   		g.addVertex(V3);
   		g.addVertex(V4);
   		g.addVertex(V5);
   		g.addVertex(V6);
   		
		g.addEdge(V1, V2);
		g.addEdge(V2, V1);
		g.addEdge(V2, V3);
		g.addEdge(V1, V4);
		g.addEdge(V3, V5);
		g.addEdge(V5, V4);
		
		g.setEdgeWeight(V1, V2, 5);
		g.setEdgeWeight(V1, V4, 1);
		g.setEdgeWeight(V2, V3, 3);
		g.setEdgeWeight(V3, V5, 2);
		g.setEdgeWeight(V5, V4, 12);
		
		return g;
   	}
   	
   	
}
