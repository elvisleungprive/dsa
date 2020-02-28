package com.elvis.dsa.algorithm.sorting;

public class SelectionSort implements ISortingAlgorithm {
    @Override
    public int[] sort(int[] inputArr) {
        // in = {4, 7, 1, 10, 2, 9, 8, 6, 3, 5}

        for (int i = 0; i < inputArr.length - 1; i++) {
            for (int j = i + 1; j < inputArr.length; j++) {
                int minIdx = i;
                if (inputArr[j] < inputArr[i])
                    minIdx = j;
                if (minIdx > i) {
                    // swap
                    int tmp = inputArr[minIdx];
                    inputArr[minIdx] = inputArr[i];
                    inputArr[i] = tmp;
                }
            }
        }
        return inputArr;
    }
}
