/**
 * Author: Hoyeon Luke Jang
 * Date: Oct 18, 2023
 * 2210 assignment 2 
 * HashDictionary.java
 * 
 *  class that implements given Dictionary ADT using a hash table and linked list
 * 
 */

import java.util.LinkedList;

public class HashDictionary implements DictionaryADT{
    
    // instance variables
    private LinkedList<Data>[] dict;        // dictionary that stores the records.

    /**
     * HashDictionary constructor that takes an integer as a parameter and creates a hash table of that size.
     * 
     * @param size
     */
    public HashDictionary(int size) {

        //the dictionary will be implemente by an array of linked lists.
        this.dict = (LinkedList<Data>[]) new LinkedList<?>[size];

    }

    /**
     * Polynomial hash function that takes a string and returns an integer.
     * Uses a = 41, which was shown and taught to be effective in polynomial hash function.
     * 
     * 
     * @param config
     * @return the hash index of the hash table.
     */
    private int polynomialHashFunction(String config) {

        //initialize variables
        long hashIndex = 0;   //index of the hash table (long to prevent overflow)
        int a = 41;          //a value for polynomial hash function, which was shown to be effective.

        //create a hash index using polynomial hash function.
        for (int i = 0; i < config.length(); i++) {

            hashIndex = (a * hashIndex + (int)config.charAt(i));

        }

        //make sure the hash index is within the range of the hash table.
        hashIndex = hashIndex % this.dict.length;

        //if hash index is negative, make it positive.
        if (hashIndex < 0) {

            hashIndex *= -1;

        }

        return (int)hashIndex;

    }

    /**
     * add data type variable to the dictionary.
     * 
     * @param record
     * @returns 1 if there was a collision, 0 if the record was successfully added.
     * @throws DictionaryException when you add duplicated config to the dictionary.
     */
    public int put(Data record) throws DictionaryException {

        //initialize variables
        int index = this.polynomialHashFunction(record.getConfiguration()); //index of the hash table using polynomial hash function.
        
        //// inputting the element into the hash table. ////

        // if the index is empty, put the record in the index as a linked node.
        if (this.dict[index] == null){

            //create a new linked list
            this.dict[index] = new LinkedList<Data>();
            this.dict[index].add(record);
            return 0;

        }
        //if the index is not empty
        else {

            //check if the linked list contains the same key.
            //can't use contain funtion of linked list because it uses equals method of Data class which is not initialized
            for (int i = 0; i < this.dict[index].size(); i++) {

                // if the configuration is the same, throw an exception.
                if (this.dict[index].get(i).getConfiguration().equals(record.getConfiguration())) {

                    throw new DictionaryException();

                }

            }

            //if it is a collision add the record to the linked list using separate chaining.
            this.dict[index].add(record);

            //return 1 to indicate collision has happened
            return 1;

        }
        
    }

    /**
     * remove method that has same configuration as the parameter.
     * 
     * 
     * @param config
     */
    public void remove(String config) throws DictionaryException{

        //initialize variables
        int index = this.polynomialHashFunction(config); //index of the hash table using polynomial hash function.

        //if the index is empty, throw an exception.
        if (this.dict[index] == null) {

            throw new DictionaryException();

        }
        //if the index is not empty
        else {

            //check if the linked list contains the same key.
            //can't use contain funtion of linked list because it uses equals method of Data class which is not initialized
            for (int i = 0; i < this.dict[index].size(); i++) {

                // if the configuration is the same, remove the record.
                if (this.dict[index].get(i).getConfiguration().equals(config)) {

                    this.dict[index].remove(i);
                    return;

                }

            }

            //if the configuration is not found, throw an exception.
            throw new DictionaryException();

        }

    }


    /**
     * get method that returns the score of the configuration.
     * 
     * @param config
     * @return score of the configuration. -1 if the configuration is not found.
     */
    public int get(String config){

        //initialize variables
        int index = this.polynomialHashFunction(config); //index of the hash table using polynomial hash function.

        //if the index is empty, return -1.
        if (this.dict[index] == null) {

            return -1;

        }
        //if the index is not empty
        else {

            //check if the linked list contains the same key.
            //can't use contain funtion of linked list because it uses equals method of Data class which is not initialized
            for (int i = 0; i < this.dict[index].size(); i++) {

                // if the configuration is the same, return the score.
                if (this.dict[index].get(i).getConfiguration().equals(config)) {

                    return this.dict[index].get(i).getScore();

                }

            }

            //if the configuration is not found, return -1.
            return -1;

        }

    }


    /**
     * @returns the number of records in the dictionary.
     */
    public int numRecords(){

        //initialize variables
        int numRecords = 0; //number of records in the dictionary.

        //count the number of records in the dictionary.
        for (int i = 0; i < this.dict.length; i++) {

            numRecords += this.dict[i].size();

        }

        return numRecords;

    }

}
