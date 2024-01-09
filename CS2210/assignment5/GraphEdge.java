/**
 * Author: Hoyeon Luke Jang
 * Date: December 7, 2023
 * GraphEdge.java - CS2010 (Assignment 5)
 * 
 * This is a class that represents an edge in a graph.
 */

public class GraphEdge {

    //instance variables
    private GraphNode firstEnd;
    private GraphNode secondEnd;
    private int type;
    private String label;

    //constructor
    public GraphEdge(GraphNode u, GraphNode v, int type, String label){
        this.firstEnd = u;
        this.secondEnd = v;
        this.type = type;
        this.label = label;
    }

    public GraphNode firstEndpoint(){
        return this.firstEnd;
    }
    
    public GraphNode secondEndpoint(){
        return this.secondEnd;
    }

    public int getType(){
        return this.type;
    }

    public void setType(int newType){
        this.type = newType;
    }

    public String getLabel(){
        return this.label;
    }

    public void setLabel(String newLabel){
        this.label = newLabel;
    }
    
}
