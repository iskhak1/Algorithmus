package com.iskhak.arrays.search;

public class SimpleSearch {

    private int [] array;
    private int value;

    public SimpleSearch(int[] array, int value) {
        this.array = array;
        this.value = value;
    }

    public int search(){
        for (int i = 0; i < array.length; i++) {
            if(array[i]==value){
                return i;
            }
        }
        return -1;
    }


}
