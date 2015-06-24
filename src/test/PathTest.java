package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import representations.graph.Path;

public class PathTest {
	
	private Path<Integer> createPath () {
		Path<Integer> p = new Path<Integer>();
		p.add(1);
		p.add(4);
		p.add(5);
		p.add(10);
		p.add(19);
		
		return p;
	}
	
	@Test
	public void testGetPath() {
		ArrayList<Integer> pathList = new ArrayList<Integer>();
		pathList.add(1);
		pathList.add(4);
		pathList.add(5);
		pathList.add(10);
		pathList.add(19);
		
		Path<Integer> p = createPath();
		
		assertEquals(5, p.size());
		assertEquals(pathList, p.getPath());
	}

	@Test
	public void testEqualsObject() {
		Path<Integer> p1 = createPath();
		Path<Integer> p2 = createPath();
		
		assertEquals(p1, p2);
	}

}
