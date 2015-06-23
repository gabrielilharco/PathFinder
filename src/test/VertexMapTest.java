package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import representations.maps.VertexMap;
import representations.primitives.Point;
import representations.primitives.Rectangle;

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

}
