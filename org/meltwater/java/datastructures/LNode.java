package org.meltwater.java.datastructures;

public class LNode<E>{
	LNode<E> next;
	private E data;
	
	public LNode(E _data){
		next = null;
		data = _data;
	}
	
	public LNode(E _data, LNode _next){
		next = _next;
		data = _data;
	}
	
	public E getData(){
		return data;
	}
	
	public void setData(E _data){
		data = _data;
	}
	
	public LNode<E> getNext(){
		return next;
	}
	
	public void setNext(LNode _next){
		next = _next;
	}
}
