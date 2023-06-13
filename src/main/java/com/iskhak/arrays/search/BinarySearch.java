package com.iskhak.arrays.search;

public class BinarySearch {

    private int [] array;
    private int value;
    private int min;
    private int max;


    public BinarySearch(int[] array, int value, int min, int max) {
        this.array = array;
        this.value = value;
        this.min = min;
        this.max = max;
    }


    private int search(int[] array, int value,int min, int max){
        int midpoint;
        if(max < min){
            return -1;
        }else {
            midpoint = (max - min) / 2 + min;
        }
        if(array[midpoint] < value){
            return search(array,value,midpoint+1,max);
        }else{
            if(array[midpoint] > value){
                return search(array,value,min,midpoint-1);
            }
            return midpoint;
        }
    }
    public int search(){
        return search(array,value,min,max);
    }
}
