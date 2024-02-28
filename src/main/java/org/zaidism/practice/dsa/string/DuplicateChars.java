package org.zaidism.practice.dsa.string;

import java.util.Arrays;
import java.util.HashMap;
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

    System.out.println(occrenceMap);
    // another way
    Map<Character, Long> occurrenceCharMap =
        Arrays.stream(name.split("")).collect(Collectors.groupingBy(s -> s.charAt(0), counting()));

    System.out.println(occurrenceCharMap);

    // custom logic by me
    Map<Character, Integer> charSequence = new HashMap<>();
    for (Character c : name.toCharArray()) {
      int count = 1;
      if (charSequence.containsKey(c)) {
        charSequence.put(c, charSequence.get(c) + 1);
      } else {
        charSequence.put(c, count);
      }
    }
    System.out.println(charSequence);
  }
}
