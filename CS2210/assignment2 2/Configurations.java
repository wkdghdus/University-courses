/**
 * This will be the class configurations
 *
 * Class: CS2210
 * Date: Oct 17 2023
 * @author James Wong
 */

public class Configurations {

    /** the size of the board */
    private int board_size;

    /** the length of the X-shape or +shape needed to win the game */
    private int lengthToWin;

    /** the maximum level of the game tree that will be explored by the program */
    private int max_levels;

    /** an instance variable board of type char[][] to store the game board */
    private char[][] gameBoard;

    /**
     * Name: Configurations
     * @param board_size size of the board
     * @param lengthToWin length of the X-shape or +shape needed to win the game
     * @param max_levels maximum level of the game tree that will be explored by the program
     */
    public Configurations (int board_size, int lengthToWin, int max_levels) {
        this.board_size = board_size;
        this.lengthToWin = lengthToWin;
        this.max_levels = max_levels;

        gameBoard = new char[board_size][board_size];

        for (int i=0; i<board_size; i++) {            // rows
            for (int j=0; j<gameBoard[i].length; j++) {     // columns
                gameBoard[i][j] = ' ';
            }
        }
    }

    /**
     * Name: HashDictionary
     * select the size of the hash table, keeping in mind that it must be a prime number.
     * A table of size between 6 000-10 000
     * @return new HashDictionary(board_size)
     */
    public HashDictionary createDictionary() {
        return new HashDictionary(9939);
    }

    /**
     * Name: repeatedConfiguration
     * This method first stores the characters of board in a String as described above;
     * then it checks whether the String representing the board is in hashTable:
     * If the String is in hashTable this method returns its associated score,
     * otherwise it returns the value -1.
     * @param hashTable
     * @return hold or -1
     */
    public int repeatedConfiguration(HashDictionary hashTable) {
        String config = "";
        // Goes through each character in the game board and stores it in a string
        for (int i=0; i<gameBoard.length; i++) {
            for (int j=0; j<gameBoard[i].length; j++) {
                config+=(gameBoard[i][j]);
            }
        }

        int hold = hashTable.get(config.toString());    // stores whether the configuration is in the hash table

        if (hold != -1) {
            return hold;        // configuration found
        } else {
            return -1;          // configuration not found
        }
    }

