package representations;

import java.util.ArrayList;

public class Path {
	public ArrayList<INode> nodeList;
	
	public Path () {
		nodeList = new ArrayList<INode>();
	}
	
	public void addNode (INode node) {
		nodeList.add(node);
	}
	
}
