package com.company;

public class SortingDriver {
    public static void main(String[] args) {
        // The input array that will be used as the input array to be sorted.
        int[] inputArr = new int[]{2, 13, 1, 5};

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
        System.out.println(new CountingSort(inputArr, 13));
        System.out.println("---------------------------------");

    }
}