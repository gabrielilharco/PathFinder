package pathfinder.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.TreeMap;

import pathfinder.representations.graph.WeightedGraph;
import pathfinder.representations.maps.VertexMap;
import pathfinder.representations.primitives.LineInfo;
import pathfinder.representations.primitives.Rectangle;
import pathfinder.representations.primitives.Vertex;

public class MapAreaDivider {
	private VertexMap _map;
	private WeightedGraph<Rectangle> _graph;
	private TreeMap<Integer, List<LineInfo>> _verticalLines;
	private TreeMap<Integer, List<LineInfo>> _horizontalLines;
	
	// divides a map on a graph of rectangles
	public MapAreaDivider(VertexMap map) {
		_map = map;
		_verticalLines = new TreeMap<Integer, List<LineInfo>>();
		_horizontalLines = new TreeMap<Integer, List<LineInfo>>();
		createBoundaryLines();
		createLinesFromObstacles();
		removeSegmentsIntersectingObstacles();
		removeDuplicateSegments();
		_graph = generateCorrespondentGraph();
	}
	
	public WeightedGraph<Rectangle> getGraph() {
		return _graph;
	}

	
	/// Algorithm methods ///
	
	private void createBoundaryLines() {
		LineInfo horizontalPair = new LineInfo(0, _map.width, 0, _map.width);
		LineInfo verticalPair = new LineInfo(0, _map.height, 0, _map.height);
		addToMultiMap(_verticalLines, 0, verticalPair);
		addToMultiMap(_verticalLines, _map.width, verticalPair);
		addToMultiMap(_horizontalLines, 0, horizontalPair);
		addToMultiMap(_horizontalLines, _map.height, horizontalPair);	
	}

	// generates a line for each edge going from the begin to the end of the map
	private void createLinesFromObstacles() {
		int upperX, upperY, lowerX, lowerY;
		for (Rectangle rectangle : _map.obstacleList()) {
			upperX = rectangle.getUpper().getX();
			upperY = rectangle.getUpper().getY();
			lowerX = rectangle.getLower().getX();
			lowerY = rectangle.getLower().getY();
			LineInfo horizontalPair = new LineInfo(0, _map.width, upperX, lowerX);
			LineInfo verticalPair = new LineInfo(0, _map.height, upperY, lowerY);
			addToMultiMap(_verticalLines, upperX, verticalPair);	
			addToMultiMap(_verticalLines, lowerX, verticalPair);	
			addToMultiMap(_horizontalLines, upperY, horizontalPair);	
			addToMultiMap(_horizontalLines, lowerY, horizontalPair);	
		}
	}
	
	// removes line segments that are intersecting rectangles (not used later)
	private void removeSegmentsIntersectingObstacles() {
		int upperX, upperY, lowerX, lowerY;
		Map<Integer, List<LineInfo>> intersectingVertical;
		Map<Integer, List<LineInfo>> intersectingHorizontal;
		for (Rectangle rectangle : _map.obstacleList()) {
			upperX = rectangle.getUpper().getX();
			upperY = rectangle.getUpper().getY();
			lowerX = rectangle.getLower().getX();
			lowerY = rectangle.getLower().getY();
			intersectingVertical = _verticalLines.subMap(upperX, false, lowerX, false);
			intersectingHorizontal = _horizontalLines.subMap(upperY, false, lowerY, false);
//			System.out.println("Before if int vertical");
			if (!intersectingVertical.isEmpty()) {
				removeSegments(intersectingVertical, upperY, lowerY);
			}
//			System.out.println("Before if int horizontal");
			if (!intersectingHorizontal.isEmpty()) {
				removeSegments(intersectingHorizontal, upperX, lowerX);
			}
		}
	}
	
	private void removeDuplicateSegments() {
		// TODO
	}

