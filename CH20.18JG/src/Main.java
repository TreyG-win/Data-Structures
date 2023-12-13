/*
    Author: James Gwin

    Description: This object holds
    the main for the program.

    Date Created: 27 April 2023

    Date Modified: 3 May 2023

    Overview: This object holds
    the main for the program. When
    the program starts, 10k random numbers
    will be generated for the LinkedList.

 */
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        float loadFactor = 0.9f;
        LinkedList<Integer> mList = new LinkedList<>();

        Random mRand = new Random();
        for (int i = 0; i < 10000; i++) {
            mList.insert(mRand.nextInt(10000));
        }

        LinearProbHashTable mTable = new LinearProbHashTable(mList, mList.getSize(), loadFactor);
        mTable.displayTable();

    }
}
