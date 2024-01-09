/**
 * Author: Hoyeon Luke Jang
 * Date: December 7, 2023
 * Maze.java - CS2010 (Assignment 5)
 * 
 * This class represents the maze. As explained above, an object of the class Graph will be used to store the maze and to find a solution for it.
 */

import java.io.*;
import java.util.*;

public class Maze{

    //instance variables
    private Graph maze;
    private char[][] mazeStructure;
    private int coins;
    private int exit;
    private int start;

    public Maze(String inputFile) throws GraphException, MazeException{
        
        File file = new File(inputFile);

        //create a scanner to read the file
        try{

            BufferedReader reader = new BufferedReader(new FileReader(file));

            //read the first lines
            reader.readLine();                                 //first line of the file is not used in this class
            int width = Integer.parseInt(reader.readLine());   //second line of the file is the width of the maze
            int length = Integer.parseInt(reader.readLine());  //third line of the file is the length of the maze
            coins = Integer.parseInt(reader.readLine());   //fourth line of the file is the number of coins in the maze

            
            //create a graph with the given width and length
            maze = new Graph(width * length);

            //create a 2D array to store the maze structure
            mazeStructure = new char[length][width];

            //read the rest of the file and appened to the 2d array
            for (int i = 0; i < length; i++){

                String line = reader.readLine();

                //appened each charater to the 2d array
                for (int j = 0; j < width; j++){

                    mazeStructure[i][j] = line.charAt(j);

                }

            }

            //insert horizontal corridors (edges) using the two d array
            for (int i = 0; i < length; i++){

                for (int j = 0; j < width; j++){

                    //check if the current character is a corridor
                    if (mazeStructure[i][j] == 'c'){

                        //insert an edge between the two nodes
                        try{

                            maze.insertEdge(maze.getNode(i * width + j - 1), maze.getNode(i * width + j + 1), 0, "corridor");

                        }
                        catch(GraphException e){
                            //do nothing, this means that the node does not exist at the each end of horizontal edges
                        }

                    }

                    if (Character.isDigit(mazeStructure[i][j])){

                        //insert an edge between the two nodes
                        try{

                            maze.insertEdge(maze.getNode(i * width + j - 1), maze.getNode(i * width + j + 1), (int)mazeStructure[i][j], "corridor");

                        }
                        catch(GraphException e){
                            //do nothing, this means that the node does not exist at the each end of horizontal edges
                        }

                    }

                    if (mazeStructure[i][j] == 's')
                        start = i * width + j;
                    
                    if (mazeStructure[i][j] == 'x')
                        exit = i * width + j;

                }

            }

            for(int i = 0; i < width; i++){

                for (int j = 0; j < length; j++){

                    //check if the current character is a corridor
                    if (mazeStructure[j][i] == 'c'){

                        //insert an edge between the two nodes
                        try{

                            maze.insertEdge(maze.getNode((j - 1) * width + i), maze.getNode((j + 1) * width + i), 0, "corridor");

                        }
                        catch(GraphException e){
                            //do nothing, this means that the node does not exist at the each end of horizontal edges
                        }

                    }

                    if (Character.isDigit(mazeStructure[j][i])){

                        //insert an edge between the two nodes
                        try{

                            maze.insertEdge(maze.getNode((j - 1) * width + i), maze.getNode((j + 1) * width + i), (int)mazeStructure[j][i], "corridor");

                        }
                        catch(GraphException e){
                            //do nothing, this means that the node does not exist at the each end of horizontal edges
                        }

                    }

                }

            }

        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
        catch(IOException e){
            System.out.println("Error reading file.");
        }

    }

    public Graph getGraph() throws GraphException{
        
        if (this.maze == null || this.maze.getNode(0) == null)
            throw new GraphException("Maze does not exist.");

        return this.maze;
    
    }

    public Iterator solve(){

        //create a stack to store the path
        Stack<GraphNode> path = new Stack<GraphNode>();

        //designate start and exit nodes
        try{

            GraphNode startNode = maze.getNode(start);
            GraphNode exitNode = maze.getNode(exit);
            GraphNode currentNode = startNode;

            while (currentNode != exitNode){

                //mark the current node
                currentNode.mark(true);
                path.add(currentNode);

                //get the incident edges of the current node
                Iterator<GraphEdge> incidentEdges = maze.incidentEdges(currentNode);

                //iterate through the incident edges
                while (incidentEdges.hasNext()){

                    //get the next edge
                    GraphEdge edge = incidentEdges.next();

                    //get the other end of the edge
                    GraphNode otherEnd = edge.secondEndpoint();

                    //check if the other end is marked
                    if (!otherEnd.isMarked() && coins >= edge.getType()){

                        coins -= edge.getType();
                        currentNode = otherEnd;
                        break;


                    }

                    //if there is no more next node. 
                    if (!incidentEdges.hasNext()){

                        coins += edge.getType();

                        //pop the current node
                        path.pop();

                        //get the previous node
                        currentNode = path.peek();

                    }

                }

            }

            return path.iterator();


        }
        catch(GraphException e){
            System.out.println("error!");
        }

        return path.iterator();


    }

    
}
