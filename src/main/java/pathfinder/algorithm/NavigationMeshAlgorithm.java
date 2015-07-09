package pathfinder.algorithm;

import pathfinder.representations.graph.IGraph;
import pathfinder.representations.graph.Path;
import pathfinder.representations.graph.WeightedGraph;
import pathfinder.representations.primitives.Point;
import pathfinder.representations.primitives.Rectangle;

//Navigation Mesh Algorithm implementation
public class NavigationMeshAlgorithm {
	
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
	
	// run algorithm
	public Path<Point> run(IGraph<Rectangle> graph, Point origin, Point destination) {
		_rectGraph = (WeightedGraph<Rectangle>) graph;
		_origin = origin;
		_destination = destination;
		
		_rectStart = findRespectiveRectangle(origin);
		_rectEnd = findRespectiveRectangle(destination);
		
		// manhattan distance
		defineHeuristicOfRects();
		
		// find best path on graph of rectangles
		AStarSearch<Rectangle> rectSearch = new AStarSearch<Rectangle>();
		rectSearch.setHeuristic(_rectHeuristic);		
		_rectPath = rectSearch.run(_rectGraph, _rectStart, _rectEnd);
		
		// get graph on points lying on top of the path edges
		_pointGraph = new RectanglePathToEdgePoints(_rectPath, _origin, _destination).getGraph();
		
		// manhattan distance
		defineHeuristicOfPoints();
		
		//get best path of points		
		AStarSearch<Point> pointSearch = new AStarSearch<Point>();
		pointSearch.setHeuristic(_pointHeuristic);
		_pointPath = pointSearch.run(_pointGraph, _origin, _destination);
		
		double totalDist = 0.0;
		
		// statistics
		Point lastPoint = origin;
		for (Point p: _pointPath.getPath()) {
			int dx = Math.abs(p.getX() - lastPoint.getX());
			int dy = Math.abs(p.getY() - lastPoint.getY());
			totalDist += (dx + dy);
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
	
	// manhattan distance heuristic
	private void defineHeuristicOfRects() {
		_rectHeuristic = new Heuristic<Rectangle>() {
			@Override
			public double f(Rectangle curr, Rectangle dest) {
				int dx = Math.abs(curr.getCenter().getX() - dest.getCenter().getX());
				int dy = Math.abs(curr.getCenter().getY() - dest.getCenter().getY());
				return dx + dy;
			}
		};
	}
	
	// manhattan distance heuristic
	private void defineHeuristicOfPoints() {
		_pointHeuristic = new Heuristic<Point>() {
			@Override
			public double f(Point curr, Point dest) {
				int dx = Math.abs(curr.getX() - dest.getX());
				int dy = Math.abs(curr.getY() - dest.getY());
				return dx + dy;
			}
		};
	}
}
