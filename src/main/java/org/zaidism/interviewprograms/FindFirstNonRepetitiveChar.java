package org.zaidism.interviewprograms;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// first non repetitive first
public class FindFirstNonRepetitiveChar {
  public static void main(String[] args) {
    String str = "my name is jahid";

    String first =
        Arrays.stream(str.split(""))
            .collect(
                Collectors.groupingBy(
                    Function.identity(), LinkedHashMap::new, Collectors.counting()))
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue() == 1)
            .map(Map.Entry::getKey)
            .findFirst()
            .orElse("-1");

    System.out.println(first);

    String second =
        Arrays.stream(str.split(""))
            .collect(
                Collectors.groupingBy(
                    Function.identity(), LinkedHashMap::new, Collectors.counting()))
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue() == 1)
            .map(Map.Entry::getKey)
            .skip(1)
            .findFirst()
            .orElse("-1");

    System.out.println(second);
  }
}
