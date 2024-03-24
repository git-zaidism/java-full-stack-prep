package org.zaidism.interviewprograms;

import java.util.stream.IntStream;

// swap every 2 pair of elements in array
// ip: 1,2,3,4,4,5 op: 2,1,4,3,5,4
// ip: 1 1 1 2 2 2 3 3 3 op: 1 1 2 1 2 2 3 3 3
public class SwapArrayElementInPair {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 4, 5};
    swapArrayByTwo(arr, 6);
    IntStream.of(arr).forEach(System.out::print);
  }

  private static void swapArrayByTwo(int[] arr, int n) {
    for (int i = 0; i < arr.length - 1; i += 2) {
      int temp = arr[i];
      arr[i] = arr[i + 1];
      arr[i + 1] = temp;
    }
  }
}
