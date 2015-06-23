package representations.entities;

public class Point {
	private int _x, _y;
	public Point (int x, int y) {
		setX(x);
		sety(y);
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
	public void sety(int _y) {
		this._y = _y;
	}
	
}
