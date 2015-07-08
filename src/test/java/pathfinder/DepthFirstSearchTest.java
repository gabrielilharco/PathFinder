/**
 * 
 */
package pathfinder;

import pathfinder.representations.graph.IGraph;
import pathfinder.representations.graph.Path;
import pathfinder.algorithm.RecursiveDepthFirstSearch;

/**
 * @author muzio
 *
 */
public class DepthFirstSearchTest
	extends PathFinderTestCase {

	
	public Path<String> findPathBetween(IGraph<String> g, 
		 					String ori,
		 					String dest) {
		RecursiveDepthFirstSearch<String> dfs =
				new RecursiveDepthFirstSearch<String>();
		
		return dfs.run(g, ori, dest);
	}

	public void testRun1() {
		IGraph<String> g = createGraph();
		
		Path<String> path = findPathBetween(g, V1, V2);
		
		assertEquals("v1-v4-v5-v3-v2-", path.toString());
	}
	
	public void testRun2() {
		IGraph<String> g = createGraph();
		
		Path<String> path = findPathBetween(g, V1, V6);
		
		assertEquals("", path.toString());
	}
	
	public void testRun3() {
		IGraph<String> g = createGraph();
		//path from V1 to V1
		Path<String> path = findPathBetween(g, V1, V1);
		
		assertEquals("v1-", path.toString());
	}
	
	public void testRun4() {
		IGraph<String> g = createGraph();
		try {
			Path<String> path = findPathBetween(g, V1, "v7");
			fail("NoSuchElementException was not thrown");
		}
		catch(Exception e) {
		}
	}
}
