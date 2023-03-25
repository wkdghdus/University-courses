public class DLPriorityQueue<T> implements PriorityQueueADT<T> {
    
    private DLinkedNode<T> front;
    private DLinkedNode<T> rear;
    private int count;

    /**
     * 
     * DLPriorityQueue constructor, creates empty queue
     * 
     */
    public DLPriorityQueue(){

        this.front = null;
        this.rear = null;
        this.count = 0;

    }
    
    /**
     * method to add an element
     * 
     * @param dataItem dataItem of the node
     * @param priority priority of the nope
     */
    public void add (T dataItem, double priority){

        DLinkedNode<T> curr = this.front;
        DLinkedNode<T> newNode = new DLinkedNode<>(dataItem, priority);

        //if the priority queue is empty
        if (isEmpty()){

            this.front = newNode;
            this.rear = newNode;

        }
        //if the priority (number) is higher than rear (less important)
        else if (priority > this.rear.getPriority()){

            this.rear.setNext(newNode);
            newNode.setPrev(this.rear);
            this.rear = newNode;

        }
        //if the priority (number) is lower than front (more important)
        else if (priority <= this.front.getPriority()){

            this.front.setPrev(newNode);
            newNode.setNext(this.front);
            this.front = newNode;

        }
        //if the priority is in between the items in the queue.
        else{

            //find the location of the item based on the priority.
            while (curr.getPriority() < priority){

                curr = curr.getNext();

            }

            //note that curr is the next node of the newNode

            //update the newNode with previous and next nodes
            newNode.setPrev(curr.getPrev());    //update newNode's previous node
            newNode.setNext(curr);              //update newNode's next node
            curr.getPrev().setNext(newNode);    //update the previous node's next node as a newNode
            curr.setPrev(newNode);              //update the current node's previous node as a newNode

        }

        //increment count
        this.count++;

    }

    /**
     * removes front and return its data item
     * 
     * @return the data of the node with smallest priority value
     */
    public T removeMin() throws EmptyPriorityQueueException {

        if (isEmpty()){

            throw new EmptyPriorityQueueException("the queue is empty");

        }

        DLinkedNode<T> tempNode = this.front;    //current front saved in temp
        this.count--;                            //decrement count

        //if there is only one node in the queue
        if (this.front == this.rear){

            this.front = null;
            this.rear = null;

        }
        else{

            this.front = this.front.getNext();        //change to new front
            this.front.setPrev(null);    //set the prev value as null
        
        }

        return tempNode.getDataItem();      

    }

    /**
     * update the priority of the node with the given data item
     * 
     * @param data the given data item
     * @param newPriority new priority
     */
    public void updatePriority(T data, double newPriority) throws InvalidElementException {

        DLinkedNode<T> curr = this.front;
        boolean itemExist = false;

        while (curr != null){

            if (curr.getDataItem().equals(data)){

                //remove the node from the queue
                if (curr == this.front){        //if the item is at the front (including the case when there is only one node)

                    this.removeMin();

                }
                else if (curr == this.rear){    //if the item is at the rear

                    //decrement count
                    this.count--;

                    this.rear = this.rear.getPrev();
                    this.rear.setNext(null);

                }
                else{                           //if the item is in between the items.

                    //decrement count
                    this.count--;

                    curr.getPrev().setNext(curr.getNext());
                    curr.getNext().setPrev(curr.getPrev());

                }
                
                //indicate that item exists
                itemExist = true;

                //add the item to the queue
                this.add(data, newPriority);

                //break the loop
                break;

            }

            curr = curr.getNext();

        }

        //if item did not exist, throw exception
        if (!itemExist){

            throw new InvalidElementException("Item does not exist");

        }

    }

    /**
     * check if the queue is empty
     * 
     * @return  true if the priority queue is empty, false otherwise
     */
    public boolean isEmpty() {

        return this.count == 0;

    }

    /**
     * returns the size of the queue
     * 
     * @return size of the queue
     */
    public int size() {

        return this.count;

    }

    /**
     * toString method
     * 
     * @return String value of the data items in the node
     */
    public String toString(){

        String rtnString = "";
        DLinkedNode<T> curr = front;

        while (curr != null){

            rtnString += curr.getDataItem().toString();
            curr = curr.getNext();

        }

        return rtnString;

    }

    /**
     * returns the rear node
     * 
     * @return rear node
     */
    public DLinkedNode<T> getRear(){

        return this.rear;

    }
    
}
