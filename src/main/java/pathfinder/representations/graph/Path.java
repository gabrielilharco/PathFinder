package pathfinder.representations.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Path implementation for storing algorithm results
public class Path<E> implements Iterable<E>{
	private ArrayList<E> _elements;
	private double _totalWeight;
	
	public Path () {
		_elements = new ArrayList<E>();
		_totalWeight = 0.0;
	}
	
	public Iterator<E> iterator() {
		return _elements.iterator();
	}
	
	public void add(E elem) {
		_elements.add(elem);
	}
	
	public int size() {
		return _elements.size();
	}
	
	public List<E> getPath() {
		return _elements;
	}
	
	public double getTotalWeight() {
		return _totalWeight;
	}

	public void setTotalWeight(double pathWeight) {
		_totalWeight = pathWeight;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (E s : _elements) {
		    sb.append(s);
		    sb.append('-');
		}
		return sb.toString();
	}
	
	@Override
	public boolean equals (Object obj) {
		if (obj == null)
	         return false;
	     if (this == obj)
	          return true;
	     if (!(obj instanceof Path<?>))
	          return false;
	     
	    Path<?> other = (Path<?>)obj;
	    
	    return this._elements.equals(other.getPath());
	}
	
	@Override
	public int hashCode () {
		return this._elements.hashCode();
	}
}