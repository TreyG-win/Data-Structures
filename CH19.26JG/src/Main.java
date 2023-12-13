import java.util.LinkedList;
import java.util.Scanner;

/*
    Author: James Gwin

    Description: This object is the
    main.

    Date Created: 19 April 2023

    Date Modified: 23 April 2023

    Overview: This object will prompt
    the user to enter a root number
    to start the BST. After entering
    the number 141, the program will
    end.

 */
public class Main {

    public static void main(String[] args) {
        BinarySearchTree mTree = new BinarySearchTree();
        LinkedList<Integer> mList = new LinkedList<>();

        Scanner mScnr = new Scanner(System.in);
        System.out.println("Type the number 141 to end this program.");
        System.out.println("Please enter a root into the list: ");
        int iNum = mScnr.nextInt();

        while(iNum != 141) {
            mList.add(iNum);

            mTree.add(mList.remove());
            mTree.display(0,mTree.rootVal,0);
            System.out.println("Please enter a new child node.");
            iNum = mScnr.nextInt();
        }

        System.out.println("Goodbye!");
    }
}
