package org.zaidism.interviewprograms;

import java.util.List;

public class SecondLargest {
  public static void main(String[] args) {
    List<Integer> numList = List.of(12, 4, 3, 1, 88, 99, 100, 5, 1, 3);

    // second largest element from list
    Integer secondLargest =
        numList.stream()
            .distinct()
            .sorted((a, b) -> b.compareTo(a))
            .skip(1)
            .findFirst()
            .orElse(null);
    System.out.println("2nd largest number is: " + secondLargest);
  }
}
