package pathfinder.representations.maps;

import pathfinder.representations.primitives.Point;

//2d boolean array for grid map.
//if a position is marked as false, there is no
//obstacle at that point
public class GridMap {
	public int height, width;
	public boolean[][] isObstacle;
	
	public GridMap () {
	}
	
	public GridMap (int w, int h) {
		height = h;
		width = w;
		isObstacle = new boolean[w][h];
	}
	
	public void setPointAsObstacle (Point p) {
		isObstacle[p.getX()][p.getY()] = true;
	}
	
	public void setPointAsNotObstacle (Point p) {
		isObstacle[p.getX()][p.getY()] = false;
	}
	
	// expects the coordinates of the left lower (1) and right upper (2) corners
	public void setRectangleObstacle (Point p1, Point p2){
		for (int i = p1.getX(); i < p2.getX(); i++)
			for (int j = p1.getY(); j < p2.getY(); j++)
				setPointAsObstacle(new Point(i,j));
	}
	
}