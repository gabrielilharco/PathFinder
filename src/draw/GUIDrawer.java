
package draw;

import representations.Path;
import representations.Map;

public class GUIDrawer implements IDrawer{
		
		public void drawPath (Path path, Map map) {
			DisplayFrame mainFrame = new DisplayFrame(path,map);
			mainFrame.setVisible(true);
			mainFrame.setResizable(false);
		}
}
