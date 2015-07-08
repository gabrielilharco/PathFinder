package pathfinder.draw;

import java.util.ArrayList;

import pathfinder.algorithm.AStarSearch;
import pathfinder.algorithm.Heuristic;
import pathfinder.algorithm.MapAreaDivider;
import pathfinder.algorithm.WaypointAlgorithm;
import pathfinder.representations.graph.Path;
import pathfinder.representations.graph.WeightedGraph;
import pathfinder.representations.maps.GridMap;
import pathfinder.representations.maps.VertexMap;
import pathfinder.representations.primitives.Point;
import pathfinder.representations.primitives.Rectangle;
import pathfinder.statistics.Benchmark;
import pathfinder.utils.graphCreator.GridGraphCreator;
import pathfinder.utils.gridMapCreator.RectangleGridMapCreator;
import processing.core.*;

public class WaypointDrawer extends PApplet{
	
	static final byte CREATINGRECTS = 0, WAITINGPOINTS = 1;
	
	final int width = 600;
	final int height = 400;
	final String prefix = "teste01-";
	final int ellipseRadius = Math.min(width, height) / 20;
	
	private byte state;
	private int iterationNumber;
	private ArrayList<Rectangle> rectangles;
	private VertexMap vertexMap;
	private GridMap gridMap;
	private MapAreaDivider dividedMap;
	
	private int rectUpperX;
	private int rectUpperY;
	private int rectLowerX;
	private int rectLowerY;
	private Point start;
	private Point end;
	private Rectangle startRect;
	private Rectangle endRect;
	
	public void setup() {
		size(width, height);
		state = CREATINGRECTS;
		iterationNumber = 0;
		rectangles = new ArrayList<Rectangle>();
		start = null;
		end = null;
		startRect = null;
		endRect = null;
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
					
					//draw path for waypoint algorithm
					WaypointAlgorithm algorithm = new WaypointAlgorithm();
					algorithm.run(dividedMap.getGraph(),start, end);
					
					fill(255, 255, 60);
					for (Rectangle rectangle : algorithm.getRectPath()) {
						rect(rectangle.getUpper().getX(), rectangle.getUpper().getY(),
							 rectangle.getWidth(), rectangle.getHeight());
					}
					
					fill(40, 40, 255, 180);
					for (Point point : algorithm.getPointGraph().vertices()) {
						ellipse(point.getX(), point.getY(), ellipseRadius/3, ellipseRadius/3);
					}
					
					noFill();
					beginShape();
					for (Point point : algorithm.getPointPath()) {
						vertex(point.getX(), point.getY());
					}
					endShape();
					
					//draw path for grid graph a star algorithm
					GridGraphCreator ggc = new GridGraphCreator();
					
					//create graph
					WeightedGraph<Point> g = ggc.createGraph(gridMap);
					
					AStarSearch<Point> astar = new AStarSearch<Point>();
					astar.setHeuristic(new Heuristic<Point>() {
						@Override
						public double f(Point curr, Point dest) {
							int dx = Math.abs(curr.getX() - dest.getX());
							int dy = Math.abs(curr.getY() - dest.getY());
							return dx + dy;
						}
					});
					Path<Point> path = astar.run(g, start, end);
					
					//draw path
					Point lastPoint = start;
					for(Point p: path.getPath()) {
						line(lastPoint.getX(), lastPoint.getY(), p.getX(), p.getY());
						lastPoint = p;
					}
					
					//draw start and end vertex
					fill(0, 150, 0, 180);	
					ellipse(start.getX(), start.getY(), ellipseRadius, ellipseRadius);
					fill(230, 0, 0, 180);				
					ellipse(end.getX(), end.getY(), ellipseRadius, ellipseRadius);
					start = null;
					end = null;
					iterationNumber++;
					
					System.out.println("Starting statistics!");
					//statistics
					Benchmark b = new Benchmark();
					
					System.out.println(start);
					System.out.println(end);
					
					//create statistics for grid graph algorithms
					b.generateGridMapStatistics(gridMap, start, end);
					
					//create statistics for waypoint algorithm
					b.generateWaypointMapStatistics(vertexMap, start, end);
				}
				break;
		}		
	}
	
	
	public void keyPressed() {
		switch (state) {
			
			case CREATINGRECTS:
				save(prefix + "1obstacles.png");
				vertexMap = new VertexMap(width, height, rectangles);
				gridMap = new RectangleGridMapCreator(rectangles, width, height).createMap();
				dividedMap = new MapAreaDivider(vertexMap);
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
