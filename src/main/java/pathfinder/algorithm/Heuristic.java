package pathfinder.algorithm;

public interface Heuristic<E> {
	public double f(E curr, E dest);
}
