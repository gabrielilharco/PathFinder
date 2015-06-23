package representations.primitives;

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
	
}
