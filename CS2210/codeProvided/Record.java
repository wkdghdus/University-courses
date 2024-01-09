/**
 * 
 * Author: Hoyeon Luke Jang
 * Date: Nov 18, 2023
 * CS2210 - assignment 2
 * 
 * Record.java
 * This class represents the records to be stored in the internal nodes of the binary search tree. Each
 * object of this class will have two instance variables: Key theKey and String data.
 * 
 */


public class Record {

    // instance variables
    private Key theKey;
    private String data;
    
    public Record(Key k, String theData){

        this.theKey = k;
        this.data = theData;

    }

    public Key getKey(){
        return this.theKey;
    }

    public String getDataItem(){
        return this.data;
    }

}
