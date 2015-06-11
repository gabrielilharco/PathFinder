package algorithm;

import representations.Map;
import representations.Path;
import representations.Point;

public interface IAlgorithm {
	Path findPath (Map m, Point origin, Point destination);
}