    /**
     * Name: addConfiguration
     * This method first represents the content of board as a String as described above;
     * then it inserts this String and score in hashDictionary.
     * @param hashDictionary
     * @param score
     */
    public void addConfiguration(HashDictionary hashDictionary, int score) {
        String config = "";
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[row].length; col++) {
                config+=(gameBoard[row][col]);
            }
        }
        hashDictionary.put(new Data(config, score));
    }

    /**
     * Name: save
     * Play
     * Stores symbol in board[row][col]
     * @param row indicated row
     * @param col indicated column
     * @param symbol symbol stored in the gameBoard
     */
    public void savePlay(int row, int col, char symbol){
        gameBoard[row][col] = symbol;
    }

    /**
     * Name: squareIsEmpty
     *  Returns true if board[row][col] is ’ ’; otherwise it returns false
     * @param row indicated row
     * @param col indicated column
     * @return gameBoard[row][col] == ' '
     */
    public boolean squareIsEmpty (int row, int col){
        return gameBoard[row][col] == ' ';
    }

    /**
     * Name: wins
     * Returns true if there is an X-shape or a +shape of length at least k formed by tiles of the kind symbol on the board,
     * where k is the length of the X-shape or +shape needed to win the game
     * @param symbol
     * @return true or false
     */
    public boolean wins(char symbol) {

        for (int i = 0; i < board_size; i++) {

            for (int j = 0; j < board_size; j++) {
                if (gameBoard[i][j] == symbol) {
                    if (this.checkXPoints(symbol, i, j) >= this.lengthToWin) {
                        return true;
                    }

                    if (this.checkPlusPoints(symbol, i, j) >= this.lengthToWin) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Name: checkXPoints
     * checks the number of points in the X shape
     * @param symbol
     * @param row
     * @param column
     * @return 0 or count
     */
    private int checkXPoints(char symbol, int row, int column){

        int k = 1;      // k is the length of the X-shape or +shape needed to win the game

        //try and catch to check
        try{

            // checking all corners for an existing X
            if ((this.gameBoard[row-1][column-1] != symbol) || (this.gameBoard[row+1][column+1] != symbol)) {
                if ((this.gameBoard[row - 1][column + 1] != symbol) || (this.gameBoard[row + 1][column - 1] != symbol)) {
                    return 0;
                }
            }

            for (int i = 1; i < board_size; i++) {

                //check top left diagonals
                if ((row-i >= 0) && (column-i >= 0) && (this.gameBoard[row-i][column-i] == symbol)){
                    k++;
                } else{
                    break;
                }
            }

            for (int i = 1; i < board_size; i++) {

                //check top right diagonals
                if ((row-i >= 0) && (column+i < board_size) && (this.gameBoard[row-i][column+i] == symbol)){
                    k++;
                } else {
                    break;
                }

            }

            for (int i = 1; i < board_size; i++) {

                // check bottom left diagonal
                if ((row+i < board_size) && (column-i >= 0) && (this.gameBoard[row+i][column-i] == symbol)){
                    k++;
                } else{
                    break;
                }
            }

            for (int i = 1; i < board_size; i++) {

                //check bottom right diagonals
                if ((row+i < board_size) && (column+i < board_size) && (this.gameBoard[row+i][column+i] == symbol)){
                    k++;
                } else{
                    break;
                }
            }

        } catch(ArrayIndexOutOfBoundsException e){      // if the index is out of bound
            return 0;
        }
        return k;
    }

    /**
     * Name: checkPlusPoints
     * checks for the number of points in the plus shape
     * @param symbol
     * @param row
     * @param column
     * @return
     */
    private int checkPlusPoints(char symbol, int row, int column){

        int k = 1;  //number of symbols in the cross points

        //try and catch to check if the index is out of bound
        try{

            // checking all sides for an existing X
            if ((this.gameBoard[row-1][column] != symbol) || (this.gameBoard[row+1][column] != symbol)){
                if((this.gameBoard[row][column-1] != symbol) || (this.gameBoard[row][column+1] != symbol)){
                    return 0;
                }
            }

            //check top row
            for (int i = 1; i < board_size; i++) {

                if ((row-i >= 0) && (this.gameBoard[row-i][column] == symbol)){
                    k++;
                } else{
                    break;
                }
            }

            //check bottom row
            for (int i = 1; i < board_size; i++) {

                if ((row+i < board_size) && (this.gameBoard[row+i][column] == symbol)){
                    k++;
                } else{
                    break;
                }
            }

            //check left column
            for (int i = 1; i < board_size; i++) {

                if ((column-i >= 0) && (this.gameBoard[row][column-i] == symbol)){
                    k++;
                } else{
                    break;
                }
            }

            //check right column
            for (int i = 1; i < board_size; i++) {

                //if the row and column is in bound and the symbol is the same, increment count
                if ((column+i < board_size) && (this.gameBoard[row][column+i] == symbol)){
                    k++;
                } else {
                    break;
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            return 0;
        }
        return k;
    }

    /**
     * Name: isDraw
     * Returns true if board has no empty positions left and no player has won the game
     * @return false if there are empty ' ' slots, true if not
     */
    public boolean isDraw() {

        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                if (gameBoard[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Name: evalBoard
     * 3, if the computer has won
     * 0, if the human player has won
     * 2, if the game is a draw
     * 1, if the game is still undecided
     * @return 3, 2, 0, or 1 depending on the outcome of the game
     */
    public int evalBoard() {
        if (wins('O')) {
            return 3;
        } else if (wins('X')) {
            return 0;
        } else if (!wins('O') && !wins('X') && isDraw()) {
            return 2;
        }
        return 1;
    }
}
