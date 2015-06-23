package representations.maps;

import java.util.ArrayList;
import representations.entities.Rectangle;

public class VertexMap {
	private final int _height, _width;
	private ArrayList<Rectangle> _obstacles;
		
	public VertexMap (int width, int height) {
		_height = height;
		_width = width;
		_obstacles = new ArrayList<Rectangle>();
	}
	
	public void addRectangleObstacle (Rectangle rectangle){
		if (isInsideMapBounds(rectangle)) {
			_obstacles.add(rectangle);
		}
	}
	
	public Iterable<Rectangle> obstacleList() {
		return _obstacles;
	}

	private boolean isInsideMapBounds(Rectangle rectangle) {
		int upperX = rectangle.getUpper().getX();
		int upperY = rectangle.getUpper().getY();
		int lowerX = rectangle.getLower().getX();
		int lowerY = rectangle.getLower().getY();
		if (!(upperX >= 0 && lowerX <= _width &&
			  upperY >= 0 && lowerY <= _height)) {
			throw new java.lang.IllegalArgumentException("Rectangle out of map bounds.");
		}
		return true;
	}	
}
