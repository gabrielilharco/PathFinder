package representations;

import java.util.ArrayList;

public class Path {
	public ArrayList<Node> nodeList;
	
	public Path () {
		nodeList = new ArrayList<Node>();
	}
	
	public void addNode (Node node) {
		nodeList.add(node);
	}
	
}
