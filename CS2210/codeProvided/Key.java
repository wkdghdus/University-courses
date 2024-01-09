/**
 * 
 * Author: Hoyeon Luke Jang
 * Date: Nov 18, 2023
 * CS2210 - assignment 2
 * 
 * Key.java
 * This class represents the key of the data items stored in the internal nodes of the binary search
 * tree implementing the ordered dictionary. Each object of this class will have two instance variables:
 * label and type.
 * 
 */

public class Key {

    // instance variables
    private String label;
    private int type;


    public Key(String theLabel, int theType) {
    	this.label = theLabel.toLowerCase();
    	this.type = theType;
    }

    public String getLabel() {
    	return this.label;
    }

    public int getType() {
    	return this.type;
    }  

    /**
     * Comepares two key values
     * 
     * @param k another Key object to compare to this.key
     * @return 0 if equal, -1 if this Key object is smaller than k, and it returns 1 otherwise.
     */
    public int compareTo(Key k) {
    	
        if (this.label.equals(k.getLabel())) {
            //equal
            if (this.type == k.getType()){
                return 0;
            }
            //less than
            if (this.type < k.getType()){
                return -1;
            }
            //greater than
            else {
                return 1;
            }
        }
        //less than
        else if (this.label.compareTo(k.getLabel()) < 0){
            return -1;
        }
        //greater than
        else {
            return 1;

        }

    }
    
}
