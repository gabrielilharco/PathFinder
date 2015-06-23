package representations.maps;

import java.util.ArrayList;

import representations.primitives.Rectangle;

public class VertexMap {
	public final int height, width;
	private ArrayList<Rectangle> _obstacles;
		
	public VertexMap (int width, int height) {
		if (width <= 0 || height <= 0) {
			throw new java.lang.IllegalArgumentException("Dimensions must be positive");
		}
		this.height = height;
		this.width = width;
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
		if (!(upperX >= 0 && lowerX <= width &&
			  upperY >= 0 && lowerY <= height)) {
			throw new java.lang.IllegalArgumentException("Rectangle out of map bounds.");
		}
		return true;
	}	
}
