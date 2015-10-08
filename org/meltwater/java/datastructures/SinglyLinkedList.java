package org.meltwater.java.datastructures;
/* @Reference
 * This code was modified from http://www.mycstutorials.com/articles/data_structures/linkedlists
 */

public class SinglyLinkedList<E>{
	// reference to the head node.
	private LNode<E> head;
	private int size;
	
	// constructor
	public SinglyLinkedList(){
		head = new LNode<E>(null);
		size = 0;
	}
	
	/* appends the specified element to the end of this list.
	 * O(N)
	 * */	
	public void add(E data){
		LNode<E> temp = new LNode<E>(data);
		LNode<E> current = head;
		// starting at the head node, crawl to the end of the list
		while(current.getNext() != null)
		{
			current = current.getNext();
		}
		current.setNext(temp);
		size++;
	}
	
	// inserts the specified element at the specified position in this list.
	// O(N)
	public void add(E data, int index){
		LNode temp = new LNode(data);
		LNode<E> current = head;
		for(int i = 1; i < index && current.getNext() != null; i++){
			current = current.getNext();
		}
		temp.setNext(current.getNext());
		current.setNext(temp);
		size++;
	}
	
	/*
	 * Insert new node with value elem2, before node with value elem1
	 * O(N)
	 */
	public void insertBefore(E elem1, E elem2){
		LNode<E> temp = new LNode<E>(elem2);
		LNode<E> current = head;
		while(true){
			if((current.getNext() == null)) 
				break;
			if(current.getNext().getData() == elem1) break;
			current = current.getNext();
		}
		temp.setNext(current.getNext());
		current.setNext(temp);
		size++;
	}	
	
	public void insertAfter(E elem1, E elem2){
		LNode<E> temp = new LNode<E>(elem2);
		LNode<E> current = head;
		while(true){
			if((current.getNext() == null)) break;
			if(current.getData() == elem1) break;
			current = current.getNext();
		}
		temp.setNext(current.getNext());
		current.setNext(temp);
		size++;
	}
	
	// returns the element at the specified position in this list.
	// 	O(N)
	public E get(int index){
		if(index <= 0)
			return null;
		
		LNode current = head.getNext();
		for(int i = 1; i < index; i++)
		{
			if(current.getNext() == null)
				return null;
			
			current = current.getNext();
		}
		return (E) current.getData();
	}

	/*
	 * removes node with value e
	 * O(N)
	 */
	public boolean remove(E e){
		LNode<E> current = head;
		for(int i = 1; i < size; i++){
			if(current.getNext() == null)
				return false;
			
			if(i == 1){
				if(current.getData() == e){
					head = current.getNext();
					break;
				}
			}
			if(current.getNext().getData() == e){
				current.setNext(current.getNext().getNext());
				size--; 
				break;
			}
			current = current.getNext();
		}
		return true;
	}
	
	/*
	 * returns the number of elements in this list.
	 * O(N)
	 */
	public int size(){
		return size;
	}
	
	public String toString(){
		LNode ld = head();
		while (true) {
			if(ld == null) break;
			System.out.print("["+ld.getData()+"]->");
			ld = ld.getNext();
		}
		return "";
	}
	
	/*
	 * returns the first node of the list
	 */
	public LNode<E> head(){
		return head.getNext();
	}
	
	/*
	 * returns the last node of the list
	 * O(N)
	 */
	public LNode<E> tail(){
		if(size <= 1)
			return head.getNext();
		LNode<E> current = head.getNext();
		while (true) {
			if(current.getNext() == null) return current;
			current = current.getNext();
		}
	}
	
	/*
	 * returns a boolean whether the list is empty or not
	 * O(1)
	 */
	public boolean isEmpty(){
		return (size < 1) ? true : false;
	}
	
	/*
	 * reverses the order of the list
	 * O(N)
	 */
	public void reverse(){
		LNode before = head;
		LNode tmp = head.getNext();
		while (tmp != null) {
		    LNode next = tmp.getNext();
		    tmp.setNext(before);
		    before = tmp;
		    tmp = next;
		}
		head.setNext(before);
	}
}