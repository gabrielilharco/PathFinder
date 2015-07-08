package pathfinder.algorithm;

import pathfinder.representations.graph.Path;
import pathfinder.representations.graph.WeightedGraph;
import pathfinder.representations.primitives.Point;
import pathfinder.representations.primitives.Rectangle;

public class WaypointAlgorithm {
	
	private WeightedGraph<Rectangle> _rectGraph;
	private WeightedGraph<Point> _pointGraph;
	private Path<Rectangle> _rectPath;
	private Path<Point> _pointPath;
	private Point _start;
	private Point _end;
	private Rectangle _rectStart;
	private Rectangle _rectEnd;
	private Heuristic<Rectangle> _rectHeuristic;
	private Heuristic<Point> _pointHeuristic;
	
	public WaypointAlgorithm(WeightedGraph<Rectangle> graph, Point start, Point end) {
		_rectGraph = graph;
		_start = start;
		_end = end;
		
		_rectStart = findRespectiveRectangle(start);
		_rectEnd = findRespectiveRectangle(end);
		
		defineHeuristicOfRects();
		AStarSearch<Rectangle> rectSearch = new AStarSearch<Rectangle>();
		rectSearch.setHeuristic(_rectHeuristic);		
		_rectPath = rectSearch.run(_rectGraph, _rectStart, _rectEnd);
		
		_pointGraph = new RectanglePathToEdgePoints(_rectPath, _start, _end).getGraph();
		
		defineHeuristicOfPoints();
		AStarSearch<Point> pointSearch = new AStarSearch<Point>();
		pointSearch.setHeuristic(_pointHeuristic);
		_pointPath = pointSearch.run(_pointGraph, _start, _end);
		
	}
	
	public Path<Rectangle> getRectPath() {
		return _rectPath;
	}
	
	public WeightedGraph<Point> getPointGraph() {
		return _pointGraph;
	}
	
	public Path<Point> getPointPath() {
		return _pointPath;
	}
	
	private Rectangle findRespectiveRectangle(Point point) {
		for (Rectangle rectangle : _rectGraph.vertices()) {
			if (rectangle.contains(point)) {
				return rectangle;
			}
		}
		throw new IllegalStateException("Didn't find rectangle containing given point"); 
	}
	
	private void defineHeuristicOfRects() {
		_rectHeuristic = new Heuristic<Rectangle>() {
			@Override
			public double f(Rectangle curr, Rectangle dest) {
				return curr.getCenter().distanceTo(dest.getCenter());
			}
		};
	}
	
	private void defineHeuristicOfPoints() {
		_pointHeuristic = new Heuristic<Point>() {
			@Override
			public double f(Point curr, Point dest) {
				return curr.distanceTo(dest);
			}
		};
	}
}
