package com.iskhak.arrays.sort;

// sortirovka viborom
public class DirectSort {

    private int[] array;

    public DirectSort(int[] array){
     this.array = array;
    }

    private void sort(){
        for (int i = 0; i < array.length-1 ; i++) {
            int minPosition = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[minPosition]){
                    minPosition = j;
                }
            }
            if(i!=minPosition){
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
        }
    }

    public void start(){
        sort();
    }
}
