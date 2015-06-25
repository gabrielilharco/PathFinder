package pathfinder;

import static org.junit.Assert.*;

import org.junit.Test;

import pathfinder.utils.Pair;

public class PairTest {
	
	@Test
	public void testEquals() {
		Pair<Integer, Integer> i1 = 
				new Pair<Integer,Integer>(1,2);
		
		Pair<Integer, Integer> i2 = 
				new Pair<Integer,Integer>(1,2);
		
		assertEquals(i1, i2);
		
		Pair<String, String> s1 = 
				new Pair<String, String>("world","hello");
		
		Pair<String, String> s2 = 
				new Pair<String, String>("world","hello");
		
		assertEquals(s1, s2);
	}
	
	@Test
	public void testCompareTo() {
		Pair<Integer, Integer> i1 = 
				new Pair<Integer,Integer>(3,2);
		
		Pair<Integer, Integer> i2 = 
				new Pair<Integer,Integer>(2,2);
		
		assertTrue(i1.compareTo(i2) > 0);
	}
}
