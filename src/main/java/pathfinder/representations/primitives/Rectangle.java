package pathfinder.representations.primitives;

public class Rectangle {
	private Point _upper;
	private Point _lower;
	
	// Upper must be the top left corner and 
	// lower must be the bottom right corner
	public Rectangle(Point upper, Point lower) {
		if (validRectangle(lower, upper)) {
			_upper = upper;
			_lower = lower;
		}
	}
	
	public Rectangle(int xUpper, int yUpper, int xLower, int yLower) {
		Point upper = new Point(xUpper, yUpper);
		Point lower = new Point(xLower, yLower);
		if (validRectangle(lower, upper)) {
			_upper = upper;
			_lower = lower;
		}
	}
	
	public boolean isInside(Rectangle outer) {
		float midX = (_lower.getX() + _upper.getX())/2;
		float midY = (_lower.getY() + _upper.getY())/2;
//		System.out.println("midx= " + midX);
//		System.out.println("midy= " + midY);
//		System.out.println(outer);
		if (outer.getUpper().getX() < midX && midX < outer.getLower().getX() &&
			outer.getUpper().getY() < midY && midY < outer.getLower().getY()) {
			return true;
		}
		else {
			return false;			
		}
	}
	
	public boolean contains(Point point) {
		if (_upper.getX() <= point.getX() && point.getX() <= _lower.getX() &&
			_upper.getY() <= point.getY() && point.getY() <= _lower.getY()) {
			return true;
		}
		else {
			return false;			
		}
	}
	
	public Point getCenter() {
		int midX = (_lower.getX() + _upper.getX())/2;
		int midY = (_lower.getY() + _upper.getY())/2;
		return new Point(midX, midY);
	}

	public Point getUpper() {
		return _upper;
	}

	public void setUpper(Point upper) {
		if (validRectangle(_lower, upper)) {
			this._upper = upper;			
		}
	}

	public Point getLower() {
		return _lower;
	}

	public void setLower(Point lower) {
		if (validRectangle(lower, _upper)) {
			this._lower = lower;
		}
	}
	
	public int getWidth() {
		return _lower.getX() - _upper.getX();
	}
	
	public int getHeight() {
		return _lower.getY() - _upper.getY();
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(_upper);
		stringBuilder.append(",");
		stringBuilder.append(_lower);
		return stringBuilder.toString();
	}
	
	private boolean validRectangle(Point lower, Point upper) {
		if (!(upper.getX() < lower.getX() &&
			  upper.getY() < lower.getY())) {
			throw new java.lang.IllegalArgumentException("Invalid rectangle.");
		}
		return true;
	}
}
