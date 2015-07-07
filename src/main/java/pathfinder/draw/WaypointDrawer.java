package pathfinder.draw;

import java.util.ArrayList;

import pathfinder.algorithm.MapAreaDivider;
import pathfinder.representations.maps.VertexMap;
import pathfinder.representations.primitives.Point;
import pathfinder.representations.primitives.Rectangle;
import processing.core.*;

public class WaypointDrawer extends PApplet{
	
	static final byte CREATINGRECTS = 0, WAITINGPOINTS = 1;
	
	final int width = 400;
	final int height = 300;
	final String prefix = "teste01-";
	final int ellipseRadius = Math.min(width, height) / 20;
	
	private byte state;
	private int iterationNumber;
	private ArrayList<Rectangle> rectangles;
	private VertexMap map;
	private MapAreaDivider dividedMap;
	
	private int rectUpperX;
	private int rectUpperY;
	private int rectLowerX;
	private int rectLowerY;
	private Point start;
	private Point end;
	
	public void setup() {
		size(width, height);
		state = CREATINGRECTS;
		iterationNumber = 0;
		rectangles = new ArrayList<Rectangle>();
		start = null;
		end = null;
	}
	
	public void draw() {
		switch (state) {
		
			case CREATINGRECTS:
				background(255);
				fill(0);
				for (Rectangle rectangle : rectangles) {
					rect(rectangle.getUpper().getX(), rectangle.getUpper().getY(),
						 rectangle.getWidth(), rectangle.getHeight());
				}
				break;
				
			case WAITINGPOINTS:
				break;
		}
	}
	
	public void mousePressed() {
		switch (state) {
			
			case CREATINGRECTS:
				rectUpperX = mouseX;
				rectUpperY = mouseY;
				break;
				
			case WAITINGPOINTS:
				break;
		}		
	}
	
	public void mouseReleased() {
		switch (state) {
			
			case CREATINGRECTS:
				rectLowerX = mouseX;
				rectLowerY = mouseY;
				try {
					rectangles.add(new Rectangle(rectUpperX, rectUpperY,
												 rectLowerX, rectLowerY));
				} catch (IllegalArgumentException e) {}
				break;
				
			case WAITINGPOINTS:
				break;
		}		
	}
	
	public void mouseClicked() {
		switch (state) {
			
			case CREATINGRECTS:
				break;
				
			case WAITINGPOINTS:
				if (start == null) {
					drawWaypointMap();
					start = new Point(mouseX, mouseY);
					fill(0, 150, 0, 180);	
					ellipse(mouseX, mouseY, ellipseRadius, ellipseRadius);
				}
				else {
					end = new Point(mouseX, mouseY);
					fill(230, 0, 0, 180);				
					ellipse(mouseX, mouseY, ellipseRadius, ellipseRadius);
										
					///////////////////////////
					/// Put grid logic here ///					
					///////////////////////////
					System.out.println("Iteration number " + iterationNumber + "\n" +
										"Algorithms should be running and pictures along with\n" +
										"statistics should be saved here!\n\n" +
										"Insert start and end points again to run another\n" +
										"time and save files with a different prefix (use\n" +
										"iterationNumber variable)...\n\n");										
					
					start = null;
					end = null;
					iterationNumber++;
				}
				break;
		}		
	}
	
	
	public void keyPressed() {
		switch (state) {
			
			case CREATINGRECTS:
				save(prefix + "1obstacles.png");
				map = new VertexMap(width, height, rectangles);
				dividedMap = new MapAreaDivider(map);
				drawWaypointMap();				
				save(prefix + "2waypointMap.png");
				state = WAITINGPOINTS;	
				break;
				
			case WAITINGPOINTS:
				break;
		}		
	}

	private void drawWaypointMap() {
		background(0);
		fill(255);
		stroke(0);
		for (Rectangle rectangle : dividedMap.getGraph().vertices()) {
			rect(rectangle.getUpper().getX(), rectangle.getUpper().getY(),
				 rectangle.getWidth(), rectangle.getHeight());
		}		
	}


}
