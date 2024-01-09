/**
 * 
 * Author: Hoyeon Luke Jang
 * Date: Nov 18, 2023
 * CS2210 - assignment 2
 * 
 * BSTDictionary.java
 * This class implements an ordered dictionary using a binary search tree. You must use a Record
 * object to store the data contained in each internal node of the tree. In your binary search tree
 * only the internal nodes will store information. The leaves must be nodes storing null Record
 * objects. The key for an internal node will be the Key object from the Record stored in that node.
 */

public class BSTDictionary implements BSTDictionaryADT{

    private BinarySearchTree tree;

    public BSTDictionary(){

        this.tree = new BinarySearchTree();

    }

    public Record get(Key k){

        BSTNode node = tree.get(tree.getRoot(), k);

        if (node.isLeaf()){
            return null;
        }
        else {
            return node.getRecord();
        }

    }

    public void put(Record d) throws DictionaryException{

        tree.insert(tree.getRoot(), d);

    }

    public void remove(Key k) throws DictionaryException{

        tree.remove(tree.getRoot(), k);

    }

    /* Returns the successor of k (the Record from the ordered dictionary 
       with smallest key larger than k); it returns null if the given key has
       no successor. Note that the given key k DOES NOT need to be in the dictionary. */
    public Record successor(Key k){

        return tree.successor(tree.getRoot(), k).getRecord();

    }

    /* Returns the predecessor of k (the Record from the ordered dictionary 
       with largest key smaller than k; it returns null if the given key has 
       no predecessor. Note that the given key k DOES NOT need to be in the dictionary.  */
    public Record predecessor(Key k){

        return tree.predecessor(tree.getRoot(), k).getRecord();

    }

    /* Returns the Record with smallest key in the ordered dictionary. 
       Returns null if the dictionary is empty.  */
    public Record smallest(){

        return tree.smallest(tree.getRoot()).getRecord();

    }

    /* Returns the Record with largest key in the ordered dictionary. 
       Returns null if the dictionary is empty.  */
    public Record largest(){

        return tree.largest(tree.getRoot()).getRecord();

    }
}
    

