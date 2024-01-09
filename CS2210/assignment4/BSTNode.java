/**
 * 
 * Author: Hoyeon Luke Jang
 * Date: Nov 18, 2023
 * CS2210 - assignment 2
 * 
 * BSTNode.java
 * This class represents a node of the binary search tree.
 */

public class BSTNode {

    private Record item;        //the record stored in the current node
    private BSTNode parent;     //the parent of the current node
    private BSTNode left;       //the left child of the current node
    private BSTNode right;      //the right child of the current node

    public BSTNode(Record item){

        this.item = item;
        this.parent = null;
        this.left = null;
        this.right = null;
        

    }
    
    public Record getRecord(){
        return this.item;
    }

    public void setRecord(Record d){
        this.item = d;
    }

    public BSTNode getLeftChild(){
        return this.left;
    }

    public BSTNode getRightChild(){
        return this.right;
    }

    public BSTNode getParent(){
        return this.parent;
    }

    public void setLeftChild(BSTNode u){
        this.left = u;
    }

    public void setRightChild(BSTNode u){
        this.right = u;
    }

    public void setParent(BSTNode u){
        this.parent = u;
    }

    public boolean isLeaf(){
        return ((this.left == null) && (this.right == null));
    }

}
