package org.meltwater.java.datastructures;
/* @Reference
 * This code was modified from http://www.codeproject.com/Articles/53366/Binary-Trees-in-Java
 */
public class BinarySearchTree<E extends Comparable>{
    Node<E> theBTRootNode;
    int size;

    public BinarySearchTree(){
        theBTRootNode = null;
        size = 0;
    }

    // ------------------ Addition of the node to the BST-------------------
    private Node<E> insertAB(Node theRootNode, Node<E> myNewNode) {
        if (theRootNode == null) {
            theRootNode = myNewNode;
            
        } else if (myNewNode.value.compareTo(theRootNode.value) < 0) {
            theRootNode.leftNode = insertAB(theRootNode.leftNode, myNewNode);
        } else {
            theRootNode.rightNode = 
               insertAB(theRootNode.rightNode, myNewNode);
        }
        size++;
        return theRootNode;
    }

    public void add(E e) {
    	Node<E> newNode = new Node<E>(e);
        theBTRootNode = insertAB(theBTRootNode, newNode);
    }
    public void remove(E key){
    	remove(key, theBTRootNode);
    }
    public void remove(E key, Node<E> pos){
/*    	if (pos == null) return;
        if (key.compareTo(pos.value)<0)
            remove (key, pos.leftNode);
        else if (key.compareTo(pos.value)>0)
            remove (key, pos.rightNode);
        else {
            if (pos.leftNode != null && pos.rightNode != null)
            {
                Node<E> maxFromLeft = rightMost (pos);
                pos.value = maxFromLeft.value;
                remove (maxFromLeft.value, pos.rightNode);
            }
            else if(pos.leftNode != null) {
                Node<E> trash = pos;
                pos = pos.leftNode;
                trash = null;
            }
            else if(pos.rightNode != null) {
                Node<E> trash = pos;
                pos.rightNode;
                trash = null;
            }
            else {
                pos = null;
            }
        }*//*
*/
    }

    /*
     * prints the tree in inorder form
     */
    private void inorder(Node theRootNode) {
        if (theRootNode != null) {
            inorder(theRootNode.leftNode);	// show left
            theRootNode.show(); 			// show root
            inorder(theRootNode.rightNode);	// show right
        }
    }

    /*
     * calls the method to do in order
     * O(N)
     */
    public String toString() {
        inorder(theBTRootNode);
        return null;
    }

    protected Node<E> search(Node theRootNode, E searchValue) {
        if (theRootNode == null) {
            return null;
        } else {
            if (searchValue.compareTo(theRootNode.value) == 0) {
                return theRootNode;
            } else if (searchValue.compareTo(theRootNode.value) < 0) {
                return search(theRootNode.leftNode, searchValue);
            } else {
                return search(theRootNode.rightNode, searchValue);
            }
        }
    }

    //returns null if no result else returns 
    public Node<E> searchBST(E keyName) {
        Node<E> temp = search(theBTRootNode, keyName);
        if (temp == null) {
           return null;
        } else {
           return temp;
        }
    }
    
    /*
     * calls searchBST (which is recursive) to get the node of an element
     * O(N)
     */
    public boolean contains(E e){
    	return (searchBST(e) == null) ? false : true;
    }
    
    private Node<E> leftMost(Node nd){
    	if(nd.leftNode == null)
    		return nd;
    	return leftMost(nd.leftNode);
    }
    
    private Node<E> rightMost(Node nd){
    	if(nd.rightNode == null)
    		return nd;
    	return rightMost(nd.rightNode);
    }
    
    /*
     * Searches for the smallest element in the tree
     * O(N)
     */
    public E smallest(){
    	return leftMost(theBTRootNode).value;
    }
    
    /*
     * Searches for the largest element in the tree
     * O(N)
     */
    public E largest(){
    	return rightMost(theBTRootNode).value;
    }
}