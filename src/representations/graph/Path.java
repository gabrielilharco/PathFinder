package representations.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Path<E> implements Iterable<E>{
	private ArrayList<E> elements;
	
	public Path () {
		elements = new ArrayList<E>();
	}
	
	public Iterator<E> iterator() {
		return elements.iterator();
	}
	
	public void add(E elem) {
		elements.add(elem);
	}
	
	public int size() {
		return elements.size();
	}
	
	public List<E> getPath() {
		return elements;
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
	    
	    return this.elements.equals(other.getPath());
	}
	
	@Override
	public int hashCode () {
		return this.elements.hashCode();
	}
}
