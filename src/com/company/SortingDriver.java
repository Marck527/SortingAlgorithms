package com.company;

import java.util.Random;
import java.util.Scanner;

public class SortingDriver {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        // Ask the user for the size of the array.
        System.out.println("Please enter array size: ");
        int n = input.nextInt();
        int[] inputArr = new int[n];
        for (int i = 0; i < n; i++) {
            inputArr[i] = random.nextInt(1000);
        }

        // Displays unsorted original array for reference
        System.out.println("---------------------------------");
        System.out.println(("Unsorted Array: ").toUpperCase());
        displayArr(inputArr);

        System.out.println();
        System.out.println("---------------------------------");

        /**
         * --Comparison Sorts--------------------------------
         */

        // Bubble Sort
        System.out.println(("Bubble Sort: ").toUpperCase());
        System.out.println(new BubbleSort(inputArr));
        System.out.println("---------------------------------");

        // Selection Sort
        System.out.println(("Selection Sort: ").toUpperCase());
        System.out.println(new SelectionSort(inputArr));
        System.out.println("---------------------------------");

        // Insertion Sort
        System.out.println(("Insertion Sort: ").toUpperCase());
        System.out.println(new InsertionSort(inputArr));
        System.out.println("---------------------------------");

        // Shell Sort
        System.out.println(("Shell Sort: ").toUpperCase());
        System.out.println(new ShellSort(inputArr));
        System.out.println("---------------------------------");

        /**
         * --Comparison Sorts(Divide and Conquer)------------
         */

        // Merge Sort
        System.out.println(("Merge Sort: ").toUpperCase());
        System.out.println(new MergeSort(inputArr));
        System.out.println("---------------------------------");

        // Quick Sort
        System.out.println(("Quick Sort: ").toUpperCase());
        System.out.println(new QuickSort(inputArr));
        System.out.println("---------------------------------");


        /**
         * --Counting Sorts--------------------------------
         */

        // Counting Sort
        System.out.println(("Counting Sort: ").toUpperCase());
        System.out.println(new CountingSort(inputArr));
        System.out.println("---------------------------------");

//        int[] inputArr = new int[]{2, 0, 3, 1, 3};
//        displayArr(inputArr);
//        System.out.println();

        // Radix Sort
        System.out.println(("Radix Sort: ").toUpperCase());
        System.out.println(new RadixSort(inputArr));
        System.out.println("---------------------------------");
    }

    // Print array
    private static void displayArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}