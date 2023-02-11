public class Vector extends Matrix {

    /**
     * constructor for vector object
     * 
     * @param c number of elements (column)
     */
    public Vector(int c){

        super(1, c);

    }
    
    /**
     * constructor for vector object with element
     * 
     * @param c number of elements (column)
     * @param linArr array of elements
     */
    public Vector(int c, double[] linArr){

        super(1, c, linArr);

    }

    /**
     * getter for elements in the vector
     * 
     * @param c location(index) of the element
     * @return element in the given loacation
     */
    public double getElement(int c){

        return super.getElement(0, c);

    }
}
