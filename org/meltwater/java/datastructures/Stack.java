package org.meltwater.java.datastructures;

import java.util.Arrays;

public class Stack<E> {
	private E[] arr;
	private int size; 
	
	public Stack(){
		this(10);
	}
	
	public Stack(int length){
		arr = (E[]) new Object[length];
		size = 0;
	}

	public void push(E element){
		try {
			if (size == arr.length) throw new StackOverflowError();
			this.arr[size++] = element;
		} catch (StackOverflowError e) {
			// TODO: handle exception
		}
	}
	
	public void pop(){
		arr[--size] = null;
	}
	
	public String toString(){
		return Arrays.toString(arr);
	}
	
	public int size(){ return size; }

	public E peek(){ return arr[size - 1];}
	
	public boolean isEmpty(){
		return (size > 0) ? true : false;
	}
	
	public boolean isFull(){
		return (size == arr.length) ? true : false;
	}
	
	public void clear(){
		arr = (E[]) new Object[10];
		size = 0;
	}
}
