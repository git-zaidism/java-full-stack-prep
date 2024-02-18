package org.zaidism.practice.dsa.array;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 43, 90, 98, 100, 239, 1, 0, -1};
        int[] reverseArray = reverseArray(arr);
        System.out.println(Arrays.toString(reverseArray));
    }

    private static int[] reverseArray(int[] arr) {
        int[] reverseArray = new int[arr.length];
        int index = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            reverseArray[index] = arr[i];
            index++;
        }
        return reverseArray;
    }
}
