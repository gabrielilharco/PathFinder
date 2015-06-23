package representations;

import java.util.ArrayList;
import java.util.Iterator;

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
}
