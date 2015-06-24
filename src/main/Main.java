package main;

import algorithm.DepthFirstSearch;
import representations.graph.Path;
import representations.graph.WeightedGraph;
import representations.maps.GridMap;
import representations.primitives.Edge;
import representations.primitives.Point;
import draw.GUIDrawer;
import utils.gridMapCreator.ImageGridMapCreator;

public class Main {
	public static void main(String[] args)  {
	
		ImageGridMapCreator fmc = new ImageGridMapCreator();
		GridMap map = fmc.createMap();
		
		Path<Point> path = new Path<Point>();
		path.add(new Point(323,781));
		path.add(new Point(796,678));
		path.add(new Point(854,166));
		path.add(new Point(1220,88));
		
		GUIDrawer drawer = new GUIDrawer();
		drawer.drawPath(path, map);

		
		Edge<Integer> e1 = new Edge<Integer> (1,2);
		Edge<Integer> e2 = new Edge<Integer> (1,2);
		System.out.println("Is equal: "+ e1.equals(e2));
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		
//		IMapCreator mapCreator = new  ImageMapCreator();
//		Map map = mapCreator.createMap();
//		System.out.println("Finished test");
		
		WeightedGraph<Integer> graph = new WeightedGraph<Integer>();
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 1);
		graph.addEdge(2, 3);
		graph.addEdge(1, 4);
		graph.addEdge(3, 5);
		graph.addEdge(5, 4);
		
//		for (int  v : graph.adj(2)) {
//			System.out.println(v);
//		}
		
		DepthFirstSearch<Integer> d = new DepthFirstSearch<Integer>();
		Path<Integer> p = d.run(graph, 1, 4);
		
		for (Integer i : p) {
			System.out.println(i);
		}

		System.out.println("Finished test");
	}

}
