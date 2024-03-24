package org.zaidism.practice.dsa.array;

import java.util.Arrays;

public class LargestElement {
  public static void main(String[] args) {
    int arr[] = {1, 43, 90, 98, 100, 239, 1, 0, -1};
    int max1 = getMaximumElements(arr);
    System.out.println("Largest Element from array is " + max1);
    int max2 = getMaximumElementsUsingStream(arr);
    System.out.println("Largest Element from array is " + max2);
  }

  private static int getMaximumElements(int[] arr) {
    int max = arr[0];
    for (int i = 0; i < arr.length - 1; i++) {
      if (max < arr[i]) max = arr[i];
    }
    return max;
  }

  private static int getMaximumElementsUsingStream(int[] arr) {
    return Arrays.stream(arr).summaryStatistics().getMax();
  }
}
