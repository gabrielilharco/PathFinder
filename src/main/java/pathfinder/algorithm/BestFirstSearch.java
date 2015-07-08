package pathfinder.algorithm;

import pathfinder.representations.graph.IGraph;
import pathfinder.representations.graph.Path;

public interface BestFirstSearch<E> extends IAlgorithm<E> {
	public void setHeuristic(Heuristic<E> h);
	public Path<E> run (IGraph<E> graph, E origin, E destination);
}
