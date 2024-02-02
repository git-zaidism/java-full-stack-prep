package org.zaidism.algorithms;

public class BinarySearch {

  // Binary search function
  public static int binarySearch(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      // Check if the target is present at the middle
      if (array[mid] == target) return mid;
      else if (array[mid] < target) // If the target is greater, ignore the left half
      left = mid + 1;
      else // If the target is smaller, ignore the right half
      right = mid - 1;
    }
    // Target not found
    return -1;
  }

  public static void main(String[] args) {
    int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //array must be sorted for binary search
    int target = 5;
    int result = binarySearch(sortedArray, target);
    if (result != -1)
      System.out.println("Element found at index " + result);
    else
      System.out.println("Element not found in the array");
  }
}
