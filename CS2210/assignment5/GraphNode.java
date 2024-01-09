/**
 * Author: Hoyeon Luke Jang
 * Date: December 7, 2023
 * GraphNode.java - CS2010 (Assignment 5)
 * 
 * This is a class that represents a node in a graph.
 */

public class GraphNode{

    //Instance Variables
    private int name;
    private boolean mark;

    //Constructor
    public GraphNode(int name){
        this.name = name;
        this.mark = false;
    }

    public void mark(boolean mark){
        this.mark = mark;
    }

    public boolean isMarked(){
        return this.mark;
    }

    public int getName(){
        return this.name;
    }




}