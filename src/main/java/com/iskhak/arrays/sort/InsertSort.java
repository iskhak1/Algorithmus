package com.iskhak.arrays.sort;

public class InsertSort {

    private int[] array;

    public InsertSort(int[] array) {
        this.array = array;
    }

    private void sort(){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i]>array[j]){
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    }
    public void start(){
        sort();
    }
}
