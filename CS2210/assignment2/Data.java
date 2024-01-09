/**
 * Author: Hoyeon Luke Jang
 * Date: Oct 18, 2023
 * 2210 assignment 2 
 * Data.java
 * 
 * Represents the records that will be stored in the HashDictionary Class. 
 * Each record stored in the dictionary will consists of two parts: a configuration and an integer score.
 */

public class Data {
    
    // instance variables
    private String config;      // board configuration represented in string. 
    private int score;          // score of the corresponding board configuration.

    /**
     * Constructor for Data class.
     * 
     * @param config board configuration represented in string.
     * @param score score of the corresponding board configuration.
     */
    public Data(String config, int score) {

        this.config = config;
        this.score = score;

    }

    /**
     * Returns the board configuration.
     * 
     * @return board configuration.
     */
    public String getConfiguration() {

        return this.config;
    
    }

    /**
     * Returns the score of the board configuration.
     * 
     * @return score of the board configuration.
     */
    public int getScore() {

        return this.score;
    
    }
    
}
