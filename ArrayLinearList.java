/* Margaret Lee
 * cssc0933
 */

package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayLinearList<E> implements LinearListADT<E> {
	private E[] array;
	private int currentSize;
	private int maxSize;

	@SuppressWarnings("unchecked")
	public ArrayLinearList() {
		array = (E[]) new Object[DEFAULT_MAX_CAPACITY];
		currentSize = 0;
		maxSize = DEFAULT_MAX_CAPACITY;
	}
	
	public void addLast(E obj) { 
		insert(obj, currentSize + 1);
	}
	
	public void addFirst(E obj) {
		insert(obj,1);	
	}
	
	//inserts object at specified location,
	//throws error if location is outside currentSize
	public void insert(E obj, int location) {
		if(currentSize == maxSize)
			increase();
		int index = location - 1;
		if(index > currentSize || index < 0){
			throw new RuntimeException("List elements must be contiguous");
		}
		else{
			currentSize++;
			
			for (int i = currentSize - 1; i > index; i--) {
				array[i] = array[i - 1];
			}
			array[index] = obj;
		}

	}
	
	//removes object at specified location
	//throws error is location is not in current size
	public E remove(int location) {
		int index = location - 1;
		if (isEmpty()) {
			throw new RuntimeException("cannot remove from empty list");
		} 
		else if(index >= currentSize || index < 0) {
			throw new RuntimeException("cannot remove from outside current size");
			}
		else{
			E obj = array[index];
			for (int i = index; i < currentSize - 1; i++) {
				array[i] = array[i + 1];
			}
			currentSize--;
			if (currentSize * 4 <= maxSize)
				decrease();
			return obj;
		}
	}
	
	//removed specified object from list
	//returns object
	public E remove(E obj) {
		for (int i = 0; i < currentSize; i++) {
			if (obj == array[i]) {
				E removed = array[i];
				for (int j = i; j < currentSize - 1; j++) {
					array[j] = array[j + 1];
				}
				currentSize--;
				if (currentSize * 4 <= maxSize) 
					decrease();
				return removed;
			}
		}
		return null;
	}

	public E removeFirst() {
		if(currentSize > 0)
			remove(1);
		return null;
	}

	public E removeLast() {
		if(currentSize > 0)
			remove(currentSize);
		return null;
	}
	
	//returns object at location
	public E get(int location) {
		int index = location - 1;
		if(index > currentSize - 1 || index < 0){
			throw new RuntimeException("location not within current size");
		}
		else{
			E obj = array[index];
			return obj;
		}
	}

	//returns true if object is in list
	@SuppressWarnings("unchecked")
	public boolean contains(E obj) {
		for (int i = 0; i < currentSize; i++) {
			if(((Comparable<E>)obj).compareTo(array[i]) == 0)
				return true;
			}
		return false;
	}


	//returns location of object
	@SuppressWarnings("unchecked")
	public int locate(E obj) {
		for (int i = 0; i < currentSize; i++) {
			if(((Comparable<E>)obj).compareTo(array[i]) == 0)
			{
				int location = i + 1;
				return location;
			}
		}
		return -1; 
	}

	public void clear() {
		currentSize = 0;
	}
	//returns true if list if empty
	public boolean isEmpty() {
		if (currentSize == 0) {
			return true;
		} else
			return false;
	}

	public int size() {
		int size = currentSize;
		return size;
	}

	public Iterator<E> iterator() {
		return new IteratorHelper();
	}
	private class IteratorHelper implements Iterator<E>{
		int iterIndex;
		long stateCheck;
		
		public boolean hasNext() {
			return iterIndex < currentSize;
		}

		public E next() {
		if (!hasNext())
			throw new NoSuchElementException();
		return array[iterIndex++];
		}

		public void remove() {
		throw new UnsupportedOperationException();
		}
	}
	//doubles size of list
	private void increase() {
			maxSize = maxSize * 2;
			@SuppressWarnings("unchecked")
			E[] biggerArr = (E[]) new Object[maxSize];
			for (int i = 0; i < currentSize; i++) {
				biggerArr[i] = array[i];
			}
			array = biggerArr;
		
	}
	//decreases the size of list by half
	private void decrease() {
			maxSize = maxSize / 2;
			@SuppressWarnings("unchecked")
			E[] smallerArr = (E[]) new Object[maxSize];
			for (int i = 0; i < currentSize; i++) {
				smallerArr[i] = array[i];
			}
			array = smallerArr;
	}

}