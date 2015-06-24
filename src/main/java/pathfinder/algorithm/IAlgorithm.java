package pathfinder.algorithm;

import pathfinder.representations.graph.IGraph;
import pathfinder.representations.graph.Path;

public interface IAlgorithm<E> {
	public Path<E> run (IGraph<E> graph, E origin, E destination);
}
