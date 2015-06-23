package algorithm;

import representations.graph.Graph;
import representations.graph.Path;
import representations.primitives.Vertex;

public interface IAlgorithm<E> {
	public Path run (Graph<E> graph, Vertex<E> origin, Vertex<E> destination);
}
