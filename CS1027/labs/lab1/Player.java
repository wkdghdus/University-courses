/**
 * This class represents a player object
 * @author Hoyeon Luke Jang
 */


package labs.lab1;

public class Player{

    private String name;
    private String position;
    private int jerseyNum;

    public Player(String theName, String thePosition, int theJersey){

        name = theName;
        position = thePosition;
        jerseyNum = theJersey;

    }

    /**
     * Method for accessing name of the player
     * @return name of the player
     */
    public String getName(){

        return this.name;

    }

    /**
     * method for accessing position of the player
     * 
     * @return position of the player
     */
    public String getPosition(){

        return this.position;

    }

    /**
     * method for accessing jersey number of the player
     * 
     * @return jersey number of the player
     */
    public int getJerseyNum(){

        return this.jerseyNum;

    }

    /**
     * A modifying method for player's name
     * @param newName the new name of the player
     */
    public void setName(String newName){

        this.name = newName;

    }

    /**
     * Modifying method for players position
     * @param newPosition the new position of the player
     */
    public void setPosition(String newPosition){

        this.position = newPosition;

    }

    /**
     * Modifying method for player's jersey number
     * @param newJersey the new jersey number
     */
    public void setJerseyNum(int newJersey){

        this.jerseyNum = newJersey;

    }


}