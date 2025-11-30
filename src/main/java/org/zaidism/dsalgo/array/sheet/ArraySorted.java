package org.zaidism.dsalgo.array.sheet;

public class ArraySorted {
    public static void main(String[] args) {
        int[] arr = {0, 0, 12, 13, 14, 14, 15, 16};
        Boolean isSorted = checkArraySorted(arr);
        System.out.println(isSorted);
    }

    private static Boolean checkArraySorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }
}
