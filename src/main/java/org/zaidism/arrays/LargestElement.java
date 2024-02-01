package org.zaidism.arrays;

public class LargestElement {
  public static void main(String[] args) {
    int arr[] = {1, 43, 90, 98, 100, 239, 1, 0, -1};
    int max = getMaximumElements(arr);
    System.out.println("Largest Element from arraya is " + max);
  }

  private static int getMaximumElements(int[] arr) {
    int max = arr[0];
    for (int i = 0; i < arr.length - 1; i++) {
      if (max < arr[i]) max = arr[i];
    }
    return max;
  }
}
