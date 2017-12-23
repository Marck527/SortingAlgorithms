/**
 * Bubble Sort - O(n^2)
 *
 * The Bubble Sort algorithm works by comparing the value of the left element and the element to its right.
 * If the value on the left hand side is larger than its right hand side neighbor, they swap places so the
 * larger element is on the right side. Once the swap is complete, the 'pointer' or counter is incremented
 * by one so that the right hand side of the previous pair compared becomes the left hand side of this new
 * pair comparison.
 *
 * Once all the left and right hand pairs have been compared and swapped on the first pass, it will continue
 * the next pass (the total amount of pass will be the length of the array).
 *
 * As you can tell, the larger values rises or 'bubbles' to the right hand side of the array. This is where
 * Bubble Sort get its name from. The larger values 'bubbles' up to the top.
 *
 * The time complexity of Bubble Sort is O(n^2). It is a slow algorithm and will run slower as n grows larger.
 *
 *
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
