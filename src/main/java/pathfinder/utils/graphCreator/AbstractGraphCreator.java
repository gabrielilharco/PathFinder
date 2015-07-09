package pathfinder.utils.graphCreator;

import pathfinder.representations.graph.WeightedGraph;
import pathfinder.representations.maps.GridMap;
import pathfinder.representations.primitives.Point;

//graph creator interface
public abstract class AbstractGraphCreator {
	public abstract WeightedGraph<Point> createGraph (GridMap map);
}
