package test;

import static org.junit.Assert.*;

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

}
