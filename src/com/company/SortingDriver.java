package com.company;

import java.util.Random;
import java.util.Scanner;

public class SortingDriver {
    public static void main(String[] args) {

        // Declare scanner object for user input
        Scanner input = new Scanner(System.in);
        // Declare random object for randomizing array
        Random random = new Random();

        // Records user input
        System.out.println("Please enter array size: ");
        int n = input.nextInt();

        // Set input array size to the users input
        int[] inputArr = new int[n];

        // Pupulate array with randomized integers
        for (int i = 0; i < n; i++) {
            // Bound of 1 million
            inputArr[i] = random.nextInt(1000000);
        }

        // Displays unsorted original array for reference
        System.out.println("---------------------------------");
        System.out.println(("Unsorted Array: ").toUpperCase());
        for (int i = 0; i < inputArr.length; i++) {
            System.out.print(inputArr[i] + " ");
        }


        System.out.println("");
        System.out.println("---------------------------------");

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

        // Merge Sort
        System.out.println(("Merge Sort: ").toUpperCase());
        System.out.println(new MergeSort(inputArr));
        System.out.println("---------------------------------");

        // Quick Sort
        System.out.println(("Quick Sort: ").toUpperCase());
        System.out.println(new QuickSort(inputArr));
        System.out.println("---------------------------------");

        // Shell Sort
        System.out.println(("Shell Sort: ").toUpperCase());
        System.out.println(new ShellSort(inputArr));
        System.out.println("---------------------------------");

        // Counting Sort
        System.out.println(("Counting Sort: ").toUpperCase());
        System.out.println(new CountingSort(inputArr));
        System.out.println("---------------------------------");

    }
}