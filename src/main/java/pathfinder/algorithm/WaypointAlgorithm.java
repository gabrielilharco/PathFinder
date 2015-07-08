package pathfinder.algorithm;

import pathfinder.representations.graph.IGraph;
import pathfinder.representations.graph.Path;
import pathfinder.representations.graph.WeightedGraph;
import pathfinder.representations.primitives.Point;
import pathfinder.representations.primitives.Rectangle;

public class WaypointAlgorithm {
	
	private WeightedGraph<Rectangle> _rectGraph;
	private WeightedGraph<Point> _pointGraph;
	private Path<Rectangle> _rectPath;
	private Path<Point> _pointPath;
	private Point _origin;
	private Point _destination;
	private Rectangle _rectStart;
	private Rectangle _rectEnd;
	private Heuristic<Rectangle> _rectHeuristic;
	private Heuristic<Point> _pointHeuristic;
	
	public Path<Point> run(IGraph<Rectangle> graph, Point origin, Point destination) {
		_rectGraph = (WeightedGraph<Rectangle>) graph;
		_origin = origin;
		_destination = destination;
		
		_rectStart = findRespectiveRectangle(origin);
		_rectEnd = findRespectiveRectangle(destination);
		
		defineHeuristicOfRects();
		AStarSearch<Rectangle> rectSearch = new AStarSearch<Rectangle>();
		rectSearch.setHeuristic(_rectHeuristic);		
		_rectPath = rectSearch.run(_rectGraph, _rectStart, _rectEnd);
		
		_pointGraph = new RectanglePathToEdgePoints(_rectPath, _origin, _destination).getGraph();
		
		defineHeuristicOfPoints();
		AStarSearch<Point> pointSearch = new AStarSearch<Point>();
		pointSearch.setHeuristic(_pointHeuristic);
		_pointPath = pointSearch.run(_pointGraph, _origin, _destination);
		
		double totalDist = 0.0;
		
		Point lastPoint = origin;
		for (Point p: _pointPath.getPath()) {
			totalDist += p.distanceTo(lastPoint);
			lastPoint = p;
		}
		_pointPath.setTotalWeight(totalDist);
		
		return _pointPath;
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
