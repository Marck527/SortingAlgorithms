/**
 * Shell Sort - O(n^2)
 *
 * The Shell Sort algorithm is a variation of Insertion Sort.
 *
 * Shell Sort differs from Insertion Sort because Shell sort uses 'gap sorting' as well as insertion sort.
 * gap sorting sorts two elements in an array of a certain gap and then reduces the gap after the each pass
 * until the gap is only one which is just insertion sort.
 *
 * The advantage of gap sorting is it roughly sorts the array, moving the larger values to the right and smaller
 * values to the left. By the time the gap reduces to one (Insertion sort), the array will mostly be sorted and
 * will only require smaller moves in the array to fully sort the array.
 *
 * In the worst case, the time complexity of Shell Sort is O(n^2) with the best case being O(n log n).
 */

package com.company;

public class ShellSort implements SortInterface {
    private int[] array;
    private long duration;

    public ShellSort(int[] inputArr) {
        this.array = inputArr;

        sort();
    }

    public void sort() {
        long startTime = System.nanoTime();

        int gap = this.array.length / 2; // Defines the initial gap
        // Checks that the gap is not zero because a gap of zero is just one element
        while (gap > 0 ) {
            int j; // This is the decoy for i as we stil want to access the original value of i
            // Start at the gap and increment until the end of the array is reached
            for (int i = gap; i < array.length; i++) {
                // Temporary variable to hold the current ith value
                int temp = array[i];
                // Copies the value of i to j
                // Check that j is greater than or equal to the gap. This is because inside the for loop,
                // we subtract the value of gap from j and we need to make sure the index is within bounds.
                // Check if the value of j-gap is greater than temp, if so, copy the value A[j-gap] to A[j]
                // of the bigger value to j.
                // If a swap happens, j -= gap changes the value of j to the previous gap, and checks the
                // its previous gap
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp; // Set array[j] to the temp value
            }
            gap = gap / 2; // Reduce current gap
        }

        long endTime = System.nanoTime();
        this.duration = (endTime - startTime);
    }

    public long getDuration() { return this.duration; } // Divide by 1000000 to get millisecond

    // toString method returns sorted array
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
