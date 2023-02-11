public class MarkovChain {
    
    private Vector stateVector;
    private Matrix transitionMatrix;

    /**
     * MarkovChain constructor
     * 
     * @param sVector state vector
     * @param tMatrix transition matrix
     */
    public MarkovChain(Vector sVector, Matrix tMatrix){

        this.stateVector = sVector;
        this.transitionMatrix = tMatrix;

    }

    /**
     * method to check if the instance variable is valid for markov chain calculation
     * 
     * @return validity of variables
     */
    public boolean isValid(){

        double transCols = this.transitionMatrix.getNumCols();
        double transRows = this.transitionMatrix.getNumRows();
        double stateCols = this.stateVector.getNumCols();
        double stateSum = 0;

        // checking if the transition matrix is a square, 
        // and if that number equals to the number of columns in the state vector
        if ((transCols != transRows) || (transCols != stateCols)){

            return false;

        }


        for (int cols = 0; cols < stateCols; cols++){

                stateSum += this.stateVector.getElement(cols);

        }

        //checking if the sum of all elements of state vector is 1.0
        //due to possible roundoff errors, check if the sum is between 0.99 and 1.01
        if ((0.99 > stateSum) || (1.01 < stateSum)){

            return false;

        }

        //sum of each rows of transition matrix
        double rowSum = 0;

        for (int row = 0; row < transRows; row++){

            for (int column = 0; column < transCols; column++){

                rowSum += this.transitionMatrix.getElement(row, column);

            }

            //check if the rowSum is equal to 1.00
            if ((0.99 > rowSum) || (1.01 < rowSum)){

                return false;
    
            }

            //reset rowSum value
            rowSum = 0;

        }

        //if all condition is satisfied
        return true;
    }

    /**
     * method to computes probability matrix
     * 
     * @param numSteps number of steps
     * @return probability matrix
     */
    public Matrix computeProbabilityMatrix(int numSteps){

        //check if the instance variables are valid for calculation
        if (!this.isValid()){

            return null;

        }

        //new Matrix object for transition matrix
        Matrix resultingMatrix = transitionMatrix;


        //multiplying transition matrix by itself for numStep-1 times
        for (int i = 0; i < numSteps-1; i++){

            //note that resultingMatrix's initial value is transition matrix
            resultingMatrix = resultingMatrix.multiply(transitionMatrix);

        }

        //return the value of state vector multiplied by resulting matrix 
        return stateVector.multiply(resultingMatrix);

    }

}
