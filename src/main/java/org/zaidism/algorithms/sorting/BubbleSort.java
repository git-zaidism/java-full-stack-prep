package org.zaidism.algorithms.sorting;

import java.util.Arrays;


public class BubbleSort {
  public static void main(String[] args) {
    int[] arr = {3, 1, 5, 4, 2}; // debug the code with sorted array in order to understand swapped flag as wel as 3 1 5 4 2 in order to understand j < arr.length - i
    int[] sortedArr = bubbleSort(arr);
    System.out.println("Elements after Bubble sort: " + Arrays.toString(sortedArr));
  }

  private static int[] bubbleSort(int[] arr) {
    boolean swapped;
    for (int i = 0; i < arr.length; i++) {
      swapped = false;
      for (int j = 1; j < arr.length - i; j++) { //largest element will at the end after 1st iteration arr.length - i
        if (arr[j] < arr[j - 1]) {
          int temp = arr[j];
          arr[j] = arr[j - 1];
          arr[j - 1] = temp;
          swapped = true;
        }
      }
      if (!swapped) break; // array is already sorted
    }
    return arr;
  }
}
