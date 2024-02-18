package org.zaidism.practice.dsa.string;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Occurrence {
  public static void main(String[] args) {
    String name = "Amina";

    Map<String, Long> occurenceMap =
        Arrays.stream(name.split(""))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    occurenceMap.entrySet().forEach(System.out::println);
  }
}
