/**
 * Insertion Sort - O(n^2)
 *
 * The Insertion Sort compares the right (unsorted) element to the left (sorted) side.
 * If the rights value is less than of its left, it will swap those elements and then
 * look for other elements in the array which are also smaller than it, and swap if
 * needed until there is no more values smaller.
 *
 * In the best case (theta of n), the array will already be sorted from smallest to largest and the running
 * time will be linear O(n) as it will only need to compare the element being sorted to its left neighbour,
 * and that is, if it's smaller, it does not scan the rest of the left side and moves on to the next element.
 */

package com.company;

public class InsertionSort implements SortInterface{
    private int[] array;
    private long duration;

    public InsertionSort(int[] inputArr) {
        this.array = inputArr;

        sort();
    }

    public void sort() {
        long startTime = System.nanoTime();

        // Declares for inner loop, key and temp.
        int j, key, temp;
        // Outer loop loops through the array starting from one because j will hold the previous element
        for (int i = 1; i < this.array.length; i++) {
            // Set the key to the current outer loop iteration
            key = this.array[i];
            // Set j to one less of the current iteration (left side of the current element)
            j = i - 1;
            // While j is within bounds (has not reached the end of the list) and the key is less than the element to its left
            while (j >= 0 && key < this.array[j]) {
                // Swap
                temp = this.array[j];
                this.array[j] = this.array[j+1];
                this.array[j+1] = temp;

                // Decrement j so that if there are other elements to the left of the current element being sorted, it will also compare and swap if needed
                j--;
            }
        }
        long endTime = System.nanoTime();
        this.duration = (endTime - startTime);
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
