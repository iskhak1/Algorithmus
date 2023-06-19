package com.iskhak.tree;

public class Tree {

    Node root;
    static int counter = 0;

    public Node find(int value){
        Node current = root;
        while(current.value != value){
            if(value < current.value){
                current = current.leftChild;
            }else{
                current = current.rightChild;
            }

            if(current == null){
                return null;
            }
        }
        return current;
    }

    public void insert(int value){
        Node node = new Node();
        node.value = value;
        counter++;
        if(root == null){
            root = node;
        }else{
            Node current = root;
            Node parent;
            while(true){
                parent = current;
                if(value < current.value){
                    current = current.leftChild;
                    if(current == null){
                        parent.leftChild = node;
                        return;
                    }
                }else{
                    current = current.rightChild;
                    if(current == null){
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int value){
      Node current = root;
      Node parent = root;
      boolean isLeftChild = true;

      while(current.value != value){
            parent = current;
            if(value < current.value){
                isLeftChild = true;
                current = current.leftChild;
            }else{
                isLeftChild = false;
                current = current.rightChild;
            }
            if(current == null){
                return false;
            }

            if(current.leftChild == null && current.rightChild == null){
                if(current == root){
                    root = null;
                }else if(isLeftChild){
                    parent.leftChild = null;
                }else{
                    parent.rightChild = null;
                }
            }
            // если нет правого потомка
            else if(current.rightChild == null){
                if(current == root){
                    root = current.leftChild;
                }else if(isLeftChild){
                    parent.leftChild = current.leftChild;
                }else{
                    parent.rightChild = current.leftChild;
                }
            }
            // если нет левого потомка
          else if(current.leftChild == null){
              if(current == root){
                  root = current.rightChild;
              }else if(isLeftChild){
                  parent.leftChild = current.rightChild;
              }else{
                  parent.rightChild = current.rightChild;
              }
            }else{
              Node successor = getSuccessor(current);
              if(current == root){
                  root = successor;
              }else if(isLeftChild){
                  parent.rightChild = successor;
              }else{
                  parent.rightChild = successor;
              }
              successor.leftChild = current.leftChild;
            }
      }
      counter--;
        return true;
    }

    public Node getSuccessor(Node node){
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;

        while(current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if(successor != node.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
        return successor;
    }

    public void displayTree(){
        Stack stack = new Stack(1000);
        stack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        while (!isRowEmpty) {
            Stack localStack = new Stack(1000);
            isRowEmpty = true;
            for(int i=0;i<nBlanks;i++){
                System.out.print(" ");
            }
            while (!stack.isEmpty()) {
                Node temp = stack.pop();
                if (temp != null){
                    temp.display();
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if(temp.leftChild != null || temp.rightChild != null){
                        isRowEmpty = false;
                    }
                }else{
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println(" ");
            nBlanks = nBlanks / 2;
            while (!localStack.isEmpty()) {
                stack.push(localStack.pop());
            }
            System.out.println("..........................................");
        }
    }

    class Node{
        public int value;
        public  Node leftChild;
        public Node rightChild;
        public void display(){
            System.out.println("value " + value);
        }
    }

    class Stack{
        private int maxSize;
        private Node[] stack;
        private int top;
        public Stack(int size){
            this.maxSize = size;
            this.stack = new Node[this.maxSize];
            this.top = -1;
        }
        public void push(Node n){
            this.stack[++this.top] = n;
        }
        public Node pop(){
            return this.stack[this.top--];
        }
        public Node peek(){
            return this.stack[this.top];
        }
        public boolean isEmpty(){
            return (this.top == -1);
        }
        public boolean isFull(){
            return (this.top == this.maxSize-1);
        }
    }


}
