package org.zaidism.temp;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Demo {
  public static void main(String[] args) {
    int arr[] = {2,2,4,24,121,1};
    int[] array = IntStream.of(arr).distinct().toArray();
    System.out.println(Arrays.toString(array));
  }
}
