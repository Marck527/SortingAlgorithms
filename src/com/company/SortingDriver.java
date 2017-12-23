package com.company;

public class SortingDriver {
    public static void main(String[] args) {
        // The input array that will be used as the input array to be sorted.
        int[] inputArr = new int[]{2, 13, 1, 5};

        System.out.println("---------------------------------");
        // Displays unsorted original array for reference
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
        SelectionSort ss = new SelectionSort(inputArr);
        ss.sort(); // Call sort in Selection Sort
        System.out.println(ss.toString());
        System.out.println("Exec time (ns): " + ss.getDuration());
        System.out.println("---------------------------------");

        // Insertion Sort
        System.out.println(("Insertion Sort: ").toUpperCase());
        InsertionSort is = new InsertionSort(inputArr);
        is.sort(); // Call sort in Insertion Sort
        System.out.println(is.toString());
        System.out.println("Exec time (ns): " + is.getDuration());
        System.out.println("---------------------------------");

        // Merge Sort
        System.out.println(("Merge Sort: ").toUpperCase());
        MergeSort ms = new MergeSort(inputArr);
        ms.sort(); // Call sort in Insertion Sort
        System.out.println(ms.toString());
        System.out.println("Exec time (ns): " + ms.getDuration());
        System.out.println("---------------------------------");

        // Quick Sort
        System.out.println(("Quick Sort: ").toUpperCase());
        QuickSort qs = new QuickSort(inputArr);
        qs.sort(); // Call sort in Quick Sort
        System.out.println(qs.toString());
        System.out.println("Exec time (ns): " + qs.getDuration());
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