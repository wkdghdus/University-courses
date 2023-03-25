public class FindShortestPath {


    /**
     * check if there are any dragon cahmber in the surrounding chamber
     * 
     * @param currentChamber
     * @return boolean value of existence of dragon chamber
     */
    private static boolean besideDragon(Hexagon currentChamber){

        //go through the surrounding hexagon 
        for (int i = 0; i < 6; i++) {

            if (currentChamber.getNeighbour(i) != null){

                if (currentChamber.getNeighbour(i).isDragon()) return true;

            }

        }

        return false;

    }


    public static void main (String[] args){

        try{
            
            //check if the user inputted the file name
            if (args.length < 1) throw new Exception("No input file specified");
            String dungeonFileName = args[0];

            //declare neccessary variables
            Dungeon dungeon = new Dungeon(dungeonFileName);
            DLPriorityQueue<Hexagon> chamberPriority = new DLPriorityQueue<>();

            //start chamber 
            Hexagon startChamber = dungeon.getStart();
            
            //add starting chamber to the priority queue, and mark as enqueued
            chamberPriority.add(startChamber, 0.0);
            startChamber.markEnqueued();

            Hexagon current;        //current chamber 

            //loop until we find the exit
            while (!chamberPriority.isEmpty()){

                //remove the chamber with the smallest priority
                current = chamberPriority.removeMin();
                // mark the chamber dequeued
                current.markDequeued();      

                // if the current chamber is an exit, then break the loop
                if (current.isExit()){

                    break;

                }

                //if the chamber is noit beside dragon
                if (!besideDragon(current)){

                    for (int i = 0; i < 6; i++){

                        Hexagon neighbour = current.getNeighbour(i);

                        if (neighbour != null && !neighbour.isWall() && !neighbour.isMarkedDequeued()){

                            //let d be 1 + distance from current to the initial chamber
                            int d = 1 + current.getDistanceToStart();

                            //if distance of neighbour to initial chamber is larger than d
                            if (neighbour.getDistanceToStart() > d){

                                //set distance of the neighbour to the initial chamber to d
                                neighbour.setDistanceToStart(d);

                                //set current as the predecessor of neighbour
                                neighbour.setPredecessor(current);

                            }

                            //calculate priority, distance to initial chamber + distance to exit
                            double priority = neighbour.getDistanceToExit(dungeon) + neighbour.getDistanceToStart();
                            
                            //if the neighbour chamber is already enqueued
                            if (neighbour.isMarkedEnqueued()){

                                //update priority of the chamber if it is enqueued
                                chamberPriority.updatePriority(neighbour, priority);

                            }
                            else{

                                //if the neighbour is not marked enqueued then enqueue it to the priority queue
                                chamberPriority.add(neighbour, priority);

                                //mark the chamber as enqueued.
                                neighbour.markEnqueued();

                            }

                        }

                    }
                    
                }

            }
            
        }
        catch(Exception e){System.out.println(e);}

    }
    
}
