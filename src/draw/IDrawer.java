package draw;

import representations.graph.Path;
import representations.maps.GridMap;

public interface IDrawer {
	public void drawPath (Path path, GridMap map);
}
