package pathfinder.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pathfinder.representations.graph.Graph;
import pathfinder.representations.primitives.Vertex;

public class GraphTest {
	
	//helper method for creating graphs
	private Graph<Integer> createIntGraph1 () {
		Graph<Integer> graph = new Graph<Integer>();
		
		graph.addEdge(new Vertex<Integer>(1), new Vertex<Integer>(2));
		graph.addEdge(new Vertex<Integer>(2), new Vertex<Integer>(1));
		graph.addEdge(new Vertex<Integer>(2), new Vertex<Integer>(3));
		graph.addEdge(new Vertex<Integer>(1), new Vertex<Integer>(4));
		graph.addEdge(new Vertex<Integer>(3), new Vertex<Integer>(5));
		graph.addEdge(new Vertex<Integer>(5), new Vertex<Integer>(4));
		
		return graph;
	}
	
	@Test
	public void testAddEdge() {
		Graph<Integer> graph = createIntGraph1();

		assertEquals(5, graph.V());
		assertEquals(6, graph.E());
	}
	
	@Test
	public void testDegree() {
		Graph<Integer> graph = createIntGraph1();
		
		assertEquals(2 , graph.degree(new Vertex<Integer>(1)));
		assertEquals(1, graph.degree(new Vertex<Integer>(3)));
	}

}
