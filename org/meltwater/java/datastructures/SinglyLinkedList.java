package org.meltwater.java.datastructures;
/* @Reference
 * This code was modified from http://www.mycstutorials.com/articles/data_structures/linkedlists
 */

public class SinglyLinkedList<E>{
	// reference to the head node.
	private LNode<E> head;
	private int listCount;
	
	// constructor
	public SinglyLinkedList(){
		head = new LNode<E>(null);
		listCount = 0;
	}
	
	/* appends the specified element to the end of this list.
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
		listCount++;
	}
	
	// post: inserts the specified element at the specified position in this list.
	public void add(E data, int index){
		LNode temp = new LNode(data);
		LNode<E> current = head;
		for(int i = 1; i < index && current.getNext() != null; i++){
			current = current.getNext();
		}
		temp.setNext(current.getNext());
		current.setNext(temp);
		listCount++;
	}
	
	public void insertBefore(E elem1, E elem2){
		LNode temp = new LNode(elem2);
		LNode<E> current = head;
		while(true){
			if((current.getNext().getData() == elem1) || (current.getNext().getData() == null)) break;
			current = current.getNext();
		}
		temp.setNext(current.getNext());
		current.setNext(temp);
		listCount++;
	}	
	
	public void insertAfter(E elem1, E elem2){
		
	}
	// post: returns the element at the specified position in this list.
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
	
	// post: removes the element at the specified position in this list.
	/*public boolean remove(int index){
		if(index < 1 || index > size())
			return false;
		
		LNode current = head;
		for(int i = 1; i < index; i++){
			if(current.getNext() == null)
				return false;
			
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		listCount--; 
		return true;
	}*/
	
	// 34,2,54,8,5,1,4,7,79,4,6
	public boolean remove(E e){
		LNode<E> current = head;
		for(int i = 1; i < listCount; i++){
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
				listCount--; 
				break;
			}
			current = current.getNext();
		}
		return true;
	}
	
	// post: returns the number of elements in this list.
	public int size(){
		return listCount;
	}
	
	public String toString(){
		LNode ld = head();
		while (true) {
			if(ld.equals(null)) break;
			System.out.print("["+ld.getData()+"]->");
			if(ld.getNext().equals(null)) break;
			ld = ld.getNext();
		}
		return "";
	}
	
	public LNode<E> head(){
		return head.getNext();
	}
	
	public LNode<E> tail(){
		if(listCount <= 1)
			return head.getNext();
		LNode<E> current = head.getNext();
		while (true) {
			if(current.getNext() == null) return current;
			current = current.getNext();
		}
	}
	
	public boolean isEmpty(){
		return (listCount < 1) ? true : false;
	}
	
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