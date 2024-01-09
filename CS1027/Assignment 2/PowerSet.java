public class PowerSet<T> {

    Set<T>[] set;

    /**
     * constructor for PowerSet class
     * 
     * @param elements list containing the elements in the set
     */
    public PowerSet(T[] elements){

        String binary;
        String padding = "";
        int arrLength = (int)Math.pow(2, elements.length);
        
        //initialize the array length
        this.set = (Set<T>[])new Set<?>[arrLength];

        for (int i = 0; i < arrLength; i++){

            //find binary representation of i
            binary = Integer.toBinaryString(i);

            //reset padding value before creating them
            padding = "";

            //generate padding
            for (int j = 0; j < (elements.length - binary.length()); j++){

                padding += "0";

            }

            //add padding
            binary = padding + binary;

            //creating a set
            Set<T> newSet = new Set<>();

            //creating a combination as a set
            for (int j = 0; j < binary.length(); j++){

                if (binary.charAt(j) == '1'){

                    newSet.add(elements[j]);

                }

            }

            //append the set into the list of sets
            this.set[i] = newSet;

        }

    }

    /**
     * set.length accessor
     * 
     * @return the length of the set array (number of sets in the Power Set)
     */
    public int getLength(){

        return this.set.length;

    }

    /**
     * Return the Set stored at index i of the array
     * 
     * @param i the index num
     * @return set[i] the Set stored at index i of the array
     */
    public Set<T> getSet(int i){

        return this.set[i];

    }
    
}
