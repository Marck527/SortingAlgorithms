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

        // Displays unsorted original array for reference
        System.out.println(("Unsorted Array: ").toUpperCase());
        for (int i = 0; i < inputArr.length; i++) {
            System.out.print(inputArr[i] + " ");
        }

        System.out.println("");

        // Bubble Sort
        System.out.println(("Bubble Sort: ").toUpperCase());
        BubbleSort bbs = new BubbleSort(inputArr);
        bbs.sort(); // Call sort in Bubble Sort
        System.out.println(bbs.toString());
        System.out.println("Exec time (ns): " + bbs.getDuration());


        // Selection Sort
        System.out.println(("Selection Sort: ").toUpperCase());
        SelectionSort ss = new SelectionSort(inputArr);
        ss.sort(); // Call sort in Selection Sort
        System.out.println(ss.toString());
        System.out.println("Exec time (ns): " + ss.getDuration());

        // Insertion Sort
        System.out.println(("Insertion Sort: ").toUpperCase());
        InsertionSort is = new InsertionSort(inputArr);
        is.sort(); // Call sort in Insertion Sort
        System.out.println(is.toString());
        System.out.println("Exec time (ns): " + is.getDuration());

        // Merge Sort
        System.out.println(("Merge Sort: ").toUpperCase());
        MergeSort ms = new MergeSort(inputArr);
        ms.sort(); // Call sort in Insertion Sort
        System.out.println(ms.toString());
        System.out.println("Exec time (ns): " + ms.getDuration());
    }

}
