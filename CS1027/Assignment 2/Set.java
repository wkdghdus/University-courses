public class Set<T>{
    
    LinearNode<T> setStart; //front of the linked list


    /**
     * Contructor of Set class
     * 
     */
    public Set(){

        this.setStart = null;

    }

    /**
     * Creates new node with given element and add to the start of the linked list
     * 
     * @param element
     */
    public void add(T element){

        LinearNode<T> newNode = new LinearNode<T>(element);

        //setting the next node as the first node of the list
        newNode.setNext(setStart);

        //assign the new node as a first of the list
        this.setStart = newNode;

    }

    /**
     * return the length of the length of the list
     * 
     * 
     * @return length of the linked list
     */
    public int getLength(){

        LinearNode<T> curr = this.setStart;
        int counter = 0;

        //increment counter if the next node exists
        while (curr != null){

            counter++;
            curr = curr.getNext();

        }

        return counter;

    }

    /**
     * return the element in the ith node of the linked list
     * 
     * @param i location of the node
     * @return element in the ith node
     */
    public T getElement(int i){

        LinearNode<T> curr = this.setStart;

        //loop ith time, going up to the next node every time it loops
        for (int j = 0; j < i; j++){

            curr = curr.getNext();

        }

        return curr.getElement();

    }

    /**
     * check if given element exists within the list
     * 
     * @param element 
     * @return true if element exists, else false
     */
    public boolean contains(T element){

        LinearNode<T> curr = this.setStart;

        //iterate through linked list
        while (curr != null){

            //if element exists
            if (curr.getElement() == element){

                return true;

            }

            //update current value to the next node in the list
            curr = curr.getNext();

        }

        return false;

    }

    /**
     * toString method of Set class
     */
    public String toString(){

        LinearNode<T> curr = this.setStart;
        String rtn = "";

        //increment counter if the next node exists
        while (curr != null){

            //add element to the return string
            rtn += curr.getElement() + " ";
            curr = curr.getNext();

        }

        return rtn;

    }

}
