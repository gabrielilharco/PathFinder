
package draw;

import representations.Path;
import representations.Map;

public class GUIDrawer implements IDrawer{
		
		public void drawPath (Path path, Map map) {
			new DisplayFrame().setVisible(true);
		}
}
