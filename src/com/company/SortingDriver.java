/**
 * Sort Algorithms 16/12/2017
 * Author: Marck Munoz
 *
 * This mini project is my attempt to understand some of the most basic and common
 * sorting algorithms.
 *
 * Each algorithm will have it's own class solely for that algorithm only and will
 * be called in this driver file to be executed. I will also try my best to explain
 * line by line how the algorithms works and what each line of the code does.
 *
 * The algorithms I will cover in this project will include te following below:
 *
 * 1) Bubble Sort
 * 2) Selection Sort
 * 3) Insertion Sort
 * 4) Merge Sort
 * 5) Quick Sort
 * 6) Shell Sort
 */

package com.company;

public class SortingDriver {
    public static void main(String[] args) {
        // The input array that will be used as the input array to be sorted.
        int[] inputArr = new int[]{55, 20, 7, 2};

        // Bubble Sort
        System.out.println(("Bubble Sort").toUpperCase());
        System.out.print("Before: ");
        System.out.println(displayUnsortedArr(inputArr));

        System.out.print("After: ");
        BubbleSort bbs = new BubbleSort(inputArr);
        bbs.sort(); // Call sort in Bubble Sort
        System.out.println(bbs.toString());
    }

    // Just returns the original unsorted array
    private static String displayUnsortedArr(int[] arr) {
        String arrToDisplay = "";
        for (int i=0; i<arr.length; i++) {
            arrToDisplay += arr[i] + " ";
        }
        return arrToDisplay;
    }

}
