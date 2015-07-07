package pathfinder;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import pathfinder.algorithm.MapAreaDivider;
import pathfinder.representations.maps.VertexMap;
import pathfinder.representations.primitives.Point;
import pathfinder.representations.primitives.Rectangle;

public class MapAreaDividerTest {

	@Test
	public void testMapAreaDivider1() {
		Point p1 = new Point(6, 6);
		Point p2 = new Point(12, 14);
		Rectangle r = new Rectangle(p1, p2);
		VertexMap map = new VertexMap(30, 20, new ArrayList<Rectangle>());
		map.addRectangleObstacle(r);
		p1 = new Point(18, 9);
		p2 = new Point(27, 12);
		r = new Rectangle(p1, p2);
		map.addRectangleObstacle(r);
		MapAreaDivider alg = new MapAreaDivider(map);
		String expectedAnswer = "Vertical lines:\n" +
								"0: \n" + 
								"   0 -> 20\n" + 
								"6: \n" + 
								"   0 -> 20\n" + 
								"12: \n" + 
								"   0 -> 20\n" + 
								"18: \n" + 
								"   0 -> 20\n" + 
								"27: \n" + 
								"   0 -> 20\n" + 
								"30: \n" + 
								"   0 -> 20\n" + 
								"Horizontal lines:\n" + 
								"0: \n" + 
								"   0 -> 30\n" + 
								"6: \n" + 
								"   0 -> 30\n" + 
								"9: \n" + 
								"   12 -> 30\n" + 
								"12: \n" + 
								"   12 -> 30\n" + 
								"14: \n" + 
								"   0 -> 30\n" + 
								"20: \n" + 
								"   0 -> 30\n";
		assertEquals(expectedAnswer, alg.toString());
	}

}
