/**
 * Shell Sort - O(n^2)
 *
 * The Shell Sort algorithm is a variation of Insertion Sort.
 *
 * Shell Sort is different from Insertion Sort because Shell uses 'gap sort' where it sorts two elements of a certain gap
 *  as it moves through the array. After the first pass, it will reduce this gap until it reduces it to only the gap of one
 *  which is just Insertion Sort.
 *
 *  The advantage of doing this is it roughly sorts the array moving the larger values to the right and smaller values to the
 *  left during the gap sort and by the time it reaches the insertion sort where the gap is only one, the array will already
 *  be mostly sorted so smaller moves are required to fully sort the array.
 *
 *  In the worst case, the time complexity of Shell Sort is O(n^2) with the best case being O(n log n).
 */

package com.company;

public class ShellSort implements SortInterface {
    private int[] array;
    private long duration;

    public ShellSort(int[] inputArr) {
        this.array = inputArr;
    }

    public void sort() {
        long startTime = System.nanoTime();

        int gap = array.length / 2; // Defines the initial gap
        // Checks that the gap is not zero because a gap of zero is just the element comparing to itself to itself
        while (gap > 0 ) {
            int j; // Decoy for i
            // Start at the gap and increment until the end of the array is reached
            for (int i = gap; i < array.length; i++) {
                int temp = array[i]; // Temporary variable to hold the current ith value
                // Copies the value of i to j, checks if j is greater than the gap because inside the for loop, we
                // take away gap from j and we need to make sure the index is not out of bounds. Checks that the gap
                // between the current j and the j - gap is greater than the temp which holds i, if so, copy value
                // of the bigger value to j.
                // If a swap happenes, j -= gap changed the value of j to te gap, and checks th previous gap value
                // and swaps if necessary
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp; // Set array[j] to the temp's value to complete swap
            }
            gap = gap / 2; // Reduce current gap
        }
        long endTime = System.nanoTime();
        this.duration = (endTime - startTime);
    }

    public long getDuration() { return this.duration; }; // Divide by 1000000 to get millisecond

    // toString method returns sorted array
    @Override
    public String toString() {
        String arrayToPrint = "";
        for (int i = 0; i < array.length; i++) {
            arrayToPrint += array[i] + " ";
        }
        return arrayToPrint;
    }
}
