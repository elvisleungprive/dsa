package com.elvis.dsa.algorithm.sorting;

public class MergeSort implements ISortingAlgorithm {
    private int[] arr;

    @Override
    public int[] sort(int[] inArr) {
        if (inArr.length == 0)
            return null;
        arr = inArr;
        mergeSort(0, arr.length - 1);
        return arr;
    }

    private void mergeSort(int start, int end) {

        if (end > start) {
            int mid = start + ((end - start) / 2);
            mergeSort(start, mid);
            mergeSort(mid + 1, end);

            // merge
            int[] tmp = new int[end - start + 1];
            int x = start;
            int y = mid + 1;

            for (int z = 0; z < tmp.length; z++) {
                if (x > mid) {
                    tmp[z] = arr[y];
                    y++;
                    continue;
                }

                if (y > end) {
                    tmp[z] = arr[x];
                    x++;
                    continue;
                }
                if (arr[x] < arr[y]) {
                    tmp[z] = arr[x];
                    x++;
                } else {
                    tmp[z] = arr[y];
                    y++;
                }
            }

            for (int z = 0; z < tmp.length; z++) {
                arr[start + z] = tmp[z];
            }
        }
    }
}
