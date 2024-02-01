package org.zaidism.string;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class DuplicateChars {
  public static void main(String[] args) {
    String name = "Abdullaahh";

    Map<String, Long> occrenceMap =
        Arrays.stream(name.split(""))
            .collect(Collectors.groupingBy(Function.identity(), counting()));

    occrenceMap.entrySet().forEach(System.out::println);

    //another way
    Map<Character, Long> occurrenceCharMap =
        Arrays.stream(name.split("")).collect(Collectors.groupingBy(s -> s.charAt(0), counting()));

    occurrenceCharMap.entrySet().forEach(System.out::println);
  }
}
