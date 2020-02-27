package com.elvis.dsa.algorithm.sorting;

public class BubbleSort implements ISortingAlgorithm {
    @Override
    public int[] sort(int[] in) {
        // in = {4, 7, 1, 10, 2, 9, 8, 6, 3, 5}

        for (int i = 0; i < in.length - 1; i++) {
            for (int j = i + 1; j < in.length; j++) {
                int minPtr = i;
                if (in[j] < in[i])
                    minPtr = j;
                if (minPtr > i) {
                    // swap
                    int tmp = in[minPtr];
                    in[minPtr] = in[i];
                    in[i] = tmp;
                }
            }
        }
        return in;
    }
}
