package pathfinder.main;

import java.io.IOException;

import pathfinder.algorithm.AStarSearch;
import pathfinder.algorithm.RecursiveDepthFirstSearch;
import pathfinder.algorithm.Heuristic;
import pathfinder.representations.graph.Path;
import pathfinder.representations.graph.WeightedGraph;
import pathfinder.representations.maps.GridMap;
import pathfinder.representations.primitives.Edge;
import pathfinder.representations.primitives.Point;
import pathfinder.statistics.Benchmark;
import pathfinder.draw.GUIDrawer;
import pathfinder.graphicInterface.ChooseAlgorithmJPanel;
import pathfinder.graphicInterface.CreateMapJPanel;
import pathfinder.utils.graphCreator.GridGraphCreator;
import pathfinder.utils.gridMapCreator.ImageGridMapCreator;
import pathfinder.graphicInterface.MainJFrame;

public class Main {
	public static void main(String[] args)  {
	
		
		Benchmark b = new Benchmark();
		b.generateGridMapStatistics();
		
//		try {
//			new MainJFrame();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//		ImageGridMapCreator fmc = new ImageGridMapCreator();
//		GridGraphCreator ggc = new GridGraphCreator();
//		AStarSearch<Point> as = new AStarSearch<Point>();
//		
//		GridMap map = fmc.createMap();
//		System.out.println("Created map!");
//		
//		WeightedGraph<Point> g = ggc.createGraph(map);
//		System.out.println("Created graph!");
//		
//		as.setHeuristic(new Heuristic<Point>() {
//			@Override
//			public double f(Point curr, Point dest) {
//				int dx = Math.abs(curr.getX() - dest.getX());
//				int dy = Math.abs(curr.getY() - dest.getY());
//				return dx + dy;
////				return 0.0;
//			}
//		});
//		Path<Point> path = as.run(g, new Point(5, 100), new Point(1000, 1000));
//		System.out.println("Ran algorithm!");
		
//		Path<Point> path = new Path<Point>();
//		path.add(new Point(323,781));
//		path.add(new Point(796,678));
//		path.add(new Point(854,166));
//		path.add(new Point(1220,88));
		
//		GUIDrawer drawer = new GUIDrawer();
//		drawer.drawPath(path, map);
//
//		
//		Edge<Integer> e1 = new Edge<Integer> (1,2);
//		Edge<Integer> e2 = new Edge<Integer> (1,2);
//		System.out.println("Is equal: "+ e1.equals(e2));
//		System.out.println(e1.hashCode());
//		System.out.println(e2.hashCode());
//		
////		IMapCreator mapCreator = new  ImageMapCreator();
////		Map map = mapCreator.createMap();
////		System.out.println("Finished test");
//		
//		WeightedGraph<Integer> graph = new WeightedGraph<Integer>();
//		
//		graph.addEdge(1, 2);
//		graph.addEdge(2, 1);
//		graph.addEdge(2, 3);
//		graph.addEdge(1, 4);
//		graph.addEdge(3, 5);
//		graph.addEdge(5, 4);
//		
////		for (int  v : graph.adj(2)) {
////			System.out.println(v);
////		}
//		
//		DepthFirstSearch<Integer> d = new DepthFirstSearch<Integer>();
//		Path<Integer> p = d.run(graph, 1, 4);
//		
//		for (Integer i : p) {
//			System.out.println(i);
//		}

		System.out.println("Finished test");
	}

}
