public class DLinkedNode<T> {

    private T dataItem;             // a reference to the data item stored in this node
    private double priority;        // priority of the data item
    private DLinkedNode<T> next;    // reference to teh next node in the linked list
    private DLinkedNode<T> prev;    //reference to the previous node in the linked list

    /**
     * constructor for DLinkedNode
     * 
     * @param data data of the node
     * @param prio priority of the node
     */
    public DLinkedNode(T data, double prio){

        this.dataItem = data;
        this.priority = prio;

    }

    /**
     * constructor for DLinkedNode
     */
    public DLinkedNode(){

        this.dataItem = null;
        this.priority = 0;

    }

    /**
     * data item getter
     * 
     * @return data stored in the node
     */
    public T getDataItem() {
        return this.dataItem;
    }

    /**
     * data item setter
     * 
     * @param newDataItem new sataitem
     */
    public void setDataItem(T newDataItem) {
        this.dataItem = newDataItem;
    }

    /**
     * priority getter
     * 
     * @return priority of the item
     */
    public double getPriority() {
        return this.priority;
    }

    /**
     * priority setter
     * 
     * @param newPriority new priority
     */
    public void setPriority(double newPriority) {
        this.priority = newPriority;
    }

    /**
     * next node getter
     * 
     * @return the next node
     */
    public DLinkedNode<T> getNext() {
        return this.next;
    }

    /**
     * next node setter
     * 
     * @param newNext new next node
     */
    public void setNext(DLinkedNode<T> newNext) {
        this.next = newNext;
    }

    /**
     * previous node getter
     * 
     * @return previous node
     */
    public DLinkedNode<T> getPrev() {
        return this.prev;
    }

    /**
     * previous node setter
     * 
     * @param newPrev new previous node
     */
    public void setPrev(DLinkedNode<T> newPrev) {
        this.prev = newPrev;
    }
}
