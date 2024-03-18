package org.zaidism.functionalprogramming.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningBy {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    // Grouping numbers into even and odd categories
    Map<Boolean, List<Integer>> evenOddMap =
        list.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));

    // Outputting the result
    System.out.println("EVEN=" + evenOddMap.get(true));
    System.out.println("ODD=" + evenOddMap.get(false));
  }
}
