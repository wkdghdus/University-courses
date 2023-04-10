import java.util.Comparator;
import java.util.Iterator;

public class NLNode<T> {

    private NLNode<T> parent;
    private ListNodes<NLNode<T>> children;
    private T data;

    /**
     * 
     * constructor for NLNode<T>
     * 
     */
    public NLNode(){

        this.parent = null;
        this.children = new ListNodes<NLNode<T>>();
        this.data = null;

    }

    /**
     * constructor for NLNode<T>
     * 
     * @param d data item
     * @param p parent node
     */
    public NLNode(T d, NLNode<T> p){

        this.parent = p;
        this.children = new ListNodes<NLNode<T>>();
        this.data = d;

    }

    /**
     * set parent
     * 
     * @param p new parent node
     */
    public void setParent(NLNode<T> p) {
        this.parent = p;
    }

    /** 
     * returns parent
     * 
     * @return parent of the node
     */
    public NLNode<T> getParent() {
        return this.parent;
    }

    /**
     * adds given new child to the list of children of this node.
     * Node newChild must have its parent set to this node
     * 
     * @param newChild
     */
    public void addChild(NLNode<T> newChild){

        if (newChild.getParent() != this){

            newChild.setParent(this);

        }

        //add child
        (this.children).add(newChild);

    }

    /**
     * children node iterator getter
     * 
     * @return iterator of children of this NLNode
     */
    public Iterator<NLNode<T>> getChildren(){

        return this.children.getList();

    }

    /**
     * Returns an iterator containing the children of this node sorted in 
     * the order specified by the comparator parameter
     * 
     * @param sorter comparator parameter
     * @return sorted list that is sorted according to the sorter parameter
     */
    public Iterator<NLNode<T>> getChildren(Comparator<NLNode<T>> sorter){

        return (this.children).sortedList(sorter);

    }

    /**
     * @return the data item of this node
     */
    public T getData(){

        return this.data;

    }

    /**
     * set the data item of this node
     * 
     * @param d new data item
     */
    public void setData(T d){

        this.data = d;
            
    }
    
}
