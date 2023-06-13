package com.iskhak.list;

public class Deque<T> {

    Node head;

    public void push(T value){
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    public T pop(){
        T result = null;
        if(head != null){
            result = head.value;
            head = head.next;
        }
         return result;
    }


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
