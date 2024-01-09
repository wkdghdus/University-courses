/**
 * 
 * Author: Hoyeon Luke Jang
 * Date: Nov 18, 2023
 * CS2210 - assignment 2
 * 
 * Interface.java
 * main class of the program. implements user interface.
 * The input to the program will be a file containing the information that is to be stored in the ordered
 * dictionary. Therefore, to run the program you will type this command:
 * java Interface inputFile
 * 
 */
import java.io.*;

public class Interface {


    //builds a record from a lines of input
    public static Record recordBuilder(String line, String label){

        int type;
        String data;

        //sound file
        if (line.startsWith("-")) {

            type = 3; 
            data = line.substring(1);   //remove "-"

        } 
        //music file
        else if (line.startsWith("+")) {

            type = 4; 
            data = line.substring(1); 

        } 
        //voice file
        else if (line.startsWith("*")) {

            type = 5; 
            data = line.substring(1); 

        } 
        //translation file
        else if (line.startsWith("/")) {

            type = 2; 
            data = line.substring(1); 

        } 
        //else check the last part of the string for file extension
        else {
            
            //extract the extension
            String extension = line.substring(line.lastIndexOf(".") + 1);

            //assign type and data based on the extension
            switch (extension) {

                case "gif":
                    type = 7;
                    data = line;
                    break;
                
                case "jpg":
                    type = 6;
                    data = line;
                    break;
                
                case "html":
                    type = 8;
                    data = line;
                    break;
                
                default:
                    type = 1; // Default type
                    data = line;
                    break;
                
            }

        }

        //create a new record
        return new Record(new Key(label, type), data);

    }

