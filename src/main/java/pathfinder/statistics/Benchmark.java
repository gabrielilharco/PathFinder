package pathfinder.statistics;

import java.util.LinkedList;
import java.util.List;

import pathfinder.algorithm.BreadthFirstSearch;
import pathfinder.algorithm.IAlgorithm;
import pathfinder.algorithm.AStarSearch;
import pathfinder.algorithm.DepthFirstSearch;
import pathfinder.algorithm.DijkstraShortestPath;
import pathfinder.algorithm.Heuristic;
import pathfinder.representations.graph.Path;
import pathfinder.representations.graph.WeightedGraph;
import pathfinder.representations.maps.GridMap;
import pathfinder.representations.primitives.Point;
import pathfinder.utils.graphCreator.GridGraphCreator;
import pathfinder.utils.gridMapCreator.ImageGridMapCreator;

//class for generating statistics
public class Benchmark {
	List<IAlgorithm<Point>> algos = new LinkedList<IAlgorithm<Point>>();
	
	public void generateGridMapStatistics() {
		//generate Statistics from Image
		ImageGridMapCreator fmc = new ImageGridMapCreator();
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
		
		//creating grid map from image
		GridMap map = fmc.createMap();
		System.out.println("Created map!");
		
		//creating grid graph
		WeightedGraph<Point> g = ggc.createGraph(map);
		System.out.println("Created graph!");
		
		//run each algorithm and benchmark
		for (IAlgorithm<Point> algo : algos) {
			long startTime = System.currentTimeMillis();
			Path<Point> p = algo.run(g, new Point(30,30), new Point(40, 40));
			long finishTime = System.currentTimeMillis();
			System.out.println(algo.getClass().getName() + "Finished with: "
					+ (finishTime - startTime));
			if (p.size() == 0)
				System.out.println("Path is empty!");
		}
	}
}
