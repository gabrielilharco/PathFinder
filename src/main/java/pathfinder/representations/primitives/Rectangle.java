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
