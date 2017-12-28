# Sorting Algorithms
17/12/2017

A collection of some of the most commonly used sorting algorithms.

The purpose of this was to give me solid understanding of each sorting algorithm.

For each algorithm, I have written a few paragraphs which briefly explains how it works and also it's time complexity. Most lines of code is also commented to explain the inner workings of the algorithm.

## Algorithms Covered

###### 1. Bubble Sort
###### 2. Selection Sort
###### 3. Insertion Sort
###### 4. Merge Sort
###### 5. Quick Sort
###### 6. Shell Sort
###### 7. Counting Sort
###### 8. Radix Sort

### *1). Bubble Sort - O(n^2)*

The Bubble Sort algorithm works by comparing the value of the left element to the element to its right.
If the value on the left hand side is larger than its right hand side neighbor, they swap.
Once the swap is complete, the 'pointer' or counter is incremented by one.

Once all the left and right hand pairs have been compared and swapped on the first pass, it will continue
the next pass (the total amount of pass will be the length of the array).

As you can tell, the larger values will rises or 'bubbles' to the right side of the array. And this is
where Bubble Sort get its name from.

The time complexity of Bubble Sort is O(n^2). It is a slow algorithm and will run slower as n grows larger.

### *2). Selection Sort - O(n^2)*

The Selection Sort algorithm works by initially setting  the first element of the array to the minimum value
and traverses the array to try and find a value smaller than the current minimum value.

If it finds a value smaller, it sets that value as the new minimum value or the min index. It then swaps that smaller
number with the number that is currently in the index so the small value ends up on the left hand side. After the swap,
the outer loop counter will get incremented by one so that it can find the second smallest number and swap it with
the second (1st) index of the array.

The Selection Sort algorithm is not a fast algorithm and has a time complexity of O(n^2) meaning as n (the size of the array)
gets larger, the time to sort the array will be proportional.

### *3). Insertion Sort - O(n^2)*

The Insertion Sort compares the right (unsorted) element to the left (sorted) side. If the rights value 
is less than of its left, it will swap those elements and then look for other elements in the array which 
are also smaller than it, and swap if needed until there is no more values smaller.

In the best case (theta of n), the array will already be sorted from smallest to largest and the running
time will be linear O(n) as it will only need to compare the element being sorted to its left neighbour,
and that is, if it's smaller, it does not scan the rest of the left side and moves on to the next element.

### *4). Merge Sort - O(n log n)*

The Merge Sort algorithm is a divide and conquer algorithm. It divides the data into smaller
chunks and then conquers them. It accomplishes this by using recursion, which is a method that calls
itself over and over again until it reaches the base case or the breaking statement.

There are two main parts of Merge sort, sorting and merging.

The sort method (sortHelper) starts off by taking the range of the array to sort. That is from
index zero the length of the array minus one. It finds the midpoint of this and uses that as the end point 
of the left array (add one more for to get the start of the right array)

Once the midpoint is found, it calls the sortHelper again with the input of zero (start of the array) and the
middle (end of the 'left' array)

It keeps doing this until there is only one element left in the array, and a one element array is already sorted.

The second part is the merge part, which merges the left and right arrays into a sorted array. So once the recursion
method breaks the array into a one element array, it will merge the left and right side and sort them.
This will continue until we have the original array sorted.

The running time of Merge Sort in the worst case is O(n log n) which is a very efficient algorithm.

### *5). Quick Sort - O(n log n)*

Quick Sort, like Merge Sort is also a divide and conquer algorithm which also makes use of
recursion.

Quick Sort works by selecting a 'pivot' in the array and then placing all the values less than
the pivot to its left and all the values greater to its right.

It will then repeat this step for the left and right side of the pivot until it breaks down the
array into one element, and a one element array is already sorted.

The two main parts of Quick Sort is the quick sort recursion method which breaks the array down
to a one element array and the partition method which will take the start and end of the input
array and use this to choose a new pivot and so on..

The time complexity of Quick Sort is θ(n log n) with the worst case of O(n^2) but the worst case
can be avoided by using random quick sort which uses a random pivot each time (not implemented here)

### *6). Shell Sort - O(n^2)*

The Shell Sort algorithm is a variation of Insertion Sort.

Shell Sort differs from Insertion Sort because Shell sort uses 'gap sorting' as well as insertion sort.
gap sorting sorts two elements in an array of a certain gap and then reduces the gap after the each pass
until the gap is only one which is just insertion sort.

The advantage of gap sorting is it roughly sorts the array, moving the larger values to the right and smaller
values to the left. By the time the gap reduces to one (Insertion sort), the array will mostly be sorted and
will only require smaller moves in the array to fully sort the array.

In the worst case, the time complexity of Shell Sort is O(n^2) with the best case being O(n log n).

### *7). Counting Sort - O(n+k)*

The Counting Sort Algorithm is not a traditional comparison sort, that is it does not compare values in the array
with each other. Instead, Counting sort is an integer sorting algorithm, which means it uses integer keys to sort
a collection of data.

Counting sort works by traversing the array and counting the number of occurrences for each of the values within the
array. It then records the number of times it sees this value as the index of a seperate array (counter array) which
has a range between zero and the max value of the array to be sorted.

Note: since the counter array which keeps track of the number of occurrences of the values in the original array has
a range between zero and the the max value of the array, values which do not show up in the array to be sorted are
simply marked as zero because is they do not show up in the array at all.

Since the values of the array to be sorted is placed in ascending order as the index of the counter array, this is
how Counting sort sorts the original array, and if it comes across a duplicate value, it simply increments that index
on the counter array.

### *8). Radix Sort - O(n^2)*

The Radix Sort a non comparative algorithm. It is a integer sorting
algorithm which uses integer keys to sort its input.

Radix sort works by firstly looking for the largest value in the array as this will determine the number
of passes it will need to do to sort the array. So if the largest value to sort is 337, it will only need
a total of three passes to sort because there is three digits in 337.

Radix sort then sorts each value starting from the smallest place value to the largest and this will depend 
on how many digits the largest value has. So it will sort the array using the the ones place of each number, 
then by tens , hundreds and so on.

Radix is a stable sorting algorithm which means it will sort the numbers in the same order that it was received.

The time complexity of Radix is O(d*(n+b)) where d is the length of the largest digit and the number of passes 
it will need to do. b is the range of the base. Here we are using the base 10 system so it will be 10.







