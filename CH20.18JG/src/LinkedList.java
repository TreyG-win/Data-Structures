/*
    Author: James Gwin

    Description: This object contains
    the information about the LinkedList.

    Date Created: 6 April 2023

    Date Modified: 2 May 2023

    Overview: This object holds all
    the information about what a
    LinkedList is. It also contains
    the methods required to allow the
    LinkedList to function.
 */
public class LinkedList<T> {

    Node<T> head;
    private int size = 0;

    /**
     * Places data at the end of a
     * list.
     *
     * @param data The value being entered.
     */
    public void insert(T data) {
        Node<T> nextData = new Node<>(data);
        nextData.data = data;
        nextData.next = null;

        if (head == null) {
            head = nextData;

        } else {
            Node<T> m = head;
            while (m.next != null) {
                m = m.next;
            }
            m.next = nextData;

        }
        size++;
    }

    /**
     * Returns the size of the
     * LinkedList
     * @return The LinkedList size
     */
    public int getSize(){
        return size;
    }

    /**
     * Returns the value at a
     * specific index
     * @param index The location
     * @return The value at the
     * index location.
     */
    public T getValueAt(int index){
        Node<T> mRtn = head;
        int counter = 0;
        while(mRtn.next != null && counter != index){
            mRtn = mRtn.next;
            counter++;
        }
        return mRtn.data;
    }

    /**
     * Replaces the value at a specific
     * index with another value.
     * @param index The desired index
     * @param val The value to set into
     *            the index.
     */
    public void replaceVal(int index, T val){
        Node<T> mRtn = head;
        int counter = 0;
        while(mRtn.next != null && counter != index){
            mRtn = mRtn.next;
            counter++;
        }
        mRtn.data = val;
    }


    /**
     * Displays the current list.
     */
    public void display() {
        Node<T> m = head;
        while (m.next != null) {
            System.out.println(m.data);
            m = m.next;
        }
        System.out.println(m.data);
    }
}


