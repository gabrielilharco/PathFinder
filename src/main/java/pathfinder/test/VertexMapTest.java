package pathfinder.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import pathfinder.representations.maps.VertexMap;
import pathfinder.representations.primitives.Point;
import pathfinder.representations.primitives.Rectangle;

public class VertexMapTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testVertexMap() {
		VertexMap map = new VertexMap(20, 30);
		assertEquals(20, map.width);
		assertEquals(30, map.height);
		assertNotNull(map.obstacleList());
	}
	
	@Test
	public void testAddingInvalidRectangle() {
		Point p1 = new Point(30, 50);
		Point p2 = new Point(60, 80);
		Rectangle r = new Rectangle(p1, p2);
		VertexMap map = new VertexMap(20, 30);
		exception.expect(IllegalArgumentException.class);
		map.addRectangleObstacle(r);
	}
	
	@Test
	public void testToString() {
		Point p1 = new Point(6, 6);
		Point p2 = new Point(12, 14);
		Rectangle r = new Rectangle(p1, p2);
		VertexMap map = new VertexMap(30, 20);
		map.addRectangleObstacle(r);
		p1 = new Point(18, 9);
		p2 = new Point(27, 12);
		r = new Rectangle(p1, p2);
		map.addRectangleObstacle(r);
		assertEquals("(6,6),(12,14)\n(18,9),(27,12)\n", map.toString());
	}
}
