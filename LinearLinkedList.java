/* Margaret Lee
 * cssc0933
 */
package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinearLinkedList<E> implements LinearListADT<E> { 
	private class Node<E>{
		E data;
		Node<E> next;
	
	public Node (E data){
		this.data = data;
		next = null;
		}
	}
	
	private Node <E> head, tail;
	private int currentSize;
	
	public LinearLinkedList(){
		head = tail = null;
		currentSize = 0;
	}

	public void addLast(E obj) {
		Node<E> newNode = new Node<E>(obj);
		if(isEmpty())
			head = tail = newNode;
		else{
			tail.next = newNode;
			tail = newNode;
		}
		currentSize++;
	}

	public void addFirst(E obj) {
		Node<E> newNode = new Node<E>(obj);
		if(isEmpty())
			head = tail = newNode;
		else{
			newNode.next = head;
			head = newNode; 
		}
		currentSize++;
	}

	public void insert(E obj, int location) {
		int index = location - 1;
		if(index > currentSize || index < 0){
			throw new RuntimeException("List elements must be contiguous");
		}
		Node<E> newNode = new Node<E>(obj);
		Node<E> previous = null, current = head;
		int count = 0;
		while(count < index){
			previous = current;
			current = current.next;
			count++;
		}
		if(previous == null)
			addFirst(obj);
		else if(current == null)
			addLast(obj);
		else{
			previous.next = newNode;
			newNode.next = current;
			currentSize++;
		}
	}

	public E remove(int location) {
		int index = location - 1;
		int count = 0;
		Node<E> previous = null, current = head;
		while(count < index){
			previous = current;
			current = current.next;
			count++;
		} 
		if(current == null)
			throw new RuntimeException("list is empty or location not within size");
		if(current == head)
			head = head.next;
		else if(current == tail){
			previous.next = null;
			tail = previous;
		}
		else
			previous.next = current.next;
		currentSize--;
		return current.data;
	}
	
	public E remove(E obj) {
		Node<E> previous = null, current = head;
		while(current != null && ((Comparable<E>)obj).compareTo(current.data) != 0){
			previous = current;
			current = current.next;
		}
		if(current == null)
			return null;
		if(current == head)
			head = head.next;
		else if(current == tail){
			previous.next = null;
			tail = previous;
		}	
		else
			previous.next = current.next;
		if(head == null)
			tail = null;
		currentSize--;
		return current.data;
	}

	
	public E removeFirst() {
		if(isEmpty())
			return null;
		return remove(1);
	}

	public E removeLast() {
		if(isEmpty())
			return null;
		return remove(currentSize);
	}

	public E get(int location) {
		int index = location - 1;
		Node<E> tmp = head;
		int count = 0;
		if(index > currentSize || index < 0)
			throw new RuntimeException("location not within current size");
		while(count < index){
			tmp = tmp.next;
			count++;
		}
		return tmp.data;
	}

	public boolean contains(E obj) {
		Node<E> tmp = head;
		while(tmp != null){
			if(((Comparable<E>)obj).compareTo(tmp.data) == 0)
				return true;
			tmp = tmp.next;
		}
		return false;
	}

	public int locate(E obj) {
		Node<E> tmp = head;
		int count = 1;
		while(count <= currentSize){
			if(((Comparable<E>)obj).compareTo(tmp.data) == 0)
				return count;
			else{
				tmp = tmp.next;
				count++;
			}
		}
		return -1;
	}

	public void clear() {
		head = null;
		tail = null;
		currentSize = 0;
	}

	public boolean isEmpty() {
		if(currentSize == 0)
			return true;
		return false;
	}

	public int size() {
		return currentSize;
	}

	public Iterator<E> iterator() {
		return new IteratorHelper();
	}
	private class IteratorHelper implements Iterator<E>{
		int iterIndex;
		private Node<E> tmpNode;
		
		public IteratorHelper(){
			tmpNode = head;
		}
		
		public boolean hasNext(){
			return tmpNode != null;
		}

		public E next() {
		if (!hasNext())
			throw new NoSuchElementException();
		E data = tmpNode.data;
		tmpNode = tmpNode.next;
		return data;
		}

		public void remove() {
		throw new UnsupportedOperationException();
		}
	}
}