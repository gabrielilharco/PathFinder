package pathfinder.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import pathfinder.representations.graph.Graph;
import pathfinder.representations.maps.VertexMap;
import pathfinder.representations.primitives.LineInfo;
import pathfinder.representations.primitives.Rectangle;

public class MapAreaDivider {
	private VertexMap _map;
	private Graph<Rectangle> _graph;
	private TreeMap<Integer, List<LineInfo>> _verticalLines;
	private TreeMap<Integer, List<LineInfo>> _horizontalLines;
	
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
	
	public Graph<Rectangle> getGraph() {
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
	
	private void removeSegmentsIntersectingObstacles() {
		int upperX, upperY, lowerX, lowerY, ceilingX, ceilingY;
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
		// TODO???
	}

	private Graph<Rectangle> generateCorrespondentGraph() {
		// TODO
		return null;
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
	
	private void removeSegments(
			Map<Integer, List<LineInfo>> intersecting,
			int upper, int lower) {
//		System.out.println("\nup=" + upper + " lw= " + lower);
		for (Entry<Integer, List<LineInfo>> entry : intersecting.entrySet()) {
//			System.out.println("key=" + entry.getKey());
			for (LineInfo lineInfo : entry.getValue()) {
//				System.out.println("\nstart=" + lineInfo.getStart() + " end= " + lineInfo.getEnd());
				if (lineInfo.getEnd() <= upper) {
					// Line ends before the rectangle
					// Do nothing
//					System.out.println("1");
				}
				else if (lineInfo.getEnd() < lower) {
					if (lineInfo.getStart() <= upper) {
						// Line starts before and ends inside rectangle
						if (lineInfo.sourceStart >= upper) {
							// The source rectangle is inside this one
							// Delete it
//							System.out.println("2");
							entry.getValue().remove(lineInfo);
						}
						else {
							// Source rectangle is either outside or 
							// intersecting with this one
							// Cut line
//							System.out.println("3");
							lineInfo.setEnd(upper);
						}
					}
					else {
						// Line is totally inside rectangle
						// Delete it
//						System.out.println("4");
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
//							System.out.println("5");
							lineInfo.setEnd(upper);
						}
						else if (lineInfo.sourceEnd < lower) {
							// Source rectangle is totally inside rectangle
							// Delete it
//							System.out.println("6");
							entry.getValue().remove(lineInfo);
						}
						else {
							// Source rectangle is either outside or 
							// intersecting with this one
							// Cut line
//							System.out.println("7");
							lineInfo.setStart(lower);
						}
					}
					else if (lineInfo.getStart() < lower) {
						// Line starts inside and ends after rectangle
						if (lineInfo.sourceEnd <= lower) {
							// The source rectangle is inside this one
							// Delete it
//							System.out.println("8");
							entry.getValue().remove(lineInfo);
						}
						else {
							// The source rectangle is either outside or 
							// intersecting with this one
							// Cut line
//							System.out.println("9");
							lineInfo.setStart(lower);
						}
					}
					else {
//						System.out.println("10");
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
