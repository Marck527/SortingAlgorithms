/**
 * Insertion Sort - O(n^2)
 *
 * The Insertion Sort algorithm compares the right (unsorted) element to the left (sorted) side.
 * If the rights value is larger than the left, it will swap and then compares it to the second left
 * of it and so on, until there is no more left hand side elements to compare itself to.
 *
 * If the value currently getting sorted (ith) is smaller than any of the values to its left, it will insert
 * itself into the correct position.
 *
 * In the best case (theta of n), the array will already be sorted from smallest to largest and the running
 * time will be linear (Big O(n)) as it will only need to compare the element being sorted to its left neighbour,
 * and that is, if it's smaller, it does not scan the rest of the left side and moves on to the next element.
 *
 */

package com.company;

public class InsertionSort implements SortInterface{
    private int[] array;
    private long duration;

    public InsertionSort(int[] inputArr) {
        this.array = inputArr;
    }

    public void sort() {
        long startTime = System.nanoTime();
        int j, key, temp; // Declares variables

        for (int i = 1; i < array.length; i++) { // Outer loop loops through the array starting from one because j will hold the previous element
            key = array[i]; // Set the key to the current outer loop iteration
            j = i-1; // Set j to one less of the current iteration (left side of the current element)

            while (j >= 0 && key < array[j]) { // While j is within bounds and the key is less than the element to the left of it
                // Swap
                temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;

                j--; // Decrement j so that if there are other elements to the left of the current element being sorted, it will also compare and swap if needed
            }
        }
        long endTime = System.nanoTime();
        this.duration = (endTime - startTime);
    }

    public long getDuration() { return this.duration; }; // Divide by 1000000 to get millisecond

    @Override
    public String toString() {
        String arrayToPrint = "";
        for (int i = 0; i < array.length; i++) {
            arrayToPrint += array[i] + " ";
        }
        return arrayToPrint;
    }
}
