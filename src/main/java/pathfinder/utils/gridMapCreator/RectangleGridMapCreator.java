package pathfinder.utils.gridMapCreator;

import java.util.List;

import pathfinder.representations.maps.GridMap;
import pathfinder.representations.primitives.Point;
import pathfinder.representations.primitives.Rectangle;

//Map Creator from List of Rectangles (representing obstacles)
public class RectangleGridMapCreator extends AbstractGridMapCreator {
	List<Rectangle> _rects;
	int _width;
	int _height;
	
	public RectangleGridMapCreator(List<Rectangle> rectangles, int width, int height) {
		_rects = rectangles;
		_width = width;
		_height = height;
	}
	
	public GridMap createMap() {
		GridMap map = new GridMap(_width, _height);
		
		for (int i = 0; i < map.width; i++) {
			for (int j = 0; j < map.height; j++) {
				map.setPointAsNotObstacle(new Point(i, j));
			}
		}
		
		//mark inner rectangle pixels as obstacles
		for (Rectangle rect : _rects) {
			for (int j = rect.getUpper().getY(); j <= rect.getLower().getY(); j++) {
				for(int i = rect.getUpper().getX(); i <= rect.getLower().getX(); i++) {
					map.setPointAsObstacle(new Point(i, j));
				}
			}
		}
		
		return map;
	}
}
