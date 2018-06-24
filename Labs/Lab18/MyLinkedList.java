import java.util.Iterator;

public class MyLinkedList<E> extends MyAbstractList<E>{
	private Node<E> head, tail;
	
	private static class Node<E>{
		E element;
		Node<E> next;
		Node<E> prev;
		public Node(E element){
			this.element = element;
		}
	}
	
	//default list
	public MyLinkedList(){
		
	}
	
	//list of array of objects
	public MyLinkedList(E[] objects){
		super(objects);
	}
	
	//return head element from the list
	public E getFirst(){
		if(size == 0){
			return null;
		}
		else{
			return head.element;
		}
	}
	
	//return last elements from the list
	public E getLast(){
		if(size == 0){
			return null;
		}
		else{
			return tail.element;
		}
	}
	
	
	
	@Override
	public void add(int index, E e) {//
		if(index <= 0){
			addFirst(e);//insert first
		}
		else if(index >= size - 1){
			addLast(e);//insert last
		}
		else{
			Node<E> current = head;
			for(int i = 1; i < index; i++){
				current = current.next;
			}
			Node<E> temp = new Node<>(e);
			temp.next = current.next;
			temp.prev = current;
			current.next.prev = temp;
			current.next = temp;//update second pointer
			size++;
		}
	}

	public void addFirst(E e) {//
		Node<E> newNode = new Node<>(e);
		if(isEmpty()){
			newNode.next = null;
			newNode.prev = null;
			head = newNode;
			tail = newNode;
		}
		else{
			head.prev = newNode;
			newNode.next = head;
			newNode.prev = null;
			head = newNode;
		}
	}

	public void addLast(E e) {//
		Node<E> newNode = new Node<>(e);
		if(tail == null){
			head = tail = newNode;
			newNode.next = head;
			newNode.prev = tail;
			
		}
		else{
			tail.next = newNode;
			tail = tail.next;
		}
		size++;
	}
	
	@Override
	public void clear() {
		size = 0;
		head = tail = null;
		
	}

	@Override
	public boolean contains(E e) {
		return true;//return true if this contains the element
	}
	
	public boolean isEmpty(){
		return (head == null);// if the list contains no elements
	}
	 /** Remove the first occurrence of the element o from this list.
	   *  Shift any subsequent elements to the left.
	   *  Return true if the element is removed. */
	public boolean remove(E e){
		if(indexOf(e) >= 0){
			remove(indexOf(e));
			return true;
		}
		else{
			return false;
		}
		
	}

	@Override
	public E get(int index) {
		//return the element from this list at the specified index
		if(index < 0 || index > size - 1){
			return null;
		}
		Node<E> current = head;
		for(int i = 0; i < index; i++){
			current = current.next;
		}
		return current.element;
	}
	


	@Override
	public int indexOf(E e) {
		//return index of the first matching elements in this list return -1 if no math
		Node<E> current = head;
		for(int i = 0; i < size; i++){
			if(current.element.equals(0)){//(e)
				return i;
			}
			current = current.next;
		}
		return -1;
	}
	
	@Override
	public int lastIndexOf(E e) {
		//return the index of the last matching element in this list return -1 if no match
		int lastIndex = -1;
		Node<E> current = head; 
		for(int i = 0; i < size; i++){
			if(current.element.equals(e)){
				lastIndex = i;
			}
			current = current.next;
		}
		return lastIndex;
	}
	public E removeFirst() {//
		if(size == 0){
			return null;
		}
		else{
			Node<E> temp = head;

			if(temp.next == null) {
				temp = null;
				tail = null;
			}
			else{
				temp = temp.next;
				temp.prev = null;
				size--;
			}
			return temp.element;
		}
	}
	
	public E removeLast(){
		if(size == 0){
			return null;
		}
		else if(size == 1){
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		}
		else{
			Node<E> current = head;
			
			for(int i = 0; i < size - 2; i++){
				current = current.next;
			}
			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}
	}
	/** Remove the element at the specified position in this list
	   *  Shift any subsequent elements to the left.
	   *  Return the element that was removed from the list. */
	@Override
	public E remove(int index) {
		if(index < 0 || index >= size){
			return null;
		}
		else if(index == 0){
			return removeFirst();
		}
		else{
			Node<E> previous = head;
			for(int i = 1; i < index; i++){
				previous = previous.next;
			}
			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}
	}

	
	
	/** Replace the element at the specified position in this list
	   *  with the specified element and returns the new set. */
	@Override
	public Object set(int index, E e) {
		if(index < 0 || index > size - 1){//she didn't use this
			return null;
		}
		Node<E> current = head;
		for( int i = 0; i < index; i++){
			current = current.next;
		}
		E temp = current.element;
		current.element = e;
		return temp;
	}

	/** Return the number of elements in this list */
	public int size(){
		return size;
		
	}
	
	@Override
	public Iterator<E> iterator() {
		
		return (Iterator<E>) new LinkedListIterator();
	}
	
	private class LinkedListIterator<E>{
		private Node<E> current = (Node<E>) head;
		
		
	}
}
