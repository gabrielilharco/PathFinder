package pathfinder.utils.graphCreator;

import pathfinder.representations.graph.WeightedGraph;
import pathfinder.representations.maps.GridMap;
import pathfinder.representations.primitives.Point;

public class WaypointGraphCreator extends AbstractGraphCreator{
	public WeightedGraph<Point> createGraph (GridMap map) {
		return new WeightedGraph<Point>(); // dummy, for now.
	}
}

