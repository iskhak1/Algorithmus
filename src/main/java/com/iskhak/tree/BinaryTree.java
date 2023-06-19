package com.iskhak.tree;

public class BinaryTree {

    private Node root;

    public boolean contains(int value){
        final Node node = findNode(root, value);
        return node != null;
    }

    private Node findNode(Node node, int value) {
        if(node.value == value){
            return node;
        }else{
            if(node.value > value){
                if(node.leftChild!=null){
                    return findNode(node.leftChild,value);
                }else{
                    return null;
                }
            }else{
                if(node.rightChild!=null){
                    return findNode(node.rightChild,value);
                }else{
                    return null;
                }
            }
        }
    }

    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;
    }

}
