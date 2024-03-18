package org.zaidism.functionalprogramming.collectors;

import org.zaidism.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static org.zaidism.model.EmployeeProvider.getEmployeeList;

// Group by and occurrence of every char in string
public class GroupingBy {
    public static void main(String[] args){
        List<Employee> employees = getEmployeeList();
        Map<Integer, List<Employee>> groupById = employees.stream().collect(Collectors.groupingBy(emp -> emp.getId()));

        groupById.entrySet().forEach(System.out::println);


        String name = "Abdullah";
        Map <String, Long> occrenceMap = Arrays.stream(name.split("")).collect(Collectors.groupingBy(
                Function.identity(), counting()
        ));

        occrenceMap.entrySet().forEach(System.out::println);

        // even odd using grp by ins single stream
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Grouping numbers into even and odd categories using groupingBy collector
        Map<String, List<Integer>> evenOddMap = list.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "EVEN" : "ODD"));

        // Outputting the result
        System.out.println(evenOddMap);
    }
}
