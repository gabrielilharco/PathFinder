package pathfinder.representations.graph;

//interface for all graph implementations
public interface IGraph<V> {
	public int degree (V v);
	public Iterable<V> adj(V v);
	
	public int V ();
	public int E ();
	public void validateVertex(V v);
}
