package algorithm;

import representations.Graph;
import representations.Path;
import representations.Point;

public interface IAlgorithm {
	public Path run (Graph graph, Point origin, Point destination);
}
