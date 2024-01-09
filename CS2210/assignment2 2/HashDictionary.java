/**
 * This will be the class HashDictionary
 *
 * Class: CS2210
 * Date: Oct 13 2023
 * @author James Wong
 */
import java.util.LinkedList;

public class HashDictionary {

    /** The number of Data objects stored in the dictionary */
    private int numRecords;

    /** The size of the dictionary */
    private final int size;

    /** A linked list to hold data */
    private final LinkedList<Data>[] table;

    public interface DictionaryADT {
        public int put(Data record) throws DictionaryException;
        public void remove(String config) throws DictionaryException;
        public int get(String config);
        public int numRecords();
    }

    /**
     * Name: HashDictionary
     * this returns an empty dictionary of the specified size.
     * @param size size of the empty dictionary
     */
    public HashDictionary(int size) {
        this.size = size;
        table = new LinkedList[size];

        for (int i=0; i < table.length; i++) {
            table[i] = new LinkedList<Data>();
        }
    }

    /** Name: put
     * Adds record to the dictionary.
     * This method must throw a DictionaryException if record.getConfiguration() is already in the dictionary
     * @param record item being added to the dictionary
     * @return 1 or 0
     * @throws DictionaryException
     */
    public int put(Data record) throws DictionaryException {

        int value = polyHash(record.getConfiguration());

        if (table[value] != null) {
            for (int i = 0; i < table[value].size(); i++) {

                if (table[value].get(i).getConfiguration().equals(record.getConfiguration())) {
                    throw new DictionaryException();
                } else {
                    table[value].add(record);
                    numRecords++;
                    return 1;       //  method put must return the value 1 if adding record
                }
            }
        }
        table[value].add(record);
        numRecords++;
        return 0;       // it will return 0 if T[h(record.getConfiguration())] was empty.
    }

    /**
     * Name: remove
     * Removes the record with the given config from the dictionary.
     * Must throw a DictionaryException if no record in the hash table stores config.
     * @param config string configuration
     * @throws DictionaryException
     */
    public void remove(String config) throws DictionaryException {
        if (get(config) != -1) {
            int position = polyHash(config);
            table[position].remove();
        } else {
            throw new DictionaryException();
        }
    }

    /**
     * Name: get
     * Returns the score stored in the record of the dictionary with key config,
     * or -1 if config is not in the dictionary.
     * @param config string configuration
     * @return output or -1
     */
    public int get(String config) {
        int record = polyHash(config);
        int score;

        for (int i=0; i<table[record].size(); i++) {

            if (table[record].get(i).getConfiguration().equals(config)) {
                score = table[record].get(i).getScore();
                return score;
            }
        }
        return -1;
    }

    /**
     * Name: numRecord
     * Returns the number of Data objects stored in the dictionary.
     * @return numRecords
     */
    public int numRecord() {
        return numRecords;
    }


    /**
     * Name: polyHash
     * Go through the string and look at each char to determine where to put the record in the dictionary
     * 11, 33, 37, 39, 41
     * @param config string form of the board configuration
     * @return hashValue
     */
    private int polyHash(String config) {
        int hashValue = 0;

        for (int i = config.length()-1; i >= 0; i--) {
            hashValue = (hashValue * 39 + config.charAt(i)) % size;
        }

        return hashValue;
    }
}
