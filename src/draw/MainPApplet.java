package draw;

import representations.Path;
import representations.Map;
import processing.core.*;

public class MainPApplet extends PApplet{
	 
		private final int u = 1;
		private Map map;
		private Path path;
		private int width, height;
		private static final long serialVersionUID = 1L;
		public void setup() {
			height = 1600*u;
			width = 1600*u;
			size(1600*u,1600*u);
			background(0);
		}

		public void draw() {
			stroke(255);
			if (mousePressed) {
				line(mouseX,mouseY,pmouseX,pmouseY);
			}
			size(width, height);
		}
		
}