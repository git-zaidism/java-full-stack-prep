package org.zaidism.dsalgo.recusion;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 34, 454, 23, 11};
        reverseArrayRecursive(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void reverseArrayRecursive(int[] arr, int start, int end) {
        if (start == end)
            return;

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverseArrayRecursive(arr, start + 1, end - 1);
    }

}
