package pathfinder;

import pathfinder.algorithm.AStarSearch;
import pathfinder.algorithm.Heuristic;
import pathfinder.representations.graph.IGraph;
import pathfinder.representations.graph.Path;

public class AStarSearchTest
	extends PathFinderTestCase {
	private Heuristic<String> _h;
	
	void defineHeuristic() {
		_h = new Heuristic<String>() {
			@Override
			public double f(String curr, String dest) {
				return 0.0;
			}
		};
	}
	
	@Override
	public Path<String> findPathBetween(IGraph<String> g, 
				String ori,
				String dest) {
		AStarSearch<String> astar =
		new AStarSearch<String>();
		
		return astar.run(g, ori, dest, _h);
	}
	
	public void testRun1() {
		IGraph<String> g = createGraph();
		defineHeuristic();
		
		Path<String> path = findPathBetween(g, V4, V5);
		
		assertEquals("v4-v1-v2-v3-v5-", path.toString());
		assertEquals(11.0, path.getTotalWeight(), 0.000001);
	}
}