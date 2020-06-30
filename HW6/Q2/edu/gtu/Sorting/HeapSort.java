package edu.gtu.Sorting;

import java.time.Duration;
import java.time.Instant;

public class HeapSort {

    private static int comparisionAmount;
    private static int swapAmount;
    private static long runTime;
    private static long expectedRuntime;

    /** Sort the array using heapsort algorithm.
     pre : table contains Comparable items.
     post : table is sorted.
     @param table The array to be sorted
     */
    public static <E extends Comparable<? super E>> void sort(E[] table) {

        Instant start = Instant.now();

        buildHeap( table );
        shrinkHeap(table);

        Instant end = Instant.now();

        runTime = Duration.between( start , end ).toMillis();
        swapAmount = 0;
        comparisionAmount = 0;
        expectedRuntime = 0;

    }

    /** buildHeap transforms the table into a heap.
     pre : The array contains at least one item.
     post : All items in the array are in heap order.
     @param table The array to be transformed into a heap
     */
    private static <E extends Comparable<? super E>> void buildHeap(E[] table) {

        int n = 1;

        while (n < table.length) {
            n++;
            int child = n - 1;
            int parent = (child - 1) / 2;


            while (parent >= 0
                    && table[parent].compareTo(table[child]) < 0) {

                swap(table, parent, child);

                child = parent;
                parent = (child - 1) / 2;

            }
        }
    }

    /** shrinkHeap transforms a heap into a sorted array.
     pre : All items in the array are in heap order.
     post : The array is sorted.
     @param table The array to be sorted
     */
    private static <E extends Comparable<? super E>> void shrinkHeap(E[] table) {
        int n = table.length;

        while (n > 0) {
            n--;

            swap(table, 0, n);

            int parent = 0;
            while (true) {
                int leftChild = 2 * parent + 1;
                if (leftChild >= n) {
                    break;
                }
                int rightChild = leftChild + 1;
                int maxChild = leftChild;

                if (rightChild < n
                        && table[leftChild].compareTo(table[rightChild]) < 0) {
                    maxChild = rightChild;
                }

                if (table[parent].compareTo(table[maxChild]) < 0) {
                    swap( table, parent, maxChild );
                    parent = maxChild;
                } else {
                    break;
                }
            }
        }
    }


    /** Swap the items in table[i] and table[j].
     @param table The array that contains the items
     @param i The index of one item
     @param j The index of the other item
     */
    private static <E extends Comparable<? super E>> void swap(E[] table,
                                                       int i, int j) {
        E temp = table[i];
        table[i] = table[j];
        table[j] = temp;
    }

    /**
     * Clear the status
     */
    public static void clearStat( ) {
        comparisionAmount = 0;
        swapAmount = 0;
        runTime = 0;
        expectedRuntime = 0;
    }

    /**
     * Get comparision amount
     * @return comparision amount
     */
    public static int getComparisionAmount() {
        return comparisionAmount;
    }

    /**
     * Get swap amount
     * @return swap amount
     */
    public static int getSwapAmount() {
        return swapAmount;
    }

    /**
     * Get runtime
     * @return runtime
     */
    public static long getRunTime() {
        return runTime;
    }

    /**
     * Get expected runtime
     * @return expected runtime.
     */
    public static long getExpectedRuntime() {
        return expectedRuntime;
    }

}