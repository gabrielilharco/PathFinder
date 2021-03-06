package pathfinder.statistics;

import java.util.LinkedList;
import java.util.List;

import pathfinder.algorithm.BreadthFirstSearch;
import pathfinder.algorithm.IGraphAlgorithm;
import pathfinder.algorithm.AStarSearch;
import pathfinder.algorithm.DepthFirstSearch;
import pathfinder.algorithm.DijkstraShortestPath;
import pathfinder.algorithm.Heuristic;
import pathfinder.algorithm.MapAreaDivider;
import pathfinder.algorithm.NavigationMeshAlgorithm;
import pathfinder.representations.graph.Path;
import pathfinder.representations.graph.WeightedGraph;
import pathfinder.representations.maps.GridMap;
import pathfinder.representations.maps.VertexMap;
import pathfinder.representations.primitives.Point;
import pathfinder.representations.primitives.Rectangle;
import pathfinder.utils.graphCreator.GridGraphCreator;

//class for generating statistics
public class Benchmark {
	List<IGraphAlgorithm<Point>> algos = new LinkedList<IGraphAlgorithm<Point>>();
	
	//Generate Statistics for Grid Graph
	public void generateGridMapStatistics(GridMap map, Point start, Point end) {
		GridGraphCreator ggc = new GridGraphCreator();
		
		//creating algorithms for test
		algos.add(new DepthFirstSearch<Point>());
		algos.add(new BreadthFirstSearch<Point>());
		algos.add(new DijkstraShortestPath<Point>());
		
		AStarSearch<Point> as = new AStarSearch<Point>();
		as.setHeuristic( new Heuristic<Point>() {
			@Override
			public double f(Point curr, Point dest) {
				int dx = Math.abs(curr.getX() - dest.getX());
				int dy = Math.abs(curr.getY() - dest.getY());
				return dx + dy;
			}});
		
		algos.add(as);
		
		//creating grid graph
		WeightedGraph<Point> g = ggc.createGraph(map);
		System.out.println("Created graph!");
		
		//run each algorithm and benchmark
		for (IGraphAlgorithm<Point> algo : algos) {
			long startTime = System.currentTimeMillis();
			Path<Point> p = algo.run(g, start, end);
			long finishTime = System.currentTimeMillis();
			System.out.println(algo.getClass().getName() + " finished with: "
					+ (finishTime - startTime));
			System.out.println("Total path length: " +( p.size() - 1));
			if (p.size() == 0)
				System.out.println("Path is empty!");
		}
	}
	
	//generate results for navigation mesh algorithm
	public void generateNavMeshMapStatistics(VertexMap map, Point start,Point end) {
		MapAreaDivider dividedMap = new MapAreaDivider(map);
		NavigationMeshAlgorithm algo = new NavigationMeshAlgorithm();
		
		//get the rectangle-divided map
		WeightedGraph<Rectangle> g =  dividedMap.getGraph();
		
		//run nav mesh algorithm
		long startTime = System.currentTimeMillis();
		Path<Point> path = algo.run(g, start, end);
		long finishTime = System.currentTimeMillis();
		System.out.println("Nav Mesh finished with: " + (finishTime - startTime));
		System.out.println("Total path length: " + path.getTotalWeight());
	}
}
