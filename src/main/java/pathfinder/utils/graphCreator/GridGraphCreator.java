package pathfinder.utils.graphCreator;

import pathfinder.representations.graph.WeightedGraph;
import pathfinder.representations.maps.GridMap;
import pathfinder.representations.primitives.Point;

//Creates graph from grid map
public class GridGraphCreator extends AbstractGraphCreator{
	
	public WeightedGraph<Point> createGraph (GridMap map) {
		
		WeightedGraph<Point> G = new WeightedGraph<Point>();
		
		//add the vertexs to the graph
		for (int i = 0; i < map.width; i++) {
			for (int j = 0; j < map.height; j++) {
				if (!map.isObstacle[i][j]) {
					G.addVertex(new Point(i, j));
				}
			}
		}
		
		//add the edges to the graph
		for (int i = 0; i < map.width; i++) {
			for (int j = 0; j < map.height; j++) {
				if (map.isObstacle[i][j]) continue;
				
				Point current = new Point(i, j);
				
				//add horizontal edge
				if (i > 0 && !map.isObstacle[i-1][j]) {
					Point horiNeighbor = new Point(i - 1, j); 
					G.addEdge(current, horiNeighbor);
					G.setEdgeWeight(current, horiNeighbor, 1.0);
				}
				
				//add vertical edge
				if (j > 0 && !map.isObstacle[i][j-1]) {
					Point vertNeighbor = new Point(i, j - 1);
					G.addEdge(current, vertNeighbor);
					G.setEdgeWeight(current, vertNeighbor, 1.0);
				}
			}
		}
		return G;
	}
}

