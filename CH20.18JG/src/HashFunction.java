/*
    Author: James Gwin

    Description: This object holds
    the hashing function.

    Date Created: 27 April 2023

    Date Modified: 3 May 2023

    Overview: This object will
    contain the hash function for
    the program.

 */
public class HashFunction {
    /**
     * This utility method handles the
     * hashing for the table.
     * @param key The value being hashed.
     * @param tableSize The size of the table
     * @return The hash code for the key.
     */
    public static int hash(int key, int tableSize){

        key %= tableSize;
        if(key < 0){
            key += tableSize;
        }
        return key;
    }
}
