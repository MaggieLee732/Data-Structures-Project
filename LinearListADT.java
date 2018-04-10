package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface LinearListADT<E> extends Iterable<E> {
	public static final int DEFAULT_MAX_CAPACITY = 100;

	public void addLast(E obj);
	
	public void addFirst(E obj);
	
	public void insert(E obj, int location); 
	
	public E remove(int location);
	
	public E remove(E obj);
	
	public E removeFirst();   
	
	public E removeLast();  
	
	public E get(int location);
	
	public boolean contains(E obj);  
	
	public int locate(E obj); 
	
	public void clear();
	
	public boolean isEmpty();
	
	public int size();
	
	public Iterator<E> iterator(); 
}


