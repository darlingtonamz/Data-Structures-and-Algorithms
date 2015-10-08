package org.meltwater.java.datastructures;

import java.util.Random;

public class Test {
	public static void main(String[] args){
		//Queue<Integer> q = new Queue<Integer>();
		//SinglyLinkedList<Integer> sl = new SinglyLinkedList<Integer>();
		
		
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
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		int[] arr = {4,2,6,1,3,5,7};
		for (int i = 0; i < arr.length; i++) {
			bst.add(arr[i]);
		}	
		bst.remove(2);
		bst.toString();
		System.out.println("\nSmallest: "+bst.smallest() +"\nLargest: "+bst.largest());
	}
}
