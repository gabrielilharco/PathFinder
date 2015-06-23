package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import representations.primitives.Edge;

public class EdgeTest {

	@Test
	public void testEqualsObject() {
		Edge<Integer> e1 = new Edge<Integer>(1, 2);
		Edge<Integer> e2 = new Edge<Integer>(1, 2);		
		assertTrue(e1.equals(e2));
		
		Edge<String> e3 = new Edge<String>("origin", "destination");
		Edge<String> e4 = new Edge<String>("origin", "destination");
		assertTrue(e3.equals(e4));
	}
	
	@Test
	public void testHashCode() {
		Edge<Integer> e1 = new Edge<Integer>(1, 2);
		Edge<Integer> e2 = new Edge<Integer>(1, 2);		
		assertEquals(e1.hashCode(), e2.hashCode());
		
		Edge<String> e3 = new Edge<String>("origin", "destination");
		Edge<String> e4 = new Edge<String>("origin", "destination");
		assertEquals(e3.hashCode(), e4.hashCode());
	}

}
