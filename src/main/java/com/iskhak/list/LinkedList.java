package com.iskhak.list;

public class LinkedList<T> {

    Node head;


    public void revert(){
        if(head != null && head.next != null){
            Node temp = head;
            revert(head.next,head);
            temp.next = null;
        }
    }
    private void revert(Node currentNode, Node previosNode){
        if(currentNode.next == null){
            head = currentNode;
        }else{
            revert(currentNode.next,currentNode);
        }
        currentNode.next = previosNode;

    }


    public class Node{
        T value;
        Node next;

    }

}
