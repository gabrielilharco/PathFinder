package algorithm;

import representations.graph.IGraph;
import representations.graph.Path;

public interface IAlgorithm<E> {
	public Path<E> run (IGraph<E> graph, E origin, E destination);
}
