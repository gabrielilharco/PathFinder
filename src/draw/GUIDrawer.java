
package draw;

import representations.graph.Path;
import representations.maps.GridMap;

public class GUIDrawer implements IDrawer{
		
		public void drawPath (Path path, GridMap map) {
			DisplayFrame mainFrame = new DisplayFrame(path,map);
			mainFrame.setVisible(true);
			mainFrame.setResizable(false);
		}
}
