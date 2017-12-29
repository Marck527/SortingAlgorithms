/**
 * Radix Sort - O(d(n+b))
 *
 * The Radix Sort a non comparative algorithm. It is a integer sorting
 * algorithm which uses integer keys to sort its input.
 *
 * Radix sort works by firstly looking for the largest value in the array
 * as this will determine the number of passes it will need to do to sort
 * the array. So if the largest value to sort is 337, it will only need a
 * total of three passes to sort because there is three digits in 337.
 *
 * Radix sort then sorts each value starting from the smallest place value
 * to the largest and this will depend on how many digits the largest value has.
 * So it will sort the array using the the ones place of each number, then by tens
 * , hundreds and so on.
 *
 * Radix is a stable sorting algorithm which means it will sort the numbers
 * in the same order that it was received.
 *
 * The time complexity of Radix is O(d*(n+b)) where d is the length of the
 * largest digit and the number of passes it will need to do. b is the
 * range of the base. Here we are using the base 10 system so it will be 10.
 */

package com.company;

public class RadixSort implements SortInterface {
    private int[] array;
    private long duration;
    private int n;
    private int maxVal;
    private int maxLength;

    public RadixSort(int[] inputArr) {
        this.array = inputArr;
        this.n = this.array.length;
        // Find the maximum value of the array
        findMax();
        // Find the length of the maximum value
        findLength();

        // Call sort method
        sort();
    }

    public void sort() {
        long startTime = System.nanoTime();

        // This is the divider variable and will help us get the ones, tens, hundreds
        // of an integer. Initially, start at 1 to get the ones place.
        int divider = 1;
        // mod stands for modulus. This is used to get the last digit of a number.
        int mod = 10;
        // Create output array with the same length as the array to sort
        int[] output = new int[n];

        // Loop through depending on the number of digits of the largest number
        for (int d = 0; d < this.maxLength; d++) {

            // Digit holder counter
            int[] count = new int[10];
            //Reset the counter array to zero for each iteration
            for (int i = 0; i < 10; i++) {
                count[i] = 0;
            }

            // Place the current place value as the index of the count array
            for (int i = 0; i < this.n; i++) {
                int digit = (this.array[i] % mod) / divider;
                // Increment counter array in the digit index
                ++count[digit];
            }

            // Counts each number which is  less than or equal to it in the count array
            // E.g for C[i], how many numbers are less than or equal to it? Place in C[i]
            for (int i = 1; i < 10; i++){
                count[i] += count[i-1];
            }

            // Starting from the end of the array (to keep stability), find the value as the
            // index of the count array to find out the position of in the output array.
            for (int i = n - 1; i >= 0; i--) {
                int digit = (this.array[i] % mod) / divider;
                output[count[digit] - 1] = this.array[i];
                count[digit]--;
            }

            // Copy the values of our output into the array, on the last pass,
            // sorting will be complete.
            for (int i = 0; i < n; i++) {
                this.array[i] = output[i];
            }

            // Multiply the mod and divider by 10
            mod *= 10;
            divider *= 10;
        }
        //
        long endTime = System.nanoTime();
        this.duration = (endTime - startTime);
    }

    public long getDuration() { return this.duration; } // Divide by 1000000 to get millisecond

    public int getMax() { return maxVal; }

    public int getMaxLength() { return maxLength; }

    private void findMax() {
        // Assume the first element of the array is the max
        this.maxVal = this.array[0];
        // Traverse the array and if any element is larger, set that to the new max.
        for (int i = 1; i < n; i++) {
            if (this.array[i] > this.maxVal) {
                this.maxVal = this.array[i];
            }
        }
    }

    // Find the length (number of digits) of the maximum value
    private void findLength() {
        // Copy maxVal to maxNum so we do not overwrite maxVal
        int maxNum = this.maxVal;
        // While the maximum number doesn't equal to zero
        while(maxNum != 0){
            // Increment maxLength counter
            this.maxLength++;
            // Divide maximum value by ten to reduce number of digits
            maxNum = maxNum / 10;
        }
    }

    // toString method returns sorted array
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < this.n; i++) {
            output += this.array[i] + " ";
        }
        output += "\n";
        output += "Exec time (ns): " + this.getDuration();
        return output;
    }
}