    public static void main(String[] args){


        //create a new dictionary
        BSTDictionary dictionary = new BSTDictionary();

        //check if the number of arguments is correct
        if (args.length != 1){
            System.out.println("Invalid number of arguments.");
            System.exit(0);
        }

        //check if the file exists
        String input = args[0];

        File file = new File(input);

        if (!file.exists()){
            System.out.println("File does not exist.");
            System.exit(0);
        }

        //read the file
        try{

            BufferedReader reader = new BufferedReader(new FileReader(input));

            while (reader.ready()){

                String label = reader.readLine();
                Record record = recordBuilder(reader.readLine(), label);
                
                //insert the record into the dictionary
                dictionary.put(record);

            }

            reader.close();

        }
        catch (IOException e){
            System.out.println("Error reading file.");
            System.exit(0);
        }
        catch (DictionaryException e){
            System.out.println("Error inserting record.");
            System.exit(0);
        }

        //read command from user input. the code is provided from the assignment
        StringReader keyboard = new StringReader();
        SoundPlayer soundPlayer = new SoundPlayer();      
        ShowHTML showHtml = new ShowHTML();             
        PictureViewer photoViewer = new PictureViewer(); 

        //loop until the user enters "exit"
        while(true){

            String line = keyboard.read("Enter next command: ");

            //split the line into tokens
            String[] tokens = line.split(" ");
            tokens[0] = tokens[0].toLowerCase();


            //check validity of the command
            if (tokens.length > 3 && !tokens[0].equals("add")){
                System.out.println("Invalid command.");
            }
            else if (tokens.length > 2 && !tokens[0].equals("delete") && !tokens[0].equals("add")){
                System.out.println("Invalid command.");
            } 
            else if (tokens.length == 1 && !tokens[0].equals("first") && !tokens[0].equals("last")){
                System.out.println("Invalid command.");
            }

            ////run commands 
            //define
            else if (tokens[0].equals("define")){

                Record record = dictionary.get(new Key(tokens[1], 1));

                if (record != null) 
                    // Print the data attribute of the record
                    System.out.println(record.getDataItem());
                else 
                    System.out.println("The word " + tokens[1] + " is not in the dictionary.");

            }
            //translate
            else if (tokens[0].equals("translate")){

                Record record = dictionary.get(new Key(tokens[1], 2));

                if (record != null) 
                    // Print the data attribute of the record
                    System.out.println(record.getDataItem());
                else 
                    System.out.println("There is no definition for the word " + tokens[1]);


            }
            //translate
            else if (tokens[0].equals("sound")){

                Record record = dictionary.get(new Key(tokens[1], 3));

                try{

                    if (record != null) 
                        // Play the sound file
                        soundPlayer.play(record.getDataItem());
                    else 
                        System.out.println("There is no sound file for " + tokens[1]);

                }
                catch (MultimediaException e){
                    System.out.println("Error playing sound file.");
                }
                
            }
            //play
            else if (tokens[0].equals("play")){

                Record record = dictionary.get(new Key(tokens[1], 4));

                try{

                    if (record != null) 
                        // Play the music file
                        soundPlayer.play(record.getDataItem());
                    else 
                        System.out.println("There is no music file for " + tokens[1]);

                }
                catch (MultimediaException e){
                    System.out.println("Error playing music file.");
                }
                
            }
            //say
            else if (tokens[0].equals("say")){

                Record record = dictionary.get(new Key(tokens[1], 5));

                try{

                    if (record != null) 
                        // Play the voice file
                        soundPlayer.play(record.getDataItem());
                    else 
                        System.out.println("There is no voice file for " + tokens[1]);

                }
                catch (MultimediaException e){
                    System.out.println("Error playing voice file.");
                }
                
            }
            //show
            else if (tokens[0].equals("show")){

                Record record = dictionary.get(new Key(tokens[1], 6));

                try{

                    if (record != null) 
                        // Show the picture file
                        photoViewer.show(record.getDataItem());
                    else 
                        System.out.println("There is no image file for " + tokens[1]);

                }
                catch (MultimediaException e){
                    System.out.println("Error showing image file.");
                }
                
            }
            //animate
            else if (tokens[0].equals("animate")){

                Record record = dictionary.get(new Key(tokens[1], 7));

                try{

                    if (record != null) 
                        // Show the animation file
                        photoViewer.show(record.getDataItem());
                    else 
                        System.out.println("There is no animated image file for " + tokens[1]);

                }
                catch (MultimediaException e){
                    System.out.println("Error showing animation file.");
                }
                
            }
            //browse
            else if (tokens[0].equals("browse")){

                Record record = dictionary.get(new Key(tokens[1], 8));

                ////note that assignment says to catch MultimediaException in showHtml.java, but is never actually thrown in the given files
                // try{

                    if (record != null) 
                        // Show the HTML file
                        showHtml.show(record.getDataItem());
                    else 
                        System.out.println("There is no HTML file for " + tokens[1]);

                // }
                // catch (MultimediaException e){  
                //     System.out.println("Error showing HTML file.");
                // }
                
            }
            //delete
            else if (tokens[0].equals("delete")){

                try{

                    dictionary.remove(new Key(tokens[1], Integer.parseInt(tokens[2])));

                }
                catch (DictionaryException e){
                    System.out.println("No record in the ordered dictionary has key (" + tokens[1] + "," + tokens[2] + ")");
                }
                catch (Exception e){
                    System.out.println("Invalid command.");
                }

            }
            //add
            else if (tokens[0].equals("add")){

                String data = "";

                //append data into one string
                for (int i = 3; i < tokens.length; i++){
                    data += tokens[i] + " ";
                }

                Record record = new Record(new Key(tokens[1], Integer.parseInt(tokens[2])), data);

                try{

                    dictionary.put(record);

                }
                catch (DictionaryException e){
                    System.out.println("A record with the given key (" + tokens[1] + "," + tokens[2] + ") already exists in the ordered dictionary.");
                }
                catch (Exception e){
                    System.out.println("Invalid command.");
                }

            }
            //list
            else if (tokens[0].equals("list")){

                //get the smallest record
                Record record = dictionary.smallest();
                int counter = 0;

                //loop until the record is null
                while (record != null){

                    if (record.getKey().getLabel().startsWith(tokens[1])){

                        //print the record
                        System.out.println(record.getKey().getLabel() + ", ");
                        counter++;

                    }
                        
                    //get the successor
                    record = dictionary.successor(record.getKey());

                }

                if (counter == 0)
                    System.out.println("No label attributes in the ordered dictionary start with prefix  " + tokens[1]);

            }
            //first
            else if (tokens[0].equals("first")){

                Record record = dictionary.smallest();

                if (record != null) 
                    // Print the data attribute of the record
                    System.out.println(record.getKey().getLabel()+ ", " + record.getKey().getType() + ", " + record.getDataItem());
                else 
                    System.out.println("The ordered dictionary is empty.");

            }
            //last
            else if (tokens[0].equals("last")){

                Record record = dictionary.largest();

                if (record != null) 
                    // Print the data attribute of the record
                    System.out.println(record.getKey().getLabel()+ ", " + record.getKey().getType() + ", " + record.getDataItem());
                else 
                    System.out.println("The ordered dictionary is empty.");

            }
            //exit
            else if (tokens[0].equals("exit")){

                System.exit(0);

            }
            //invalid command
            else{

                System.out.println("Invalid command.");

            }

        }
        


        
    }
    
}
