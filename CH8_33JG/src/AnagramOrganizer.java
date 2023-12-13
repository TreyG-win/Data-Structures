import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/*
    Author: James Gwin

    Description: This class is able to
    open a file and search for anagrams.

    Date Created: 21 February 2023

    Date Modified: 13 December 2023

    Overview: This class will try to
    search for a file name in the main().
    After the file is opened, every individual
    string will be sorted into alphabetical
    order with mSort(), but they will remain
    in the same position as they started in.
    Once the strings are sorted, mAna() will
    try to find two strings that are anagrams
    and will display the pairs.
 */
public class AnagramOrganizer {

    /**
     * This method is used to
     * return the words in a file
     * as an array with the fileOpener
     * class.
     * @param pName The name of the file
     * @return Returns the words as an array.
     */
    public String[] mFileViewer(String pName){
        return FileOpener.fileReader(pName).split("\n");
    }

    /**
     * This method sorts each of the
     * characters of a string into
     * alphabetical order.
     * @param pName The name of the file.
     * @return Returns the sorted strings as
     * an array.
     */
    public String[] mSort(String pName) {
        char[] mTempArray;
        String[] mInitialArray = mFileViewer(pName);
        for (int i = 0; i < mInitialArray.length; i++) {
            mTempArray = mInitialArray[i].toCharArray();
            Arrays.sort(mTempArray);
            mInitialArray[i] = String.valueOf(mTempArray);
        }
        return mInitialArray;
    }

    /**
     * This method will locate each
     * of the strings that are the same
     * from the array in mSort().
     * @param pName The name of the file.
     * @return Returns a string to indicate
     * that the method is done searching.
     */
    public String mAna(String pName){
        String[] mArray = mSort(pName);
        String[] mOrArr = mFileViewer(pName);
        for (int i = 0; i < mArray.length-1; i++) {
            for (int j = i+1; j < mArray.length; j++) {
                if((mArray[i].equals(mArray[j])) && (i != j)){
                    System.out.println("These words are pairs: " + mOrArr[i] + " and " + mOrArr[j]);
                }
            }
        }
        return "Finished searching!";
    }


    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Please enter the name of the text document that you");
        System.out.println("to see the anagrams of (without the extension).");
        Scanner scnr = new Scanner(System.in);
        String mName = scnr.nextLine();
        AnagramOrganizer mOpener = new AnagramOrganizer();
        System.out.println((mOpener.mAna(mName)));
    }
}
