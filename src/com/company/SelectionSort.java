/**
 * Selection Sort - O(n^2)
 *
 * The Selection Sort algorithm works by initially setting  the first element of the array to the minimum value
 * and then scans through the array to try and find a value smaller than the current minimum value.
 *
 * If it finds a value smaller, it sets that value as the new minimum value or min index. It then swaps that smaller
 * number with the number that is currently in the index so the small value ends up on the left hand side. After the swap,
 * the outer loop counter will get incremented by one so that it can find the second smallest number and swap it with
 * the second (1st) index of the array.
 *
 * The Selection Sort algorithm is not a fast algorithm and has a time complexity of O(n^2) meaning as n (the size of the array)
 * gets larger, the time to sort the array will be proportional.
 *
 */

package com.company;

public class SelectionSort implements SortInterface{
    private int[] array;
    private long duration;

    public SelectionSort(int[] inputArr) {
        this.array = inputArr;
    }

    public void sort() {
        long startTime = System.nanoTime();
        for (int i = 0; i < array.length - 1; i++) {
            int iMin = i; // Keeps track of smallest numbers index.

            for (int j = i+1; j < array.length; j++) { // Loop through array starting one more then the index

                if (array[j] < array[iMin]) { // loop through the array and find the number less than the current index if any
                    iMin = j; // If found a smaller number than the current index, make that te new smaller number index
                }
                int temp = array[i]; // Place current element on the index to the temp variable
                array[i] = array[iMin]; // Copy the smallest number in the current index (outer loop)
                array[iMin] = temp; // Copy the temp to the position of the old min index
            }
        }
        long endTime = System.nanoTime();
        this.duration = (endTime - startTime);
    }

    public long getDuration() { return this.duration; };

    @Override
    public String toString() {
        String arrayToPrint = "";
        for (int i = 0; i < array.length; i++) {
            arrayToPrint += array[i] + " ";
        }
        return arrayToPrint;
    }
}
