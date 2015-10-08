package org.meltwater.java.datastructures;

import java.util.Arrays;

public class Queue<E> {
	// pop <- 1:2:3:4:-:-:-: <- push
	private E[] arr;
	private int size; 
	
	public Queue(){
		this(10);
	}
	
	public Queue(int length){
		arr = (E[]) new Object[length];
		size = 0;
	}

	public void push(E element){
		try {
			if (size == arr.length) throw new Exception();
			this.arr[size++] = element;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void pop(){
		try {
			for (int i = 0; i < (size - 1); i++) {
				arr[i] = arr[i+1];
				if(i == (size - 2))
					arr[i+1] = null;				
			}			
		} catch (Exception e) {}
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
