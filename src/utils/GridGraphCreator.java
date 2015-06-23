package utils;

import representations.Graph;
import representations.Node;
import representations.Map;

public class GridGraphCreator implements IGraphCreator{
	
	public Graph createGraph (Map map) {
		
		Graph G = new Graph();
		for (int i = 0; i < map.width; i++) {
			for (int j = 0; j < map.height; j++) {
				if (!map.isObstacle[i][j]) {
					if (i > 0 && !map.isObstacle[i-1][j]) {
						//G.addEdge(new Node (i-1,j), new Node (i,j), 1);
					}
					if (j > 0 && !map.isObstacle[i][j-1]) {
						//G.addEdge(new Node (i,j-1), new Node (i,j), 1);
					}
				}
				
			}
		}
		return null;
	}
}

