package org.zaidism.interviewprograms;

import static java.util.stream.Collectors.counting;
import static org.zaidism.model.EmployeeProvider.getEmployeeList;
import static org.zaidism.model.EmployeeProvider.printSeparation;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.zaidism.model.Employee;

// Group by and occurrence of every char in string
public class GroupingBy {
  public static void main(String[] args) {
    groupByIdEmployees();
    occurrenceOfCharacterOfString();
    countUniqueWordInSentence();
    evenOddUsingSingleStream();
  }

    private static void evenOddUsingSingleStream() {
        // even odd using grp by ins single stream
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Grouping numbers into even and odd categories using groupingBy collector
        Map<String, List<Integer>> evenOddMap = list.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "EVEN" : "ODD"));

        // Outputting the result
        System.out.println(evenOddMap);
    }

    private static void countUniqueWordInSentence() {
    String str = "This this is is done by Saket Saket";
    str = str.toLowerCase();
    String[] split = str.split(" ");

    HashMap<String, Integer> stringHashMap = new LinkedHashMap<>();
    for (int i = 0; i < split.length; i++) {
      if (stringHashMap.containsKey(split[i])) {
        int count = stringHashMap.get(split[i]);
        stringHashMap.put(split[i], count + 1);
      } else {
        stringHashMap.put(split[i], 1);
      }
    }
    stringHashMap.entrySet().forEach(System.out::print);
    printSeparation();

    // another way
    Map<String, Long> stringMap =
        Arrays.stream(str.split("\\s"))
            .collect(Collectors.groupingBy(String::toLowerCase, counting()));
    stringMap.entrySet().forEach(System.out::print);
  }

  private static void occurrenceOfCharacterOfString() {
    String name = "Abdullah";
    Map<String, Long> occrenceMap =
        Arrays.stream(name.split(""))
            .collect(Collectors.groupingBy(Function.identity(), counting()));

    occrenceMap.entrySet().forEach(System.out::print);
    printSeparation();
  }

  private static void groupByIdEmployees() {
    List<Employee> employees = getEmployeeList();
    Map<Integer, List<Employee>> groupById =
        employees.stream().collect(Collectors.groupingBy(emp -> emp.getId()));

    groupById.entrySet().forEach(System.out::println);
    printSeparation();
  }
}
