# Module_5_-_Multithreading_Sorting_-_Searching_Stack_vs_Heap_and_Runtime_Arguments
Module 5 Assignment.

Explanation of the code:
Bubble Sort: We implement a simple bubble sort algorithm where elements are compared and swapped if they are out of order.

Quick Sort: A recursive quicksort algorithm is implemented. This algorithm works by selecting a "pivot" and partitioning the array around it.

Command-line Argument Handling: The program expects exactly five integers. If there are more or fewer arguments, it prints an error message and exits.

Multithreading: Two threads are used:

The first thread prints the unsorted list of numbers.

The second thread sorts the numbers using the selected algorithm (either bubble sort or quick sort) and then prints the sorted list.

Sum Calculation: After both threads finish execution, the sum of the numbers is calculated and printed.

Sort Method Selection: The program uses a default bubble sort, but if the user provides the argument "quick", the program will use quicksort.

Example Execution:
$ java AdvancedJava 5 2 8 1 3
Unsorted Numbers: 5 2 8 1 3
Sorted Numbers: 1 2 3 5 8
Sum of Numbers: 19

If you want to choose a quicksort instead of bubble sort, you can run:
$ java AdvancedJava 5 2 8 1 3 quick
Unsorted Numbers: 5 2 8 1 3
Sorted Numbers: 1 2 3 5 8
Sum of Numbers: 19

Error Handling:
If there are not exactly five numbers, or if a non-integer is provided, the program will exit and print an appropriate error message.

![download - 2024-10-01T123125 942](https://github.com/user-attachments/assets/1aeaaf8a-a15b-4368-82af-1ff5df3d2064)