	// TODO: this function is returning a full array of rectangles 
	// instead of just the rectangles that were found by the
	// removeSegmentsIntersectingObstacles method
	private WeightedGraph<Rectangle> generateCorrespondentGraph() {
		WeightedGraph<Rectangle> graph = new WeightedGraph<Rectangle>();
		Rectangle[][] rectMap;
		Map<Integer, List<LineInfo>> vertPositiveLines;
		Map<Integer, List<LineInfo>> horizPositiveLines;
		vertPositiveLines = _verticalLines.subMap(0, false, _map.width, true);
		horizPositiveLines = _horizontalLines.subMap(0, false, _map.height, true);
		rectMap = new Rectangle[vertPositiveLines.size()][horizPositiveLines.size()];
		int prevVertLine = 0;
		int prevHorizLine = 0;
		int i = 0;
		int j = 0;
		for (int vert : vertPositiveLines.keySet()) {
			j = 0;
			prevHorizLine = 0;
			for (int horiz : horizPositiveLines.keySet()) {
				rectMap[i][j] = new Rectangle(prevVertLine, prevHorizLine, vert, horiz);
				boolean isObstacle = false;
				for (Rectangle obstacle : _map.obstacleList()) {
					if (rectMap[i][j].isInside(obstacle)) {
						isObstacle = true;
						break;
					}
				}
				if (!isObstacle) {
					graph.addVertex(rectMap[i][j]);					
				}
				if (i > 0) {
					try {
						graph.addEdge(rectMap[i][j], rectMap[i - 1][j]);
						graph.setEdgeWeight(rectMap[i][j], rectMap[i - 1][j], 1.0);
					} catch (NoSuchElementException e) {	}
				}
				if (j > 0) {
					try {
						graph.addEdge(rectMap[i][j], rectMap[i][j - 1]);
						graph.setEdgeWeight(rectMap[i][j], rectMap[i][j - 1], 1.0);		
					} catch (NoSuchElementException e) {	}	
				}
				prevHorizLine = horiz;
				j++;
			}			
			prevVertLine = vert;
			i++;
		}		
		return graph;
	}
	
	
	/// Helper methods ///
	
	private void addToMultiMap(
			TreeMap<Integer, List<LineInfo>> map,
			int key, LineInfo value) {
		if (!map.containsKey(key)) {
			map.put(key, new LinkedList<LineInfo>());			
		}		
		map.get(key).add(value);
	}
	
	// effectively remove a piece of each segments depending on the overlapping obstacles
	private void removeSegments(
			Map<Integer, List<LineInfo>> intersecting,
			int upper, int lower) {
		for (Entry<Integer, List<LineInfo>> entry : intersecting.entrySet()) {
			for (LineInfo lineInfo : entry.getValue()) {
				if (lineInfo.getEnd() <= upper) {
					// Line ends before the rectangle
					// Do nothing
				}
				else if (lineInfo.getEnd() < lower) {
					if (lineInfo.getStart() <= upper) {
						// Line starts before and ends inside rectangle
						if (lineInfo.sourceStart >= upper) {
							// The source rectangle is inside this one
							// Delete it
							entry.getValue().remove(lineInfo);
						}
						else {
							// Source rectangle is either outside or 
							// intersecting with this one
							// Cut line
							lineInfo.setEnd(upper);
						}
					}
					else {
						// Line is totally inside rectangle
						// Delete it
						entry.getValue().remove(lineInfo);
					}
				}
				else {
					if (lineInfo.getStart() <= upper) {
						// Line starts before and ends after rectangle
						if (lineInfo.sourceStart < upper) {
							// Source rectangle is either outside or 
							// intersecting with this one
							// Cut line
							lineInfo.setEnd(upper);
						}
						else if (lineInfo.sourceEnd < lower) {
							// Source rectangle is totally inside rectangle
							// Delete it
							entry.getValue().remove(lineInfo);
						}
						else {
							// Source rectangle is either outside or 
							// intersecting with this one
							// Cut line
							lineInfo.setStart(lower);
						}
					}
					else if (lineInfo.getStart() < lower) {
						// Line starts inside and ends after rectangle
						if (lineInfo.sourceEnd <= lower) {
							// The source rectangle is inside this one
							// Delete it
							entry.getValue().remove(lineInfo);
						}
						else {
							// The source rectangle is either outside or 
							// intersecting with this one
							// Cut line
							lineInfo.setStart(lower);
						}
					}
					else {
						// Line starts after the rectangle
						// Do nothing
					}
				}
			}
		}		
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Vertical lines:\n");
		for (Entry<Integer, List<LineInfo>> entry: _verticalLines.entrySet()){
			stringBuilder.append(entry.getKey());
			stringBuilder.append(": \n");
			for (LineInfo lineInfo : entry.getValue()) {
				stringBuilder.append("   ");
				stringBuilder.append(lineInfo.getStart());
				stringBuilder.append(" -> ");
				stringBuilder.append(lineInfo.getEnd() + "\n");
			}
		}
		stringBuilder.append("Horizontal lines:\n");
		for (Entry<Integer, List<LineInfo>> entry: _horizontalLines.entrySet()){
			stringBuilder.append(entry.getKey());
			stringBuilder.append(": \n");
			for (LineInfo lineInfo : entry.getValue()) {
				stringBuilder.append("   ");
				stringBuilder.append(lineInfo.getStart());
				stringBuilder.append(" -> ");
				stringBuilder.append(lineInfo.getEnd() + "\n");
			}
		}
		return stringBuilder.toString();
	}
}
