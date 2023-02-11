public class Matrix {

    private int numRows;
    private int numCols;
    private double[][] data;

    /**
     * Matrix constructor
     * 
     * @param r number of rows
     * @param c number of columns
     */
    public Matrix(int r, int c){

        this.numRows = r;
        this.numCols = c;
        this.data = new double[r][c];

    }

    /**
     * Matrix constructor
     * 
     * @param r number of rows
     * @param c number of columns
     * @param linArr elements for the matrix in an array
     */
    public Matrix(int r,int c, double[] linArr){
        
        this.numRows = r;
        this.numCols = c;
        this.data = new double[r][c];

        //iterating through the matrix (two dimentional array)
        for(int row = 0; row < r; row++){

            for (int column = 0; column < c; column++){

                //assigning corresponding data to each index from the given array (linArr)
                this.data[row][column] = linArr[(row*c) + column];

            }

        }


    }

    /**
     * getter for number of rows
     * 
     * @return number of rows
     */
    public int getNumRows(){
   
        return this.numRows;
   
    }

    /**
     * getter for number of columns
     * 
     * @return number of columns
     */
    public int getNumCols(){
  
        return this.numCols;
  
    }

    /**
     * getter for matrix data
     * 
     * @return matrix data in two dimentional array
     */
    public double[][] getData(){
  
        return this.data;
  
    }

    /**
     * getter for an element in matrix
     * 
     * @param r element's row
     * @param c element's column
     * @return element at the given row and column
     */
    public double getElement(int r, int c){

        return this.data[r][c];

    }

    /**
     * setter for an element in matrix
     * 
     * @param r new element's row
     * @param c new element's column
     * @param value the new element value
     */
    public void setElement(int r, int c, double value){
  
        this.data[r][c] = value;
  
    }

    /**
     * Transposes the matrix
     */
    public void transpose(){

        //new two dimentional array for the transposed data
        double[][] transposedData = new double[this.numCols][this.numRows];

        //iterating through the array
        for (int row = 0; row < this.numRows; row++){

            for (int column = 0; column < this.numCols; column++){

                //Assigning each elements to the transposed location
                transposedData[column][row] = this.data[row][column]; 

            }

        }

        //initializing the Matrix variable with new(transposed) values
        int tempCols = this.numCols; 
        this.numCols = this.numRows;
        this.numRows = tempCols;
        this.data = transposedData;

    }

    /**
     * perform scalar multiplication
     * 
     * @param scarlar
     * @return multiplied matrix
     */
    public Matrix multiply(double scarlar){

        //New matrix object for the multiplication
        Matrix newMatrix = new Matrix(this.numRows, this.numCols);

        //iterating through the Matrix object
        for (int row = 0; row < this.numRows; row++){

            for (int column = 0; column < this.numCols; column++){

                //multiplying each element to scalar value, then setting it to corresponding location.
                newMatrix.setElement(row, column, this.data[row][column] * scarlar); 

            }

        }

        return newMatrix;

    }

    /**
     * perform matrix multiplication with two matrices
     * 
     * @param other
     * @return multiplied matrix
     */
    public Matrix multiply(Matrix other){

        //check if the matrix multiplication is possible
        if (this.numCols != other.getNumRows()){

            //if not return null
            return null;

        }

        //if possible, make a new matrix for the multiplication.
        Matrix newMatrix = new Matrix (this.numRows, other.getNumCols());
        //initialize result
        double result = 0;

        //looping through the rows of newMatrix
        for (int row = 0; row < newMatrix.getNumRows(); row++){

            //looping through the columns of "newMatrix"
            for (int column = 0; column < newMatrix.getNumCols(); column++){
                
                //for loop to go through columns and rows for addition
                for (int addCount = 0; addCount < newMatrix.getNumCols(); addCount++){
                
                    //calculating newMatrix[i][j]
                    result += this.data[row][addCount] * other.getData()[addCount][column];

                }

                //update newMatrix and reset the result
                newMatrix.setElement(row, column, result);
                result = 0;

            }

        }

        return newMatrix;

    }

    /**
     * toString method for Matrix objects
     * 
     * @return String value of Matrix class
     */
    public String toString(){

        //returning variable
        String rtn = "";

        //check if matrix is empty
        if ((this.getNumCols() == 0) && (this.getNumRows() == 0)){

            return "Empty matrix";

        }

        //iterating the matrix
        for (int row = 0; row < this.numRows; row++){

            for (int column = 0; column < this.numCols; column++){

                //round to 3 decimals
                double roundedElement = this.getElement(row, column) * 1000;
                roundedElement = Math.round(roundedElement);
                roundedElement /= 1000; 
                
                //add fomatted output to the return
                rtn += String.format("%8.3f", roundedElement);

            }

            //new line
            rtn += "\n";

       }

        // return, but strip the last \n
        return rtn.stripTrailing();

    }

}