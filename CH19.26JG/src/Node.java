import java.util.LinkedList;
/*
    Author: James Gwin

    Description: This object holds
    the information about the nodes.

    Date Created: 19 April 2023

    Date Modified: 23 April 2023

    Overview: This node object reuses
    some information from my previous
    node objects. However, I have instead
    utilized the built-in LinkedList for this
    program.

 */
public class Node {
    Node par;
    Node next;
    Node previous;
    LinkedList<Integer> value;

    Node(int data, Node parent){
        value = new LinkedList<>();
        value.add(data);
        this.previous = null;
        this.next = null;
        this.par = parent;
    }

    /**
     * Returns the LinkedList.
     * @return The current LinkedList.
     */
    public LinkedList<Integer> getValue(){
        return value;
    }

    /**
     * Inserts a value into the Node's
     * LinkedList.
     * @param data The desired value.
     */
    public void insertVal(int data){
        value.add(data);
    }


}
