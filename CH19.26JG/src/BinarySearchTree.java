import java.util.LinkedList;
/*
    Author: James Gwin

    Description: This Object holds
    the information for the Binary
    Search Tree.

    Date Created: 19 April 2023

    Date Modified: 23 April 2023

    Overview: This Object stores the
    methods required to operate a Binary
    Search Tree. Once the tree is given values
    from a linked list, it will place them into
    a Binary Search Tree with the first value being
    the root. In the event that duplicates are found,
    they will be placed into a list with the first
    instance of that value.

 */
public class BinarySearchTree {

    Node rootVal;

    public BinarySearchTree(){
        this.rootVal = null;
    }

    /**
     * This method inserts a
     * value into the treeInsert().
     * @param value The desired
     *              value.
     */
    public void add(int value){
        if(rootVal == null){
            rootVal = new Node(value,null);
        }
        else{
            treeInsert(value,rootVal,null);
        }
    }

    /**
     * This method adds a value into
     * the Binary Tree.
     * @param data The value being placed.
     * @param node The current placement.
     * @param par The value one level above
     *            the node.
     */
    public void treeInsert(int data, Node node, Node par) {
        int parNum;
        if (node == null) {
            parNum = par.value.getFirst();
            Node temp = new Node(data, par);
            if (data < parNum) {
                par.previous = temp;
            } else {
                par.next = temp;
            }
            return;
        }

        parNum = node.value.getFirst();
        if (data == parNum) {
            node.insertVal(data);
        } else if (data < parNum) {
            treeInsert(data, node.previous, node);
        } else {
            treeInsert(data, node.next, node);
        }
    }

    /**
     * This method displays the current
     * Binary Tree.
     * @param key The current level of the tree.
     * @param value The current node.
     * @param location Whether the value
     *                 needs to be placed to
     *                 the left or right of the
     *                 parent.
     */
    public void display(int key, Node value, int location){
        if(value == null){
            return;
        }
        LinkedList<Integer> val = value.getValue();
        System.out.println("The current value is at this level " + key + ".");
        if(location == -1){
            System.out.println("This child is to the left of its parent.");
        }
        if(location == 1){
            System.out.println("This child is to the right of its parent.");
        }
        System.out.println("This node's value " + val + "\n");
        display(key + 1,value.previous,-1);
        display(key + 1,value.next, 1);
    }

}
