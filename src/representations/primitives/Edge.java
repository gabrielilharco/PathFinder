package representations.primitives;

public class Edge<V> {
	private V _v1;
	private V _v2;
	
	public Edge(V v1, V v2) {
		_v1 = v1;
		_v2 = v2;
	}

	public V getV1() {
		return _v1;
	}

	public V getV2() {
		return _v2;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
	         return false;
	     if (this == obj)
	          return true;
	     if (!(obj instanceof Edge<?>))
	          return false;
	     
	    Edge<?> other = (Edge<?>)obj; 
	     
	    return this._v1 == other.getV1() && 
	    		this._v2 == other.getV2();
	}
	
	@Override
	public int hashCode() {
		//http://tinyurl.com/pmugwje
		 int hash = 17; 
	     hash = 31 * hash + _v1.hashCode();
	     hash = 31 * hash + _v2.hashCode();
	     return hash;
	}
}
