package test;

import junit.framework.TestCase;
import representations.graph.IGraph;
import representations.graph.Path;
import representations.graph.WeightedGraph;

public abstract class PathFinderTestCase 
	extends TestCase{
	
	static final String V1 = "v1";
   	static final String V2 = "v2";
   	static final String V3 = "v3";
   	static final String V4 = "v4";
   	static final String V5 = "v5";
   
   	
   	public void testConstructor() {
   		
   	}
   	
   	abstract public Path<String> findPathBetween(IGraph<String> g, 
   									 		String ori,
   									 		String dest);
   	
   	protected IGraph<String> createGraph() {
   		WeightedGraph<String> g = new WeightedGraph<String>();
		
		g.addEdge(V1, V2);
		g.addEdge(V2, V1);
		g.addEdge(V2, V3);
		g.addEdge(V1, V4);
		g.addEdge(V3, V5);
		g.addEdge(V5, V4);
		
		return g;
   	}
}
