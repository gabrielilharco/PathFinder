package pathfinder.draw;

import pathfinder.representations.graph.Path;
import pathfinder.representations.maps.GridMap;

public interface IDrawer {
	public void drawPath (Path path, GridMap map);
}
