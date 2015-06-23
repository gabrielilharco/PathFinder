package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import representations.primitives.Point;

public class PointTest {

	@Test
	public void testPoint() {
		Point p = new Point(3, 4);
		assertEquals(p.getX(), 3);
		assertEquals(p.getY(), 4);
		p.setX(6);
		p.setY(8);
		assertEquals(p.getX(), 6);
		assertEquals(p.getY(), 8);	
	}
	
	@Test
	public void testIsEqual() {
		Point p1 = new Point(4, 4);
		Point p2 = new Point(4, 4);
		
		assertTrue(p1.equals(p2));
	}
	
	@Test
	public void testHashCode() {
		Point p1 = new Point(3, 54);
		Point p2 = new Point(3, 54);
		
		assertEquals(p1.hashCode(), p2.hashCode());
	}

}
