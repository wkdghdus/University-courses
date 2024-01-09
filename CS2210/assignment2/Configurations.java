/**
 * Author: Hoyeon Luke Jang
 * Date: Oct 18, 2023
 * 2210 assignment 2
 * 
 * Configurations.java
 * 
 * this class implements all the methods needed by algorithms to play the game
 * 
 */

public class Configurations {

    // instance variables
    private char[][] board;     // variable to store the current board config into a 2d array with rows and columns.
    private int lengthToWin;    // variable to store the X and + length to win.
    private int max_levels;     // variable to store the max levels of the algorithm's depth.

    /**
     * constructor for Configurations class.
     * 
     * @param board_size number of column and rows of the board
     * @param lengthToWin number of X and + in a row to win
     * @param max_levels max levels of the algorithm's depth
     */
    public Configurations (int board_size, int lengthToWin, int max_levels) {
        
        //initialize variables
        this.board = new char[board_size][board_size];
        this.lengthToWin = lengthToWin;
        this.max_levels = max_levels;

        //initialize the board with ' '
        for (int i = 0; i < board_size; i++) {

            for (int j = 0; j < board_size; j++) {

                this.board[i][j] = ' ';

            }

        }

    }

    /**
     * This function converts the board into a string.
     * 
     * @param board 2d array of the board
     * @return the board in a string format
     */ 
    private String boardToConfig(char[][] board){

        //declare variables
        String config = "";

        //initialize config to proper format
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board.length; j++) {

                config += board[i][j];

            }

        }

        return config;

    }   

    /**
     * Create a new dictionary with a size between 6000 - 10000 and is a prime number
     * 
     * @return a new dictionary
     */
    public HashDictionary createDictionary(){

        return new HashDictionary(9973);   //9973 is the biggest prime number before 10000

    }

    /**
     * This function checks if the config exists in the hash table.
     * 
     * @param hashTable 
     * @return -1 if the config does not exist, score if the config exists.
     */
    public int repeatedConfiguration(HashDictionary hashTable){

        //initialize variables
        String config = this.boardToConfig(this.board); //config of the current board

        //return -1 if the config does not exist, 
        //return the score if the config exists.
        return hashTable.get(config);

    }

    /**
     * This function stores the config and score into the hash table.
     * 
     * @param hashDictionary
     * @param score
     */
    public void addConfiguration(HashDictionary hashDictionary, int score){

        //initialize variables
        String config = this.boardToConfig(this.board); //config of the current board

        //add the config and score into the hash table.
        hashDictionary.put(new Data(config, score));

    }

    /**
     * This function stores the plays on the board.
     * 
     * @param row
     * @param col
     * @param symbol
     */
    
    public void savePlay(int row, int col, char symbol){

        //store the play in the board.
        this.board[row][col] = symbol;
    
    }

    /**
     * This function checks if the square is empty.
     * 
     * @param row
     * @param col
     * @return true if the square is empty, false if the square is not empty.
     */
    public boolean squareIsEmpty(int row, int col){

        //return true if the square is empty, false if the square is not empty.
        return this.board[row][col] == ' ';

    }

    /**
     * this function checks if a particular symbol has won.
     * 
     * @param symbol
     * @return true if the symbol has won, false if the symbol has not won.
     */
    public boolean wins(char symbol){

        //check for a cross win, where the symbol is in an intersecting diagonals
        for (int i = 0; i < this.board.length; i++) {

            for (int j = 0; j < this.board.length; j++) {

                if (this.board[i][j] == symbol) {

                    if (this.checkXPoints(symbol, i, j) >= this.lengthToWin) {

                        return true;

                    }
                    else if (this.checkCrossPoints(symbol, i, j) >= this.lengthToWin) {

                        return true;

                    }

                }

            }

        }

        //if there is no particular shape formed, return false
        return false;

    }

    
    /**
     * check if the X shape is formed having given position (row and column) as the center
     * 
     * @param symbol 
     * @param row
     * @param column
     * @return total point if it does form a X, 0 if it does not
     */
    private int checkXPoints(char symbol, int row, int column){

        //initialize variables
        int count = 1;  //number of symbols in the cross points

        //try and catch to check if the index is out of bound
        try{

            //check if the symbol forms a X, if not return 0, if yes proceed
            if ((this.board[row-1][column-1] != symbol) || (this.board[row+1][column+1] != symbol) || (this.board[row-1][column+1] != symbol) || (this.board[row+1][column-1] != symbol)){

                return 0;

            }
        }
        catch(ArrayIndexOutOfBoundsException e){

            return 0;

        }

        //check upper left diagonals
        for (int i = 1; i < this.board.length; i++) {

            //if the row and column is in bound and the symbol is the same, increment count
            if ((row-i >= 0) && (column-i >= 0) && (this.board[row-i][column-i] == symbol)){
                count++;
            }
            else{
                break;
            }

        }

        //check upper right diagonals
        for (int i = 1; i < this.board.length; i++) {

            //if the row and column is in bound and the symbol is the same, increment count
            if ((row-i >= 0) && (column+i < this.board.length) && (this.board[row-i][column+i] == symbol)){
                count++;
            }
            else{
                break;
            }

        }

        //check lower left diagonals
        for (int i = 1; i < this.board.length; i++) {

            //if the row and column is in bound and the symbol is the same, increment count
            if ((row+i < this.board.length) && (column-i >= 0) && (this.board[row+i][column-i] == symbol)){
                count++;
            }
            else{
                break;
            }

        }

        //check lower right diagonals
        for (int i = 1; i < this.board.length; i++) {

            //if the row and column is in bound and the symbol is the same, increment count
            if ((row+i < this.board.length) && (column+i < this.board.length) && (this.board[row+i][column+i] == symbol)){
                count++;
            }
            else{
                break;
            }

        }

        return count;
    
    }

    /**
     * Checks if the symbol forms a cross having given position (row and column) as the center
     * 
     * @param symbol
     * @param row
     * @param column
     * @return total point if it does form a cross, 0 if it does not
     */
    private int checkCrossPoints(char symbol, int row, int column){

        //initialize count
        int count = 1;  //number of symbols in the cross points

        //try and catch to check if the index is out of bound
        try{

            //if the symbol does not form a cross, return 0, if yes proceed
            if ((this.board[row-1][column] != symbol) || (this.board[row+1][column] != symbol) || (this.board[row][column-1] != symbol) || (this.board[row][column+1] != symbol)){

                return 0;

            }

        }
        catch(ArrayIndexOutOfBoundsException e){

            return 0;

        }

        //check upper row
        for (int i = 1; i < this.board.length; i++) {

            //if the row and column is in bound and the symbol is the same, increment count
            if ((row-i >= 0) && (this.board[row-i][column] == symbol)){
                count++;
            }
            else{
                break;
            }

        }

        //check lower row
        for (int i = 1; i < this.board.length; i++) {

            //if the row and column is in bound and the symbol is the same, increment count
            if ((row+i < this.board.length) && (this.board[row+i][column] == symbol)){
                count++;
            }
            else{
                break;
            }

        }

        //check left column
        for (int i = 1; i < this.board.length; i++) {

            //if the row and column is in bound and the symbol is the same, increment count
            if ((column-i >= 0) && (this.board[row][column-i] == symbol)){
                count++;
            }
            else{
                break;
            }

        }

        //check right column
        for (int i = 1; i < this.board.length; i++) {

            //if the row and column is in bound and the symbol is the same, increment count
            if ((column+i < this.board.length) && (this.board[row][column+i] == symbol)){
                count++;
            }
            else{
                break;
            }

        }

        return count;

    }

    /**
     * Determines whether the game is draw or not
     * 
     * @return true if the game is draw, false if the game is not draw
     */
    public boolean isDraw(){

        for (int i = 0; i < this.board.length; i++) {

            for (int j = 0; j < this.board.length; j++) {

                if (this.board[i][j] == ' ') {

                    return false;

                }

            }

        }

        //if there is no empty square, and someone has won, return true
        if (this.wins('X') || this.wins('O')) {

            return false;

        }
        //if there is no empty square, and no one has won, return true
        else{

            return true;

        }

    }


    /**
     * This function returns the score of the current board.
     * 
     * @return 3 if the computer wins, 0 if the human wins, 2 if the game is a draw, and 1 if it is still undecided.
     */
    public int evalBoard(){

        //if the computer wins, return 3
        if (this.wins('O')) {

            return 3;

        }
        //if the human wins, return 0
        else if (this.wins('X')) {

            return 0;

        }
        //if the game is a draw, return 2
        else if (this.isDraw()) {

            return 2;

        }
        //if the game is undecided, return 1
        else{

            return 1;

        }

    }

}
