package algorithm;

import representations.graph.IGraph;
import representations.graph.Path;

public class AStar<E> implements IAlgorithm<E> {
	
	public Path<E> run (IGraph<E> graph, E origin, E destination) {
		return new Path<E>(); // dummy, for now
	}
}
