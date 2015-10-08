package org.meltwater.java.datastructures;

public class Node{

    public Node leftNode,  rightNode; // the nodes
    public int value; //the AnyClass objext

    public Node(int v ) {//constructor
        this.value = v;
        this.leftNode = null;
        this.rightNode = null;
    }

    public void show() {
        //calls the show method of the AnyClass
        System.out.print(value + " | ");
    }
}
