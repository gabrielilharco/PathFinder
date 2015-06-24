/**
 * 
 */
package test;

import org.junit.Test;

import representations.graph.IGraph;
import representations.graph.Path;
import representations.graph.WeightedGraph;
import algorithm.DepthFirstSearch;

/**
 * @author muzio
 *
 */
public class DepthFirstSearchTest
	extends PathFinderTestCase {

	
	public Path<String> findPathBetween(IGraph<String> g, 
		 					String ori,
		 					String dest) {
		DepthFirstSearch<String> dfs =
				new DepthFirstSearch<String>();
		
		return dfs.run(g, V1, V3);
	}

	public void testRun1() {
		IGraph<String> g = createGraph();
		
		Path<String> path = findPathBetween(g, V1, V3);
		
		Path<String> desiredPath = new Path<String> ();
		desiredPath.add(V1);
		desiredPath.add(V2);
		desiredPath.add(V3);
		
		assertEquals(path, desiredPath);
	}
}
