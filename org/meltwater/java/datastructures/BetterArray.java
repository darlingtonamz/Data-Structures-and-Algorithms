package org.meltwater.java.datastructures;

import java.util.Arrays;

public class BetterArray<E>{
	E[] arr;
	private int size;
	
	public BetterArray(){
		this(10);
	}
	
	public BetterArray(int initSize){
		arr = (E[]) new Object[initSize];
		size = 0;
	}
	
	public void add(E e){		
		if (size == arr.length) {
			E[] newArr = (E[]) new Object[arr.length * 2];
			for (int i = 0; i < arr.length; i++) {
				newArr[i] = arr[i];
			}
			this.arr = newArr;
		} 
		this.arr[size++] = e;
	}
	

	/*
	 * 1.	insert(int position, E element) -> Inserts element at position.
	 */
	public void insert(int pos, E element){
		try {
			if(pos > size) throw new Exception();
			if (pos == size) {
				add(element);
				return;
			}else if(pos < size){
				for (int i = (size - 1); i >= pos; i--) {
					if(size == arr.length)
						add(arr[i]);
					else
						arr[i + 1] = arr[i];				
				}
				arr[pos] = element;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	

	/*
		2.	shift(E element) -> Insert element at the start of the array, usually position 0. Define shift in terms of insert (See 1).
	 */
	public void shift(E element){
		insert(0, element);
	}
	
	/*
		3.	append(E element) -> Append element to the end of the array. Define append in terms of insert (See 1).
		
	 */
	public void append(E element){
		insert(size, element);
	}
	
	private int find(E element){
		for (int i = 0; i < arr.length; i++) {
			if(!(arr[i] == null))
				if(arr[i].equals(element))
					return i;
		}
		return -1;
	}
	
	/*
	 * 4.	index(E element) -> Return the index of element in the array. If element isn't contained in the array return -1.
		
	 */
	public int index(E element){
		return find(element);
	}
	
	/*5.	contains(E element) -> Returns true if element is in array, false otherwise. Define contains in terms of index (See 4).
		
	 */
	public boolean contains(E element){
		return (find(element) >= 0) ? true : false;
	}
	
	/*
	 * 6.	get(int index) -> Returns element at position index. If index is less than 0 or greater than maximum position occupied by an element, throw an appropriate exception.
		
	 */
	public E get(int i){
		try {
			if ((i < 0) && (i > (arr.length - 1))) throw new Exception();	
			else{
				return arr[i];
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	/*
	 * 
	 * 7.	size() -> Returns the total number of elements in the array.
		
	 */
	public int size(){
		return size;
	}
	
	/* 8.	isEmpty() -> Returns true if array has no elements, false otherwise.
		
	 */
	public boolean isEmpty(){
		return (size > 0) ? false : true;
	}
	
	/*
	 * 9.	remove(int index) -> Delete element at position index.
		
	 */
	public void remove(int index){
		try {
			if(index > (size - 1)) throw new Exception();
			if (index == (size-1)) {
				arr[index] = null;
			}else if(index < (size-1)){
				for (int i = index; i < (size - 1); i++) {
					arr[i] = arr[i+1];
					if(i == (size - 2))
						arr[i+1] = null;				
				}
			}
		} catch (Exception e) {}
	}
	
	/* 	10.	remove(E element) -> Remove all occurrences of element from the array.
	 */
	public void remove(E element){
		for (int i = 0; i < arr.length; i++) {
			if(!(arr[i] == null))
				if(arr[i].equals(element))
					remove(element);
		}
	}
	
	/* 11.	reverse() -> Reverses the array.
	 */
	public void reverse(){
		if(size <= 1) return;
		int start = 0;
		int end = size-1;
		
		while (start < end) {
			E temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			
			start++; end--;
		}
	}
	
	/*		12.	toString() -> Returns a nice String representation of the elements in the array.
	 */
	public String toString(){
		return Arrays.toString(arr);
	}
	
	public static void main(String[] args){
		BetterArray<Integer> bt = new BetterArray<Integer>();
		for (int i = 0; i < 10; i++) {
			bt.add(i);
		}
			//bt.add(67);
			bt.reverse();
			
		System.out.println(bt.toString());
		System.out.println("Ans: "+(bt.contains(45)));
	}
}
