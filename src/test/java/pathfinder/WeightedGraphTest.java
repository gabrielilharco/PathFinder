package pathfinder;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Test;

import pathfinder.representations.graph.WeightedGraph;
import pathfinder.representations.primitives.Point;

public class WeightedGraphTest {

	//helper method for creating graphs
	private WeightedGraph<Integer> createIntGraph1 () {
		WeightedGraph<Integer> graph = new WeightedGraph<Integer>();
		
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(1, 4);
		graph.addEdge(3, 5);
		graph.addEdge(5, 4);
		
		return graph;
	}
	
	private WeightedGraph<Point> createPointGraph1 () {
		WeightedGraph<Point> graph = new WeightedGraph<Point>();
		
		graph.addVertex(new Point(0, 0));
		graph.addVertex(new Point(1, 1));
		graph.addVertex(new Point(1, 2));
		graph.addVertex(new Point(2, 1));
		graph.addVertex(new Point(2, 2));
		
		graph.addEdge(new Point(0, 0), new Point(1, 1));
		graph.addEdge(new Point(1, 1), new Point(1, 2));
		graph.addEdge(new Point(1, 1), new Point(2, 1));
		graph.addEdge(new Point(2, 1), new Point(2, 2));
		graph.addEdge(new Point(1, 2), new Point(2, 2));
		
		return graph;
	}
	
	@Test
	public void testAddEdge() {
		WeightedGraph<Integer> intGraph = createIntGraph1();
		WeightedGraph<Point> pointGraph = createPointGraph1();
		
		//int graph
		assertEquals(5, intGraph.V());
		assertEquals(5, intGraph.E());
		
		//point graph
		assertEquals(5, pointGraph.V());
		assertEquals(5, pointGraph.E());
	}
	
	@Test
	public void testDegree() {
		WeightedGraph<Integer> intGraph = createIntGraph1();
		WeightedGraph<Point> pointGraph = createPointGraph1();
		
		//int graph
		assertEquals(2 , intGraph.degree(1));
		assertEquals(2, intGraph.degree(3));
		
		//point graph
		assertEquals(1, pointGraph.degree(new Point(0, 0)));
		assertEquals(3, pointGraph.degree(new Point(1, 1)));
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testValidateVertex() {
		WeightedGraph<Integer> intGraph = createIntGraph1();
		WeightedGraph<Point> pointGraph = createPointGraph1();
		
		intGraph.setEdgeWeight(1, 100, 3.0);
		pointGraph.setEdgeWeight(new Point(0, 0),new Point(100, 100), 3.0);
	}
	
	@Test
	public void testSetEdgeWeights() {
		WeightedGraph<Integer> graph = createIntGraph1();
		WeightedGraph<Point> pointGraph = createPointGraph1();
		
		//int graph
		graph.setEdgeWeight(1, 2, 3.0);
		assertEquals(graph.getEdgeWeight(1, 2), 3.0, 0.000001);
		
		//check if graph is undirected
		assertEquals(graph.getEdgeWeight(2, 1), 3.0, 0.000001);
		
		//point graph
		pointGraph.setEdgeWeight(new Point(0, 0),new Point(1, 1), 3.0);
		
		assertEquals(3.0, 
				pointGraph.getEdgeWeight(new Point(0, 0), new Point(1, 1)),
				0.000001);
		
		//check if graph is undirected
		assertEquals(3.0, 
				pointGraph.getEdgeWeight(new Point(1, 1),new Point(0, 0)),
				0.000001);
	}
}
