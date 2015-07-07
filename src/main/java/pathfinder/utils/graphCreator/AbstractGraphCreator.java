package pathfinder.utils.graphCreator;

import pathfinder.representations.graph.WeightedGraph;
import pathfinder.representations.maps.GridMap;
import pathfinder.representations.primitives.Point;

public abstract class AbstractGraphCreator {
	public abstract WeightedGraph<Point> createGraph (GridMap map);
}
