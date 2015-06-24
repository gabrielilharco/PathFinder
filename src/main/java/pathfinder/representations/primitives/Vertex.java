package pathfinder.representations.primitives;

public class Vertex<T> {
	private T _value;
	
	public Vertex (T value) {
		_value = value;
	}
	
	public T get() {
		return _value;
	}
	
	public void set(T value) {
		_value = value;
	}
	
	@Override
	public int hashCode() {
		return this._value.hashCode();
	}
	
	@Override
	public boolean equals (Object o) {
		if (o instanceof Vertex<?>) {
			if (((Vertex<?>)o)._value.equals(_value)) {
				return true;
			}
		}
		return false;
//		return this._value.equals(o);
	}
}
