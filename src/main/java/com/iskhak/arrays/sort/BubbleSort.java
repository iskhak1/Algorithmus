package com.iskhak.arrays.sort;

import java.util.Arrays;

public class BubbleSort {

    private int[] array;

    public BubbleSort(int[] arrray){
        this.array = arrray;
    }

    private void sort(){
        boolean finish = true;
        do {
            finish = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    finish = false;
                }
            }
        }while (!finish);
    }

    public void start() {
        sort();
    }
}
