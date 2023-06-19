package com.iskhak.tree;

import java.util.ArrayList;
import java.util.List;

public class SimpleTree {
    private Node root;

    public boolean contains(int value){
        return contains(root,value);
    }

    /**
     * Обходи в длину
     * @param node
     * @param value
     * @return
     */
    private boolean contains(Node node, int value){
        if(node.value == value){
            return true;
        }else{
            for (Node child: node.children){
                boolean result = contains(child,value);
                if(result)
                    return true;

            }
        }
      return false;
    }

    /**
     * Обход в ширину
     * @return
     */
    public List<Integer> values(){
        List<Integer> result = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        while(!nodes.isEmpty()){
            List<Node> children = new ArrayList<>();
            for(Node node: nodes){
                result.add(node.value);
                children.addAll(node.children);
            }
            nodes = children;
        }
        return result;
    }
    private class Node{
        private int value;
        private List<Node> children;
    }

}
