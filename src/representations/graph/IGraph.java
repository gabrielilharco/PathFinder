package representations.graph;

public interface IGraph<V> {
	
	public int degree (V v);
	public Iterable<V> adj(V v);
	
	public int V ();
	public int E ();
}
