package pathfinder.representations.primitives;

public class Point {
	private int _x, _y;
	public Point (int x, int y) {
		setX(x);
		setY(y);
	}
	public int getX() {
		return _x;
	}
	public void setX(int _x) {
		this._x = _x;
	}
	public int getY() {
		return _y;
	}
	public void setY(int _y) {
		this._y = _y;
	}
	
	public double distanceTo(Point point) {
		int dx = point.getX() - _x;
		int dy = point.getY() - _y;
		return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
	}
	
	public String toString() {
		return "(" + _x + "," + _y + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
	         return false;
	     if (this == obj)
	          return true;
	     if (!(obj instanceof Point))
	          return false;
	     
	    Point other = (Point)obj; 
	     
	    return _x == other.getX() && 
	    		this._y == other.getY();
	}
	
	@Override
	public int hashCode() {
		//http://tinyurl.com/pmugwje
		 int hash = 17; 
	     hash = 31 * hash + _x;
	     hash = 31 * hash + _y;
	     return hash;
	}
}
