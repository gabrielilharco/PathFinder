package representations;

import java.util.ArrayList;

import representations.entities.Vertex;

public class Path<E> {
	public ArrayList<Vertex<E>> nodeList;
	
	public Path () {
		nodeList = new ArrayList<Vertex<E>>();
	}
	
	public void addNode (Vertex<E> node) {
		nodeList.add(node);
	}
	
}
