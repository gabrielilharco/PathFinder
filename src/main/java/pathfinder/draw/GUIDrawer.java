
package pathfinder.draw;

import pathfinder.representations.graph.Path;
import pathfinder.representations.maps.GridMap;
import pathfinder.representations.primitives.Point;

public class GUIDrawer implements IDrawer{
		
		public void drawPath (Path<Point> path, GridMap map) {
			DisplayFrame mainFrame = new DisplayFrame(path,map);
			mainFrame.setVisible(true);
			mainFrame.setResizable(false);
		}
}
