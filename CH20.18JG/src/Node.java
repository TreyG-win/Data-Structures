/*
    Author: James Gwin

    Description: This object holds
    the Node information.

    Date Created: 6 April 2023

    Date Modified: 7 April 2023

    Overview: This object holds
    the information to describe
    what a Node is.
 */
public class Node<T> {
    T data;
    Node<T> next;

    Node(T data){
        this.data = data;
        this.next = null;
    }


}

