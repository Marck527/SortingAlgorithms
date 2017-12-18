package com.company;

public class MergeSort implements SortInterface{
    private int[] array;
    private long duration;

    public MergeSort(int[] inputArray) {
        this.array = inputArray;
    }

    public void sort() {
        long startTime = System.nanoTime();




        long endTime = System.nanoTime();
        this.duration = (endTime - startTime);
    }

    public long getDuration() { return this.duration; }; // Divide by 1000000 to get millisecond

    @Override
    public String toString() {
        return "MergeSort";
    }
}