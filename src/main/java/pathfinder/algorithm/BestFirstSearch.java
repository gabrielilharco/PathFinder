package pathfinder.algorithm;

import pathfinder.representations.graph.IGraph;
import pathfinder.representations.graph.Path;

//Best First Search interface
//Explores a graph by expanding the most promising node chosen
//according to a heuristic function
public interface BestFirstSearch<E> extends IGraphAlgorithm<E> {
	public void setHeuristic(Heuristic<E> h);
	public Path<E> run (IGraph<E> graph, E origin, E destination);
}
