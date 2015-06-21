package main;

import java.util.ArrayList;
import java.util.HashMap;

import representations.Graph;
import representations.Vertex;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("test");
		
//		IMapCreator mapCreator = new  ImageMapCreator();
//		Map map = mapCreator.createMap();
//		System.out.println("Finished test");
		
//		HashMap<Integer, ArrayList<Integer> > h = new HashMap<Integer, ArrayList<Integer>>();
//		h.get(key)
		
		
		Graph<Integer> graph = new Graph<Integer>();
		
		if (new Vertex<Integer>(1).equals(new Vertex<Integer>(1))) {
			System.out.println("Equal is correct");
		}
		
		graph.addEdge(new Vertex<Integer>(1), new Vertex<Integer>(2));
		graph.addEdge(new Vertex<Integer>(2), new Vertex<Integer>(1));
		graph.addEdge(new Vertex<Integer>(1), new Vertex<Integer>(3));
		
		for (Vertex<Integer> v : graph.adj(new Vertex<Integer>(1))) {
			System.out.println(v.get());
		}
	}

}
