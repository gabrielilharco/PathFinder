package main;


import representations.Map;
import draw.GUIDrawer;
import utils.ImageMapCreator;
import representations.Path;



public class Main {
	public static void main(String[] args)  {
	
		ImageMapCreator fmc = new ImageMapCreator();
		Map map = fmc.createMap();

		GUIDrawer drawer = new GUIDrawer();
		drawer.drawPath(new Path(), map);

		

		
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
