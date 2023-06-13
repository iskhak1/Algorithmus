package com.iskhak.list;

public class DoubleLinkedList<T> {

    Node head;
    Node tail;

    public Node find(T value){
        Node currentNode = head;
        while(currentNode != null){
            if(currentNode.value == value){
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    /**
     * add in last
     * @param value
     */
    public void add(T value){
        Node node =  new Node();
        node.value = value;
        if(head == null){
            head = node ;
            tail = node;
        }else{
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public void add(T value, Node previousNode){
        Node next = previousNode.next;
        Node newNode = new Node();
        newNode.value = value;
        previousNode.next = newNode;
        newNode.previous = previousNode;
        if(next == previousNode){
            tail = newNode;
        }else{
            next.previous = newNode;
            newNode.next = next;
        }
    }

    public void delete(Node node){
        Node previos = node.previous;
        Node next = node.next;
        if(previos == null){
            next.previous = null;
            head = next;
        }else{
            if(next == null){
                previos.next = null;
                tail = previos;
            }else{
                previos.next = next;
                next.previous = previos;
            }
        }
        previos.next = next;
        next.previous = previos;
    }
    public void revert(){
        Node currentNode = head;
        while(currentNode != null){
            Node next = currentNode.next;
            Node previos = currentNode.previous;
            currentNode.next = previos;
            currentNode.previous = next;
            if(previos == null) {
                tail = currentNode;
            }if(next == null){
                head = currentNode;
            }
            currentNode = next;
        }
    }

    public class Node{
        T value;
        Node next;
        Node previous;

    }

}
