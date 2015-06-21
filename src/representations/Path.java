package representations;

import java.util.ArrayList;

public class Path {
	public ArrayList<Vertex> nodeList;
	
	public Path () {
		nodeList = new ArrayList<Vertex>();
	}
	
	public void addNode (Vertex node) {
		nodeList.add(node);
	}
	
}
