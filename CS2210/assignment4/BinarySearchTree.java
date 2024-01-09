/**
 * 
 * Author: Hoyeon Luke Jang
 * Date: Nov 18, 2023
 * CS2210 - assignment 2
 * 
 * BinarySearchTree.java
 * This class represents a binary search tree
 */


public class BinarySearchTree{

    private BSTNode root;


    public BinarySearchTree(){

        this.root = null;
    
    }

    public BSTNode getRoot(){
        return this.root;
    }

    
    public BSTNode get(BSTNode r, Key k){

        //if r is a leaf, return r        
        if (r == null || r.isLeaf()) return r; 
        else{
            //if r contains the key, return r
            if (r.getRecord().getKey().compareTo(k) == 0){
                return r;
            }
            else if (r.getRecord().getKey().compareTo(k) < 0){
                return get(r.getLeftChild(), k);
            }
            else {
                return get(r.getRightChild(), k);
            }
        }
        
    }

    public void insert(BSTNode r, Record d) throws DictionaryException{

        BSTNode insertLocation = get(r, d.getKey());

        //if the tree is empty
        if (insertLocation == null){

            this.root = new BSTNode(d);
            this.root.setLeftChild(new BSTNode(null));
            this.root.getLeftChild().setParent(this.root);
            this.root.setRightChild(new BSTNode(null));
            this.root.getRightChild().setParent(this.root);

        }
        //if the insertLocation is a leaf node then insert the record
        else if (insertLocation.isLeaf()){

            insertLocation.setRecord(d);
            insertLocation.setLeftChild(new BSTNode(null));
            insertLocation.getLeftChild().setParent(insertLocation);
            insertLocation.setRightChild(new BSTNode(null));
            insertLocation.getRightChild().setParent(insertLocation);

        }
        else{
            throw new DictionaryException("Key already exists in the dictionary");
        }

    }

    public void remove(BSTNode r, Key k) throws DictionaryException{

        BSTNode removeLocation = get(r, k);

        if (removeLocation.isLeaf()) throw new DictionaryException("Key does not exist in the dictionary");
       
        //if the left child of removeLocation is a leaf then replace removeLocation with its right child.
        if (removeLocation.getLeftChild().isLeaf()){
            BSTNode parent = removeLocation.getParent();
        
            //if removeLocation is not the root
            if (parent != null){

                //replace removeLocation with its right child.
                if (parent.getLeftChild() == removeLocation){
                    parent.setLeftChild(removeLocation.getRightChild());
                    removeLocation.getRightChild().setParent(parent);
                }
                else{
                    parent.setRightChild(removeLocation.getRightChild());
                    removeLocation.getRightChild().setParent(parent);
                }

            }
            else{

                //if removeLocation is the root
                this.root = removeLocation.getRightChild();
                this.root.setParent(null);

            }

        }
        else{

            //else replace removeLocation with its predecessor
            BSTNode smallest = smallest(removeLocation.getRightChild());
            removeLocation.setRecord(smallest.getRecord());
            remove(smallest, smallest.getRecord().getKey());

        }

    }

    public BSTNode successor(BSTNode r, Key k) {
        BSTNode node = get(r, k);
    
        // if the right child is an internal node
        if (!node.isLeaf() && !node.getRightChild().isLeaf()){
            return smallest(node.getRightChild());
        } 
        else{
            // cruise up the node until the parent is null or the parent is greater than the given node
            while (node.getParent() != null && node.getParent().getRecord().getKey().compareTo(k) <= 0) {
                node = node.getParent();
            }
            return node.getParent();
        }
        
    }
    

    public BSTNode predecessor(BSTNode r, Key k) {
        BSTNode node = get(r, k);
    
        // if the left child is an internal node
        if (!node.isLeaf() && !node.getLeftChild().isLeaf()){
            return largest(node.getLeftChild());
        } 
        else{
            // cruise up the node until the parent is null or the parent is smaller than the given node
            while (node.getParent() != null && node.getParent().getRecord().getKey().compareTo(k) >= 0){
                node = node.getParent();
            }
            return node.getParent();
        }
    }
    

    public BSTNode smallest(BSTNode r) {
        // if the given node is empty, return null
        if (r == null || r.isLeaf()) return null;
        else {
            BSTNode smallest = r;

            while (!smallest.getLeftChild().isLeaf()) {
                smallest = smallest.getLeftChild();
            }

            return smallest;
        }
    }

    public BSTNode largest(BSTNode r) {
        // if the given node is empty, return null
        if (r == null || r.isLeaf()) return null;
        else {
            BSTNode largest = r;

            while (!largest.getRightChild().isLeaf()) {
                largest = largest.getRightChild();
            }

            return largest;
        }
    }
}