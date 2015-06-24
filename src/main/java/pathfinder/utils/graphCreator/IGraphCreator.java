package pathfinder.utils.graphCreator;

import pathfinder.representations.graph.Graph;
import pathfinder.representations.maps.GridMap;

public interface IGraphCreator {
	Graph createGraph (GridMap map);
}
