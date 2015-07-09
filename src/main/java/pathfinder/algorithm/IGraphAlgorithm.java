package pathfinder.algorithm;

import pathfinder.representations.graph.IGraph;
import pathfinder.representations.graph.Path;

//Interface for all graph algorithms implementations
public interface IGraphAlgorithm<E> {
	public Path<E> run (IGraph<E> graph, E origin, E destination);
}
