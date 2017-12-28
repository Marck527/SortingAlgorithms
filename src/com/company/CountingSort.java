/**
 * Counting Sort - O(n+k)
 *
 * The Counting Sort Algorithm is not a traditional comparison sort, that is it does not compare values in the array
 * with each other. Instead, Counting sort is an integer sorting algorithm, which means it uses integer keys to sort
 * a collection of data.
 *
 * Counting sort works by traversing the array and counting the number of occurrences for each of the values within the
 * array. It then records the number of times it sees this value as the index of a seperate array (counter array) which
 * has a range between zero and the max value of the array to be sorted.
 *
 * Note: since the counter array which keeps track of the number of occurrences of the values in the original array has
 * a range between zero and the the max value of the array, values which do not show up in the array to be sorted are
 * simply marked as zero because is they do not show up in the array at all.
 *
 * Since the values of the array to be sorted is placed in ascending order as the index of the counter array, this is
 * how Counting sort sorts the original array, and if it comes across a duplicate value, it simply increments that index
 * on the counter array.
 */

package com.company;

public class CountingSort implements SortInterface {
    private int[] array;
    private int maxVal; // Receives input of the maximum value of the array
    private long duration;

    public CountingSort(int[] inputArr) {
        this.array = inputArr;
        this.maxVal = findMax(); // Find the max value of the input array

        sort();
    }

     public void sort() {
        long startTime = System.nanoTime();

        // The counter array will have a range between zero and the maximum value of the array to be sorted.
        int[] numCounts = new int[this.maxVal + 1];

        // Gets each value of the array to be sorted, use the value as the index of the numCounts array and increments the value for duplicate.
        // Note: this is where the list gets sorted, and counts the number of its occurrence.
        for (int num : this.array) {
            numCounts[num]++; // e.g array to be sorted {2, 3, 2, 5} numCounts{0, 0, 2, 1, 0, 1}
        }

        // Create array which will hold the final sorted array (same length as the array to be sorted)
        int[] sortedArray = new int[this.array.length];
        // Keeps track of the current sorted index in the sortedArray
        int currentSortedIndex = 0;

        // Loop through each value of the numCounts
        for(int num = 0; num < numCounts.length; num++) {
            int count = numCounts[num]; // Set count to the number of times the value in the array appears (which numCount recorded above)

            // For the number of times the value occurred
            for (int i = 0; i < count; i++) {
                // Add it to the sorted array
                sortedArray[currentSortedIndex] = num;
                currentSortedIndex++; // Increment current index
            }
        }
        this.array = sortedArray; // Copy the value of sortedArray to the class field array.

        long endTime = System.nanoTime();
        this.duration = (endTime - startTime);
    }

    public long getDuration() { return this.duration; }; // Divide by 1000000 to get millisecond

    // Method which finds the max value of the given array
    private int findMax() {
        // Assume the max value is the first element
        int max = this.array[0];
        // Loop through the input array
        for (int i = 0; i < this.array.length; i++) {
            // If the current ith iteration is greater than the current max, replace current max with the value
            if (max < this.array[i]) {
                max = this.array[i];
            }
        }
        return max;
    }

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
