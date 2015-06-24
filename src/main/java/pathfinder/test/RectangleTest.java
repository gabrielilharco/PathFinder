package pathfinder.test;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import pathfinder.representations.primitives.Point;
import pathfinder.representations.primitives.Rectangle;

public class RectangleTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testRectangle() {
		Point p1 = new Point(3, 4);
		Point p2 = new Point(6, 8);
		Rectangle r = new Rectangle(p1, p2);
		assertEquals(r.getUpper().getX(), 3);
		assertEquals(r.getLower().getY(), 8);
		p1 = new Point(4, 5);
		p2 = new Point(5, 6);
		r.setUpper(p1);
		r.setLower(p2);
		assertEquals(r.getUpper().getY(), 5);
		assertEquals(r.getLower().getX(), 5);		
	}
	
	@Test
	public void testInvalidRectangle() {
		Point p1 = new Point(6, 8);
		Point p2 = new Point(3, 4);
		exception.expect(IllegalArgumentException.class);
		Rectangle r = new Rectangle(p1, p2);		
	}
	
	@Test
	public void testSetInvalidRectangle() {
		Point p1 = new Point(3, 4);
		Point p2 = new Point(6, 8);
		Rectangle r = new Rectangle(p1, p2);
		p1 = new Point(0, 0);
		exception.expect(IllegalArgumentException.class);
		r.setLower(p1);
	}

}
