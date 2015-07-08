package pathfinder.algorithm;

import java.util.ArrayList;
import java.util.List;

import pathfinder.representations.graph.Path;
import pathfinder.representations.graph.WeightedGraph;
import pathfinder.representations.primitives.Point;
import pathfinder.representations.primitives.Rectangle;

public class RectanglePathToEdgePoints {
	
	private final int _minDivisionSize = 10;
	private final int _maxDivisionSize = 25;
	
	private Path<Rectangle> _path;
	private WeightedGraph<Point> _graph;
	private Point _start;
	private Point _end;
	private final int _edgeDivisions = 5;

	public RectanglePathToEdgePoints(Path<Rectangle> path,
										 Point start, Point end) {
		if (path.size() == 0) {
			throw new IllegalStateException("Path is empty"); 
		}
		_path = path;
		_start = start;
		_end = end;
		_graph = new WeightedGraph<Point>();
		generateGraph();
	}
	
	public WeightedGraph<Point> getGraph() {
		return _graph;
	}
	
	private void generateGraph() {
		_graph.addVertex(_start);
		_graph.addVertex(_end);
		List<Rectangle> path = _path.getPath();
		if (path.size() == 1) {
			_graph.addEdge(_start,  _end);
		}
		else {
			Rectangle curr, next;
			ArrayList<Point> lastPoints = new ArrayList<Point>();
			ArrayList<Point> currPoints = new ArrayList<Point>();
			lastPoints.add(_start);
			for (int i = 0; i <= path.size() - 2; i++) {
				curr = path.get(i);
				next = path.get(i + 1);
				currPoints = getEdgePoints(curr, next);
				addVerticesToGraph(_graph, currPoints);
				addEdgesToGraph(_graph, currPoints, lastPoints);
				lastPoints = currPoints;
			}
			currPoints = new ArrayList<Point>();
			currPoints.add(_end);
			addEdgesToGraph(_graph, currPoints, lastPoints);
		}
	}

	private ArrayList<Point> getEdgePoints(Rectangle curr, Rectangle next) {
		ArrayList<Point> points = new ArrayList<Point>();
		// Next rectangle is on the right
		if (curr.getLower().getX() == next.getUpper().getX()) {
			int numberOfDivisions = getNumberOfDivisions(curr.getHeight());		
			int divisionSize = curr.getHeight()/numberOfDivisions;
			for (int i = 1; i < numberOfDivisions; i++) {
				Point point  = new Point(curr.getLower().getX(),
										   curr.getUpper().getY() + divisionSize * i);
				points.add(point);
			}
		}
		// Next rectangle is on the bottom
		else if (curr.getLower().getY() == next.getUpper().getY()) {
			int numberOfDivisions = getNumberOfDivisions(curr.getWidth());
			int divisionSize = curr.getWidth()/numberOfDivisions;
			for (int i = 1; i < numberOfDivisions; i++) {
				Point point  = new Point(curr.getUpper().getX() + divisionSize * i,
										   curr.getLower().getY());
				points.add(point);				
			}
		}
		// Next rectangle is on the left
		else if (curr.getUpper().getX() == next.getLower().getX()) {
			int numberOfDivisions = getNumberOfDivisions(curr.getHeight());		
			int divisionSize = curr.getHeight()/numberOfDivisions;
			for (int i = 1; i < numberOfDivisions; i++) {
				Point point  = new Point(curr.getUpper().getX(),
										   curr.getUpper().getY() + divisionSize * i);
				points.add(point);
			}			
		}
		// Next rectangle is on the top
		else if (curr.getUpper().getY() == next.getLower().getY()) {
			int numberOfDivisions = getNumberOfDivisions(curr.getWidth());		
			int divisionSize = curr.getWidth()/numberOfDivisions;
			for (int i = 1; i < numberOfDivisions; i++) {
				Point point  = new Point(curr.getUpper().getX() + divisionSize * i,
										   curr.getUpper().getY());
				points.add(point);				
			}			
		}
		return points;
	}

	private void addVerticesToGraph(WeightedGraph<Point> graph,
			ArrayList<Point> points) {
		for (Point point : points) {
			graph.addVertex(point);
		}		
	}
	
	private void addEdgesToGraph(WeightedGraph<Point> graph,
			ArrayList<Point> pointsA, ArrayList<Point> pointsB) {
		for (Point curr : pointsA) {
			for (Point last : pointsB) {
				graph.addEdge(last, curr);
				graph.setEdgeWeight(last, curr, curr.distanceTo(last));
			}
		}		
	}
	
	private int getNumberOfDivisions(int rectLength) {
		if (rectLength == 1) return 1;
		int divisionSize = rectLength / _edgeDivisions;
		if (divisionSize > _maxDivisionSize) {
			int newNumberOfEdgeDiv = _edgeDivisions;
			do {
				newNumberOfEdgeDiv++;
				divisionSize = rectLength / newNumberOfEdgeDiv;
			}
			while (divisionSize > _maxDivisionSize);
		}
		else if (divisionSize < _minDivisionSize) {
			int newNumberOfEdgeDiv = _edgeDivisions;
			do {
				newNumberOfEdgeDiv--;
				divisionSize = rectLength / newNumberOfEdgeDiv;
			}
			while (newNumberOfEdgeDiv > 2 && divisionSize < _minDivisionSize);
		}
		if (divisionSize == 0) {
			return rectLength / 2;
		}
		else {
			return rectLength/divisionSize;
		}
	}
}
