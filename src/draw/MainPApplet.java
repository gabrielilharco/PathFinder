package draw;

import java.util.Iterator;

import representations.graph.Path;
import representations.maps.GridMap;
import representations.primitives.Point;
import utils.ImageMapCreator;
import processing.core.*;

public class MainPApplet extends PApplet{
	 
		private final int u = 1;
		private GridMap map;
		private Path path;
		private int width, height;
		private boolean variableSet = false;
		private boolean drawnMap = false;
		private static final long serialVersionUID = 1L;
		
		public MainPApplet (Path p, GridMap m) {
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
			map = new GridMap();
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
				size(width, height);
				
				// draw map
				
				background(204,102,0);
				//noStroke();
				strokeWeight((float) 0.4);
				for (int x = 0; x < width-10; x+=10) {
					for (int y = 0; y < height-10; y+=10) {
						if (map.isObstacle[x][y]) {
							fill(255);
						}
						else {
							fill(0);
						}
						rect(x,y,x+10,y+10);
						
					}
					
				}
				
				// draw path
				
				
				
				Iterator<Point> iterator = path.iterator();
				Point lastPoint = iterator.next();
				drawX(lastPoint,10);
				Point currentPoint;
				strokeWeight(4);
				stroke (255,51,0);
				while(iterator.hasNext()) {
					currentPoint = iterator.next();
					line(lastPoint.getX(), lastPoint.getY(), currentPoint.getX(), currentPoint.getY());
					lastPoint = currentPoint;
				}
				drawX(lastPoint,10);
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
		
		public void setVariables(Path p, GridMap m) {
			path = p;
			map = m;
			height = m.height;
			width = m.width;
			variableSet = true;
			System.out.println("entrou");
		}
		
		public void drawX (Point p, int size) {
			strokeWeight(4);
			stroke (0,0,0);
			line(p.getX()-size, p.getY()-size, p.getX()+size, p.getY()+size);
			line(p.getX()-size, p.getY()+size, p.getX()+size, p.getY()-size);
		}
		
}