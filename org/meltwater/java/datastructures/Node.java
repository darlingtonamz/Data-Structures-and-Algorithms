package org.meltwater.java.datastructures;

public class Node<E>{

    public Node<E> leftNode,  rightNode; // the nodes
    public E value; //the AnyClass objext

    public Node(E v ) {//constructor
        this.value = v;
        this.leftNode = null;
        this.rightNode = null;
    }

    public void show() {
        //calls the show method of the AnyClass
        System.out.print(value + " | ");
    }
}
