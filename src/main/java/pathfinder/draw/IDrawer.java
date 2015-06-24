package pathfinder.draw;

import pathfinder.representations.graph.Path;
import pathfinder.representations.maps.GridMap;
import pathfinder.representations.primitives.Point;

public interface IDrawer {
	public void drawPath (Path<Point> path, GridMap map);
}
