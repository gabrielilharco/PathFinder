/**
 * 
 */
package pathfinder;


import pathfinder.algorithm.DepthFirstSearch;
import pathfinder.representations.graph.IGraph;
import pathfinder.representations.graph.Path;

/**
 * @author muzio
 *
 */
public class BreadthFirstSearchTest
	extends PathFinderTestCase {

	
	public Path<String> findPathBetween(IGraph<String> g, 
		 					String ori,
		 					String dest) {
		DepthFirstSearch<String> dfs =
				new DepthFirstSearch<String>();
		
		return dfs.run(g, ori, dest);
	}
	
	public void testRun1() {
		IGraph<String> g = createGraph();
		
		Path<String> path = findPathBetween(g, V1, V2);
		
		assertEquals("v1-v2-", path.toString());
	}
	
	public void testRun2() {
		IGraph<String> g = createGraph();
		
		//no path between V1 and V6
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
