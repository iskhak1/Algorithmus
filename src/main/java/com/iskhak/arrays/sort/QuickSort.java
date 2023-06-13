package com.iskhak.arrays.sort;

public class QuickSort {
    private int [] array;
    private int startPosition;
    private int endPosition;
    public QuickSort(int[] array, int startPosition, int endPosition){
        this.array = array;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    private void sort(int[] array,int startPosition, int endPosition){
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2];
        do{
            while(array[leftPosition]<pivot){
                leftPosition++;
            }
            while(array[rightPosition]>pivot){
                rightPosition--;
            }
            if(leftPosition <= rightPosition){
                if(leftPosition < rightPosition){
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;

            }
        }while(leftPosition < rightPosition);

        if(leftPosition < endPosition){
            sort(array,leftPosition,endPosition);

        }
        if(startPosition < rightPosition){
            sort(array,startPosition,rightPosition);
        }
    }

    public void start(){
        sort(array,startPosition,endPosition);
    }

}
