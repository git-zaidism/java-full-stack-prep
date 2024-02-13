package org.zaidism.interviewprograms;

import java.util.List;

public class SecondSmallest {

  public static void main(String[] args) {
    List<Integer> numList = List.of(12, 4, 3, 1, 88, 99, 100, 5, 1, 3);

    // second smallest
    Integer secondSmallest = numList.stream().distinct().sorted().skip(1).findFirst().orElse(null);
    System.out.println("2nd smallest number is: " + secondSmallest);
  }
}
