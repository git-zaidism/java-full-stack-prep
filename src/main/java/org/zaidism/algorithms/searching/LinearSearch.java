package org.zaidism.algorithms.searching;

public class LinearSearch {

  public static void main(String[] args) {
    int[] arr = {12, 56, 32, 10, 56, 90, 81};
    int target = 32;
    int index = linearSearch(arr, target);
    if (index != -1)
      System.out.println("Element found at index " + index);
    else
      System.out.println("Element not found in the array");
  }

  private static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target)
        return i;
    }
    return -1;
  }
}
