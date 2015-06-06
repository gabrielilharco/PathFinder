package Algorithms;

import Representations.Path;
import Representations.Map;
import Representations.Point;

public interface iAlgorithm {
	Path findPath (Map m, Point origin, Point destination);
}
