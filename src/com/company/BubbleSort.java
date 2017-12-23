/**
 * Bubble Sort - O(n^2)
 *
 * The Bubble Sort algorithm works by comparing the value of the left element to the element to its right.
 * If the value on the left hand side is larger than its right hand side neighbor, they swap.
 * Once the swap is complete, the 'pointer' or counter is incremented by one.
 *
 * Once all the left and right hand pairs have been compared and swapped on the first pass, it will continue
 * the next pass (the total amount of pass will be the length of the array).
 *
 * As you can tell, the larger values will rises or 'bubbles' to the right side of the array. And this is
 * where Bubble Sort get its name from.
 *
 * The time complexity of Bubble Sort is O(n^2). It is a slow algorithm and will run slower as n grows larger.
 */

package com.company;

public class BubbleSort implements SortInterface {
    private int[] array;
    private long duration;

    public BubbleSort(int[] inputArr) {
        this.array = inputArr;

        // Call sort method
        sort();
    }

    public void sort() {
        long startTime = System.nanoTime();

        // Temporary variable used when swapping elements
        int temp;
        // Outer loop will traverse the array
        for (int i = 0; i < this.array.length; i++) {
            // Inner loop. Starting from j + 1 index
            for (int j = 1; j < this.array.length; j++) {
                // Check if the value of j-1 is greater than j (compare left to right)
                if (this.array[j-1] > this.array[j]) {
                    // If the left element is larger than the element to its right, swap.
                    // Place the left (larger) element in the temporary variable
                    temp = this.array[j-1];
                    // Place the smaller value to its position
                    this.array[j-1] = this.array[j];
                    // Place the larger value of the two to at A[j] to complete the swap
                    this.array[j] = temp;
                }
            }
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
