/*
    Author: James Gwin

    Description: This object holds the
    methods for the Linear Probing Hashing
    Table.

    Date Created: 27 April 2023

    Date Modified: 3 May 2023

    Overview: This object will take the
    values from the main object and places
    them into the mField integer. The table is
    then modified based on the mField LinkedList.

 */
public class LinearProbHashTable {

    LinkedList<Integer> mTable;
    LinkedList<Integer> mField;
    int tableSize;

    public LinearProbHashTable(LinkedList<Integer> mData, int tableSize, float loadFactor) {
        mTable = new LinkedList<>();
        mField = mData;
        this.tableSize = tableSize;
        setTableSize(tableSize,loadFactor);
    }

    /**
     * This method sets the size
     * of the table.
     * @param tableSize The size of the LinkedList
     *                  in the main object.
     * @param load The load factor for the table.
     */
    public void setTableSize(int tableSize, float load){
        int newTableSize = (int) (tableSize/load);
        for (int i = 0; i < newTableSize; i++) {
            mTable.insert(-1);
        }
    }

    /**
     * Hashes values into the table
     * with a linear probe to deal with
     * collisions.
     */
    public void tableLinearInsert(){
        int temp = 0;

        for (int i = 0; i < mField.getSize(); i++) {
           temp = HashFunction.hash(mField.getValueAt(i),mTable.getSize());
           int offset = 1;

           //If a collision happens, then the value
           //is incremented by one.
           while(mTable.getValueAt(temp) != -1){
               temp = (temp + offset) % mTable.getSize();
           }
           mTable.replaceVal(temp,mField.getValueAt(i));
        }

    }

    /**
     * Displays the table in a
     * tabulated format.
     */
    public void displayTable(){
        tableLinearInsert();
        System.out.println("ind" + "      Value");
        for (int i = 0; i < mTable.getSize(); i++) {
            System.out.println(i + ": " + "     " + mTable.getValueAt(i));
        }
        System.out.println(mTable.getSize() + " is the table size");
    }
}
