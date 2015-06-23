package main;



import representations.graph.Path;
import representations.maps.GridMap;
import representations.primitives.Point;
import draw.GUIDrawer;
import utils.gridMapCreator.ImageGridMapCreator;
import utils.gridMapCreator.TextFileGridMapCreator;



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

		

		
//		IMapCreator mapCreator = new  ImageMapCreator();
//		Map map = mapCreator.createMap();
//		System.out.println("Finished test");
		
//		HashMap<Integer, ArrayList<Integer> > h = new HashMap<Integer, ArrayList<Integer>>();
//		h.get(key)
		
		
//		Graph<Integer> graph = new Graph<Integer>();
//		
//		if (new Vertex<Integer>(1).equals(new Vertex<Integer>(1))) {
//			System.out.println("Equal is correct");
//		}
//		
//		graph.addEdge(new Vertex<Integer>(1), new Vertex<Integer>(2));
//		graph.addEdge(new Vertex<Integer>(2), new Vertex<Integer>(1));
//		graph.addEdge(new Vertex<Integer>(2), new Vertex<Integer>(3));
//		graph.addEdge(new Vertex<Integer>(1), new Vertex<Integer>(4));
//		graph.addEdge(new Vertex<Integer>(3), new Vertex<Integer>(5));
//		graph.addEdge(new Vertex<Integer>(5), new Vertex<Integer>(4));
//		
////		for (Vertex<Integer> v : graph.adj(new Vertex<Integer>(2))) {
////			System.out.println(v.get());
////		}
//		
//		DepthFirstSearch<Integer> d = new DepthFirstSearch<Integer>();
//		Path<Integer> p = d.run(graph, new Vertex<Integer>(1), new Vertex<Integer>(4));
//		
//		for (Integer i : p) {
//			System.out.println(i);
//		}
//		

		System.out.println("Finished test");
	}

}
