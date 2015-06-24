package pathfinder;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Test;

import pathfinder.representations.graph.WeightedGraph;

public class WeightedGraphTest {

	//helper method for creating graphs
	private WeightedGraph<Integer> createIntGraph1 () {
		WeightedGraph<Integer> graph = new WeightedGraph<Integer>();
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 1);
		graph.addEdge(2, 3);
		graph.addEdge(1, 4);
		graph.addEdge(3, 5);
		graph.addEdge(5, 4);
		
		return graph;
	}
	
	@Test
	public void testAddEdge() {
		WeightedGraph<Integer> graph = createIntGraph1();

		assertEquals(5, graph.V());
		assertEquals(6, graph.E());
	}
	
	@Test
	public void testDegree() {
		WeightedGraph<Integer> graph = createIntGraph1();
		
		assertEquals(2 , graph.degree(1));
		assertEquals(1, graph.degree(3));
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testValidateVertex() {
		WeightedGraph<Integer> graph = createIntGraph1();
		
		graph.setEdgeWeight(1, 100, 3.0);
	}
	
	@Test
	public void testSetEdgeWeights() {
		WeightedGraph<Integer> graph = createIntGraph1();
		
		graph.setEdgeWeight(1, 2, 3.0);
		
		assertEquals(graph.getEdgeWeight(1, 2), 3.0, 0.000001);
		
		//check if graph is undirected
		assertEquals(graph.getEdgeWeight(2, 1), 3.0, 0.000001);
	}
}
