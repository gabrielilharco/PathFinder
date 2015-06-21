package representations;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class AdjacencyList<E> implements Iterable<E> {
	private int _size;
	private ListNode<E> _first;
	
    // helper linked list class
    private static class ListNode<E> {
        private E item;
        private ListNode<E> next;
        
        ListNode(E item) {
        	this.item = item;
        	next = null;
        }
    }
    
    AdjacencyList () {
    	_first = null;
    	_size = 0;
    }
    
    void add(E item) {
    	ListNode<E> oldFirst = _first;
    	_first = new ListNode<E>(item);
    	_first.next = oldFirst;
    	_size++;
    }
    
    
    public int size() {
    	return _size;
    }
    void remove() {
    	throw  new UnsupportedOperationException();
    }
    
    boolean isEmpty() {
    	return _size == 0;
    }
    
    public Iterator<E> iterator() {
    	return new ListIterator(_first);
    }
    
    
	private class ListIterator implements Iterator<E> {
		private ListNode<E> cursor;
		
		ListIterator(ListNode<E> first) {
			cursor = first;
		}
		
		public boolean hasNext() {
			return cursor != null;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		public E next() {
			if (!hasNext()) throw new NoSuchElementException();
			E item = cursor.item;
			cursor = cursor.next;
			return item;
		}
		
	}
}
