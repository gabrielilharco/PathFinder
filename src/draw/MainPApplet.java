package draw;

import representations.Path;
import representations.Map;
import utils.ImageMapCreator;
import processing.core.*;

public class MainPApplet extends PApplet{
	 
		private final int u = 1;
		private Map map;
		private Path path;
		private int width, height;
		private boolean variableSet = false;
		private boolean drawnMap = false;
		private static final long serialVersionUID = 1L;
		
		public MainPApplet (Path p, Map m) {
			height = m.height;
			width = m.width;
			map = m;
			path = p;
			variableSet = true;
			drawnMap = false;
		}
		
		public MainPApplet () {
			height = 1500;
			width = 1500;
			map = new Map();
			path = new Path();
			variableSet = false;
			drawnMap = false;
		}
		
		public void setup() {
			size(height,width);
			background(0);
			
		}

		public void draw() {
			stroke(100);
			if (!drawnMap && variableSet) {
				background(204,102,0);
				//noStroke();
				//System.out.println(height);
				//System.out.println(width);
				for (int x = 0; x < width-10; x+=10) {
					for (int y = 0; y < height-10; y+=10) {
						if (map.isObstacle[x][y])
							fill(255);
						else
							fill(0);
						rect(x,y,x+10,y+10);
						//System.out.println(y);
					}
					//System.out.println(x);
				}
				//System.out.print("W: ");
				//System.out.print(width);
				//System.out.print(" H: ");
				//System.out.println(height);
				//System.out.println("done");
				drawnMap = true;
			}
			if (mousePressed) {
				//System.out.print(drawnMap);
				//System.out.print(" ");
				//System.out.println(variableSet);
				line(mouseX,mouseY,pmouseX,pmouseY);
			}
			//size(width, height);
			//System.out.println(variableSet);
		}
		
		public void setVariables(Path p, Map m) {
			path = p;
			map = m;
			height = m.height;
			width = m.width;
			variableSet = true;
			System.out.println("entrou");
		}
		
}