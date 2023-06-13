package com.iskhak.list;

public class Queue<T> {

    Node head;
    Node tail;

    public void push(T value){
        Node node = new Node();
        node.value = value;
        node.next = head;
        head.previous = node;
        head = node;
    }
    public T peek(){
        T result = null;
        if(tail != null){
            result = tail.value;
            tail.previous.next = null;
            tail = tail.previous;
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
        Node previous;
    }

}
