/**
 * Author: Hoyeon Luke Jang
 * Date: December 7, 2023
 * Graph.java - CS2010 (Assignment 5)
 * 
 * This class represents an undirected graph
 */

import java.util.*;


public class Graph implements GraphADT{
    
    //instance variables
    private GraphNode[] nodes;
    private GraphEdge[][] edges;
    

    //constructor
    public Graph(int n){
        this.nodes = new GraphNode[n];
        this.edges = new GraphEdge[n][n];

        //fill in the nodes array with nodes
        for(int i = 0; i < n; i++)
            this.nodes[i] = new GraphNode(i);
        
    }

    //insertEdge method
    public void insertEdge(GraphNode u, GraphNode v, int edgeType, String label) throws GraphException{

        GraphEdge newEdge = new GraphEdge(u, v, edgeType, label);

        //check if the nodes exist
        if (u.getName() >= this.nodes.length || v.getName() >= this.nodes.length)
            throw new GraphException("One of the nodes does not exist.");

        //insert new edge into adjacency matrix
        this.edges[u.getName()][v.getName()] = newEdge;
        this.edges[v.getName()][u.getName()] = newEdge;

    }

    public GraphNode getNode(int u) throws GraphException{

        if (u >= this.nodes.length || u < 0)
            throw new GraphException("Node does not exist.");
        
        return this.nodes[u];
    
    }

    public Iterator<GraphEdge> incidentEdges(GraphNode u) throws GraphException{

        if (u.getName() >= this.nodes.length || u.getName() < 0)
            throw new GraphException("Node does not exist.");

        //create an ArrayList to store the edges 
        ArrayList<GraphEdge> incidentEdges = new ArrayList<GraphEdge>();

        //iterate through the adjacency matrix and add the edges to the ArrayList
        for (int i = 0; i < this.edges[u.getName()].length; i++){

            if (this.edges[u.getName()][i] != null)
                incidentEdges.add(this.edges[u.getName()][i]);
            
        }

        //return an iterator of the ArrayList
        return incidentEdges.iterator();

    }

    public GraphEdge getEdge(GraphNode u, GraphNode v) throws GraphException{

        if (u.getName() >= this.nodes.length || v.getName() >= this.nodes.length || u.getName() < 0 || v.getName() < 0)
            throw new GraphException("One of the nodes does not exist.");

        if (this.edges[u.getName()][v.getName()] == null)
            throw new GraphException("There is no edge between the two nodes.");
        
        return this.edges[u.getName()][v.getName()];

    }

    public boolean areAdjacent(GraphNode u, GraphNode v) throws GraphException{

        if (u.getName() >= this.nodes.length || v.getName() >= this.nodes.length || u.getName() < 0 || v.getName() < 0)
            throw new GraphException("One of the nodes does not exist.");

        if (this.edges[u.getName()][v.getName()] == null) return false;
        
        return true;

    }
        


}
