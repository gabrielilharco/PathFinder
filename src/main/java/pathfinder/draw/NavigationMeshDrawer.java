package pathfinder.draw;

import java.util.ArrayList;

import pathfinder.algorithm.AStarSearch;
import pathfinder.algorithm.Heuristic;
import pathfinder.algorithm.MapAreaDivider;
import pathfinder.algorithm.NavigationMeshAlgorithm;
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

public class NavigationMeshDrawer extends PApplet{
	
	static final byte CREATINGRECTS = 0, WAITINGPOINTS = 1;
	
	final int width = 1900;
	final int height = 1000;
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
	
	private boolean startStatistics = false;
	
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
			
			// draw every rectangle
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
			
		// draw rectangle
			case CREATINGRECTS:
				rectLowerX = mouseX;
				rectLowerY = mouseY;
				if (rectLowerX > rectUpperX && rectLowerY > rectUpperY) {
					if (rectLowerX > width - 1) rectLowerX = width - 1;
					if (rectLowerY > height - 1) rectLowerY = height - 1;
					rectangles.add(new Rectangle(rectUpperX, rectUpperY,
							 					 rectLowerX, rectLowerY));
				}
				else if (rectLowerX < rectUpperX && rectLowerY < rectUpperY) {
					if (rectLowerX < 0) rectLowerX = 0;
					if (rectLowerY < 0) rectLowerY = 0;
					rectangles.add(new Rectangle(rectLowerX, rectLowerY,
		 					 				     rectUpperX, rectUpperY));
				}
				else if (rectLowerX < rectUpperX && rectLowerY > rectUpperY) {
					if (rectLowerX < 0) rectLowerX = 0;
					if (rectLowerY > height - 1) rectLowerY = height - 1;
					rectangles.add(new Rectangle(rectLowerX, rectUpperY,
							 					 rectUpperX, rectLowerY));
				}
				else if (rectLowerX > rectUpperX && rectLowerY < rectUpperY) {
					if (rectLowerX > width - 1) rectLowerX = width - 1;
					if (rectLowerY < 0) rectLowerY = 0;
					rectangles.add(new Rectangle(rectUpperX, rectLowerY,
		 					 				     rectLowerX, rectUpperY));
				}
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
				// draw start point
				if (start == null) {
					drawWaypointMap();
					start = new Point(mouseX, mouseY);
					fill(0, 150, 0, 160);
					ellipse(mouseX, mouseY, ellipseRadius, ellipseRadius);
				}
				// draw end point
				else if (end == null){
					end = new Point(mouseX, mouseY);
					
					//draw end vertex
					fill(230, 0, 0, 160);
					ellipse(end.getX(), end.getY(), ellipseRadius, ellipseRadius);
					save(prefix + "3start-end.png");
					iterationNumber++;
				}
				// start drawing
				else if (!startStatistics){	
					System.out.println("Starting draw phase!");
					//draw path for waypoint algorithm
					NavigationMeshAlgorithm algorithm = new NavigationMeshAlgorithm();
					algorithm.run(dividedMap.getGraph(),start, end);
					
//					fill(255, 255, 60);
					fill(150, 150, 150);
					for (Rectangle rectangle : algorithm.getRectPath()) {
						rect(rectangle.getUpper().getX(), rectangle.getUpper().getY(),
							 rectangle.getWidth(), rectangle.getHeight());
					}					

					save(prefix + "4rectPath.png");
					
					fill(0, 0, 0);
					for (Point point : algorithm.getPointGraph().vertices()) {
						ellipse(point.getX(), point.getY(), ellipseRadius/3, ellipseRadius/3);
					}
					
					//hacky - draw start and end again
					fill(0, 150, 0, 160);	
					ellipse(start.getX(), start.getY(), ellipseRadius, ellipseRadius);
					fill(230, 0, 0, 160);	
					ellipse(end.getX(), end.getY(), ellipseRadius, ellipseRadius);
					
					save(prefix + "5pointGraph.png");					
					
					stroke(10, 40, 190, 160);
					strokeWeight(4);
					noFill();
					beginShape();
					for (Point point : algorithm.getPointPath()) {
						vertex(point.getX(), point.getY());
					}
					endShape();			
					
					save(prefix + "6pointPath.png");					
					
					//////////////////////////////////////////////////
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
					stroke(200, 100, 0, 60);
					strokeWeight(4);
					System.out.println(path.getPath().size());
					for(Point p: path.getPath()) {
						line(lastPoint.getX(), lastPoint.getY(), p.getX(), p.getY());
						lastPoint = p;
					}

					save(prefix + "7gridPath.png");		
					
					startStatistics = true;
				}
				// start statistics
				else {	
					System.out.println("Starting statistics!");
					//statistics
					Benchmark b = new Benchmark();
					
					System.out.println(start);
					System.out.println(end);
					
					//create statistics for grid graph algorithms
					b.generateGridMapStatistics(gridMap, start, end);
					
					//create statistics for waypoint algorithm
					b.generateNavMeshMapStatistics(vertexMap, start, end);
				}
			break;
		}		
	}
	
	
	public void keyPressed() {
		switch (state) {
			// divides map
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
