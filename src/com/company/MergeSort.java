/**
 * Merge Sort - O(n log n)
 *
 * The Merge Sort algorithm is a divide and conquer algorithm. Meaning it divides the data into smaller
 * chunks and then conquers them. It accomplishes this by using recursion, which is a method that calls
 * itself over and over again until it reaches the base case or the breaking statement.
 *
 * There are two main parts in Merge sort, sorting and merging.
 *
 * The sort method (sortHelper) starts off by taking the range of the array to sort. That is from
 * index zero the length of the array minus one.
 *
 * It finds the midpoint of this and uses that as the end point of the left array (add one more for to get the start
 * of the right array)
 *
 * Once the midpoint is found, it calls the sortHelper again with the input of zero (start of the array) and the
 * middle (end of the 'left' array)
 *
 * It keeps doing this until there is only one element left in the array, and a one element array is already sorted.
 *
 * The second part is the merge part, which merges the left and right arrays into a sorted array. So once the recursion
 * method breaks the array into a one element array, it will merge the left and right side and sort them.
 * This will continue until we have the original array sorted.
 *
 * The running time of Merge Sort in the worst case is O(n log n) which is a very efficient algorithm.
 */

package com.company;

public class MergeSort implements SortInterface{
    private int[] array; // Array to be sorted
    private int[] tempArr; // Declare temporary holder array
    private long duration;

    public MergeSort(int[] inputArray) {
        this.array = inputArray;
        this.tempArr = new int[inputArray.length]; // Set the size of the temporary array to the array to be sorted
    }

    public void sort() {
        long startTime = System.nanoTime();

        sortHelper(0, this.array.length - 1); // Boot strap the sort helper and pass the start and end of the array to sort

        long endTime = System.nanoTime();
        this.duration = (endTime - startTime);
    }

    private void sortHelper(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) { // If there is more than one element in the array
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2; // Find the mid point by dividing by 2

            // Sort the left side of the array
            sortHelper(lowerIndex, middle);

            // Sort the right side
            sortHelper(middle + 1, higherIndex);

            // Merge left and right array
            merge(lowerIndex, middle, higherIndex);
        }

    }

    // Merge method
    private void merge(int lowerIndex, int middle, int higherIndex) {
        // Copy content of the array to be sorted to the temporary array which will get 'spliced'
        for (int i = lowerIndex; i <= higherIndex; i++) {
            this.tempArr[i] = this.array[i];
        }

        int i = lowerIndex; // Pointer for the left array
        int j = middle + 1; // Pointer for the right array
        int k = lowerIndex; // Pointer for the original array to sort

        // While the left AND right array are within bounds, continue
        while (i <= middle && j <= higherIndex) {
            // If the value in the left array of the current iteration is less than or equal to the value in the right
            if (this.tempArr[i] <= this.tempArr[j]) {
                this.array[k] = this.tempArr[i]; // Place the value in the left (smaller) in the original array
                i++;
            } else { // Right must be bigger
                this.array[k] = this.tempArr[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            this.array[k] = this.tempArr[i];
            k++;
            i++;
        }
    }

    public long getDuration() { return this.duration; }; // Divide by 1000000 to get millisecond

    @Override
    public String toString() {
        String arrayToPrint = "";
        for (int i = 0; i < this.array.length; i++) {
            arrayToPrint += array[i] + " ";
        }
        return arrayToPrint;
    }
}
