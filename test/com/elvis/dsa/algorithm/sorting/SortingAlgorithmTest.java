package com.elvis.dsa.algorithm.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortingAlgorithmTest {

    @Test
    void selectionSortTest() {
        int[] inArr = new int[]{4, 7, 1, 10, 2, 9, 8, 6, 3, 5};
        int[] expectedOutArr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ISortingAlgorithm sortAlgo = new SelectionSort();
        int[] actualOutArr = sortAlgo.sort(inArr.clone());
        System.out.println("Input: " + Arrays.toString(inArr));
        System.out.println("Sorted: " + Arrays.toString(actualOutArr));
        assertArrayEquals(expectedOutArr, actualOutArr);
    }
}
