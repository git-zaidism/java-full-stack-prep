package org.zaidism.dsalgo.recusion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //array must be sorted for binary search
        int target = 0;
        int result = binarySearch(sortedArray, target, 0, sortedArray.length - 1);
        System.out.println(result);
    }

    public static int binarySearch(int[] array, int target, int start, int end) {
        if (start > end)
            return -1;

        int mid = start + end / 2;

        if (array[mid] == target) return mid;

        if (array[mid] > target)
            return binarySearch(array, target, start, mid - 1);

        return binarySearch(array, target, mid + 1, end);
    }
}