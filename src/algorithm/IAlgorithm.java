package algorithm;

import representations.Graph;
import representations.Path;
import representations.entities.Vertex;

public interface IAlgorithm<E> {
	public Path run (Graph<E> graph, Vertex<E> origin, Vertex<E> destination);
}
