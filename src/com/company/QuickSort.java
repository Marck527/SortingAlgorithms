/**
 * Quick Sort - θ(n log n)
 *
 * Quick Sort, like Merge Sort is also a divide and conquer algorithm which also makes use of
 * recursion.
 *
 * Quick Sort works by selecting a 'pivot' in the array and then placing all the values less than
 * the pivot to its left and all the values greater to its right.
 *
 * It will then repeat this step for the left and right side of the pivot until it breaks down the
 * array into one element, and a one element array is already sorted.
 *
 * The two main parts of Quick Sort is the quick sort recursion method which breaks the array down
 * to a one element array and the partition method which will take the start and end of the input
 * array and use this to choose a new pivot and so on..
 *
 * The time complexity of Quick Sort is θ(n log n) with the worst case of O(n^2) but the worst case
 * can be avoided by using random quick sort which uses a random pivot each time (not implemented here)
 */

package com.company;

public class QuickSort implements SortInterface{
    private int[] array;
    private long duration;

    public QuickSort(int[] inputArray) {
        this.array = inputArray;

        sort();
    }

    public void sort() {
        long startTime = System.nanoTime();

        // Bootstrap the quicksort recursion with the range of the array to be sorted.
        quicksort(this.array, 0, this.array.length - 1);

        long endTime = System.nanoTime();
        this.duration = (endTime - startTime);
    }

    private void quicksort(int[] inputArr, int start, int end) {
        // Checks to see that we have more than one element in the array
        if (start < end) {
            // Find the pivot index
            int pivotIndex = partition(inputArr, start, end);
            // Quick sort the left side of the pivot
            quicksort(inputArr, start, pivotIndex - 1);
            // Quick sort the right side
            quicksort(inputArr, pivotIndex + 1, end);
        }
    }

    // Partition method returns the pivot index
    private int partition(int[] inputArr, int start, int end) {
        // In this Quick Sort implementation, the end of the given array is always the pivot
        int pivot = inputArr[end];
        // Counter to keep track of the array index
        int i = start;

        for (int j = start; j <= end - 1; j++) {
            // If the jth element is less than the pivot (end of the array)
            if (inputArr[j] < pivot) {
                // Swap i and j so that j (smaller value) is on the far left
                int temp = inputArr[i]; //
                inputArr[i] = inputArr[j];
                inputArr[j] = temp;

                // Increment array index counter (since the left of this is now sorted)
                i++;
            }
        }
        // Swap the pivot with the ith value which will be the last value NOT less than the pivot
        inputArr[end] = inputArr[i];
        inputArr[i] = pivot;
        // Return the index of the pivot
        return i;
    }

    public long getDuration() { return this.duration; }; // Divide by 1000000 to get millisecond

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < this.array.length; i++) {
            output += this.array[i] + " ";
        }
        output += "\n";
        output += "Exec time (ns): " + this.getDuration();
        return output;
    }
}
