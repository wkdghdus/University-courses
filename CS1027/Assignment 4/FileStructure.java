import java.util.Iterator;
import java.util.ArrayList;

public class FileStructure {
    
    private NLNode<FileObject> root;

    /**
     * will iterate through the parameter's childs and create a tree.
     * 
     * @param r root node
     */
    private void fileSystemBuilder(NLNode<FileObject> r){

        if (r.getData().isDirectory()){

            FileObject f = r.getData();

            //create iterator containing all the objects of type FileObjects
            Iterator dirIterator = f.directoryFiles();

            //iterating through the file Iterator
            while (dirIterator.hasNext()){

                //create a NLNode of the child nodes/files
                NLNode<FileObject> newNode = new NLNode(dirIterator.next(), r);
                
                //add newNode as a child of r
                r.addChild(newNode);
                
                //in case the child is a folder, call method recursively.
                fileSystemBuilder(newNode);

            }

        }
    }

    /**
     * FileStructure constructor
     * 
     * @param fileObjectName name of the file object, could be a file or a folder
     * @throws FileObjectException if the there's trouble creating file object of given name.
     */
    public FileStructure (String fileObjectName) throws FileObjectException{

        //create new file object representing the file/folder
        FileObject fileDir = new FileObject(fileObjectName);

        //initialize root node, it has no parent node
        this.root = new NLNode(fileDir, null);

        //build file system
        fileSystemBuilder(this.root);

    }


    /**
     * root getter
     * 
     * @return root of this file structure
     */
    public NLNode<FileObject> getRoot(){

        return root;

    }

    /**
     * 
     * returns String Iterator with the names of all the files with the specified type
     * 
     * @param type type of the file 
     * @return String Iterator with the collection of file names with given type
     */
    public Iterator<String> filesOfType(String type){

        //create ArrayList of the file with given extention
        ArrayList<String> allFilesAL = findType(this.root, type);

        //return Iterator version of given ArrayList;
        return allFilesAL.iterator();

    }

    /**
     * 
     * returns the String ArrayList of names of all the files with the specified type
     * 
     * @param r root node with the root file
     * @param type type of the file
     * @return String Arraylist with the collection of file names with given type
     */
    private ArrayList<String> findType(NLNode<FileObject> r, String type){

        //create returning arraylist
        ArrayList<String> rtn = new ArrayList<String>();

        if (r.getData().isFile()){

            FileObject f = r.getData();

            //finding the startIndex of the type in the long name of the file
            int typeStartInd = f.getLongName().length() - type.length();

            System.out.println(f.getLongName().substring(typeStartInd).equals(type));

            //if the file type is the same with given type, add to the ArrayList
            if (f.getLongName().substring(typeStartInd).equals(type)){

                rtn.add(f.getLongName());

            }

        }
        //if the data is a directory
        else{

            //create iterator of subfiles/subDirectories
            Iterator<NLNode<FileObject>> dirIterator = r.getChildren();

            //iterate through the iterator
            while (dirIterator.hasNext()){

                //input child node then comebine the arrayList that is returned
                rtn.addAll(findType(dirIterator.next(), type));

            }

        }

        return rtn;

    }

    /**
     * method that finds the file of given name
     * 
     * @param name name of the file
     * @return the absolute path of the file with given name
     */
    public String findFile(String name){

        ArrayList<String> nameAL = findName(this.root, name);
        
        if (nameAL.isEmpty()) return "";
        
        else return nameAL.get(0);
            

    }

    /**
     * 
     * returns the String ArrayList of names of all the files with the specified type
     * 
     * @param r root node with the root file
     * @param name name of the file
     * @return String Arraylist with the collection of file names with given name
     */
    private ArrayList<String> findName(NLNode<FileObject> r, String name){

        //create returning arraylist
        ArrayList<String> rtn = new ArrayList<String>();

        if (r.getData().isFile()){

            FileObject f = r.getData();

            //if the file name is the same with given name, add to the ArrayList
            if (f.getName().equals(name)){

                rtn.add(f.getLongName());

            }

        }
        //if the data is a directory
        else{

            //create iterator of subfiles/subDirectories
            Iterator<NLNode<FileObject>> dirIterator = r.getChildren();

            //iterate through the iterator
            while (dirIterator.hasNext()){

                //input child node then comebine the arrayList that is returned
                rtn.addAll(findType(dirIterator.next(), name));

            }

        }

        return rtn;

    }

}

