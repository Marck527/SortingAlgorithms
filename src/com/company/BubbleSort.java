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

public class BubbleSort {
    private int[] array;
    private long duration;

    public BubbleSort(int[] inputArr) {
        this.array = inputArr;
    }

    public void sort() {
        long startTime = System.nanoTime();
        int temp = 0; // Temporary variable used when swapping elements

        for (int i=0; i<array.length; i++) { // Outer loop loops through each element of the array
            for (int j=1; j<array.length; j++) { // Inner loop loops through the array again for EACH of the elements in the array
                if (array[j-1] > array[j]) { // Since j starts at 1, the first loop through will compare elements at zero index and one index
                    // If the left element is larger than the element to its right, swap them.
                    temp = array[j-1]; // Place the left (larger) element in the temporary array
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
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
