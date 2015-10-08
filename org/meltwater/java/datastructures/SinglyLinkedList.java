package org.meltwater.java.datastructures;
/* @Reference
 * This code was modified from http://www.mycstutorials.com/articles/data_structures/linkedlists
 */

public class SinglyLinkedList<E>{
	// reference to the head node.
	private Node head;
	private int listCount;
	
	// constructor
	public SinglyLinkedList(){
		head = new Node(null);
		listCount = 0;
	}
	
	/* appends the specified element to the end of this list.
	 * */	
	public void add(E data){
		Node temp = new Node(data);
		Node current = head;
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
		Node temp = new Node(data);
		Node current = head;
		for(int i = 1; i < index && current.getNext() != null; i++){
			current = current.getNext();
		}
		temp.setNext(current.getNext());
		current.setNext(temp);
		listCount++;
	}
	
	// post: returns the element at the specified position in this list.
	public E get(int index){
		if(index <= 0)
			return null;
		
		Node current = head.getNext();
		for(int i = 1; i < index; i++)
		{
			if(current.getNext() == null)
				return null;
			
			current = current.getNext();
		}
		return current.getData();
	}
	
	// post: removes the element at the specified position in this list.
	public boolean remove(int index){
		if(index < 1 || index > size())
			return false;
		
		Node current = head;
		for(int i = 1; i < index; i++){
			if(current.getNext() == null)
				return false;
			
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		listCount--; 
		return true;
	}
	
	// post: returns the number of elements in this list.
	public int size(){
		return listCount;
	}
	
	public String toString(){
		Node current = head.getNext();
		String output = "";
		while(current != null)
		{
			output += "[" + current.getData().toString() + "]-> ";
			current = current.getNext();
		}
		return output;
	}
	
	private class Node{
		Node next;
		E data;
		
		public Node(E _data){
			next = null;
			data = _data;
		}
		
		public Node(E _data, Node _next){
			next = _next;
			data = _data;
		}
		
		public E getData(){
			return data;
		}
		
		public void setData(E _data){
			data = _data;
		}
		
		public Node getNext(){
			return next;
		}
		
		public void setNext(Node _next){
			next = _next;
		}
	}
}