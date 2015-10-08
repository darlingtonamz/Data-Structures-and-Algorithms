package org.meltwater.java.datastructures;

import java.util.Random;

public class Test {
	public static void main(String[] args){
		//Queue<Integer> q = new Queue<Integer>();
		SinglyLinkedList<Integer> sl = new SinglyLinkedList<Integer>();
		int[] arr = {34,45,132,8,3,41,48,5,6,87};
		for (int i = 0; i < arr.length; i++) {
			sl.add(arr[i]);
		}	
		//sl.remove(34);
		//sl.reverse();
		sl.insertBefore(3, 101);
		sl.toString();
		
		//System.out.println("\nhead: "+sl.head().getData()+"\nTail: "+sl.tail().getData());
		/*Stack<Integer> stk = new Stack<Integer>();
		for (int i = 0; i < 10; i++) {
			stk.push(i);
		}
		System.out.println(stk.toString());
		stk.pop();
		System.out.println(stk.toString());
		stk.size();
		System.out.println(stk.toString());
		
		System.out.println("Size: " + stk.size());
		
		//System.out.println("Contains: " + stk.contains(4));
		
		System.out.println("IsEmpty: " + stk.isEmpty());
		stk.clear();
		System.out.println(stk.toString());*/
		
		/*BinarySearchTree bst = new BinarySearchTree();
			
		bst.toString();
		System.out.println("\nSmallest: "+bst.smallest() +"\nLargest: "+bst.largest());*/
	}
}
