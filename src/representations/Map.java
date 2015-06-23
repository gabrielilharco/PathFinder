package representations;

public class Map {
	public int height, width;
	public boolean[][] isObstacle;
	
	public Map () {
	}
	
	public Map (int w, int h) {
		height = h;
		width = w;
		isObstacle = new boolean[w][h];
	}
	
	public void setPointAsObstacle (Point p) {
		isObstacle[p.x][p.y] = true;
	}
	
	// expects the coordinates of the left lower (1) and right upper (2) corners
	public void setRectangleAsObstacle (Point p1, Point p2){
		for (int i = p1.x; i < p2.x; i++)
			for (int j = p1.y; j < p2.y; j++)
				setPointAsObstacle(new Point(i,j));
	}
	
}
