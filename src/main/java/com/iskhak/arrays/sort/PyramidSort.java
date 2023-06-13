package com.iskhak.arrays.sort;

public class PyramidSort {

    private int[] array;

    public PyramidSort(int[] array) {
        this.array = array;
    }

    private void sort(){
        for (int i = array.length/2-1; i >= 0; i--)
            heapify(array,array.length,i);

        for (int i = array.length-1; i >= 0 ; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array,i,0);
        }

    }

    private void heapify(int[] array, int heapSize, int rootIndex) {

        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 1;

        if(rightChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;

        if(rightChild < heapSize && array[rightChild] > array[largest])
            largest = leftChild;

        if(largest != rootIndex){
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            heapify(array,heapSize,largest);
        }

    }

    public void start(){
        sort();
    }
}
