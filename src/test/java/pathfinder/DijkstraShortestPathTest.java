package pathfinder;

import pathfinder.algorithm.BreadthFirstSearch;
import pathfinder.algorithm.DijkstraShortestPath;
import pathfinder.representations.graph.IGraph;
import pathfinder.representations.graph.Path;

public class DijkstraShortestPathTest 
	extends PathFinderTestCase {

	@Override
	public Path<String> findPathBetween(IGraph<String> g, 
				String ori,
				String dest) {
		DijkstraShortestPath<String> dijkstra =
		new DijkstraShortestPath<String>();
		
		return dijkstra.run(g, ori, dest);
	}
	
	public void testRun1() {
		IGraph<String> g = createGraph();
		
		Path<String> path = findPathBetween(g, V4, V5);
		
		assertEquals("v4-v1-v2-v3-v5-", path.toString());
		assertEquals(11.0, path.getTotalWeight(), 0.000001);
	}
}
