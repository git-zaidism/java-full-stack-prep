package org.zaidism.functional;

import org.zaidism.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

// Group by and occurrence of every char in string
public class GroupingBy {
    public static void main(String[] args){
        List<Employee> employees = CustomObjectSorting.getEmployeeList();
        Map<Integer, List<Employee>> groupById = employees.stream().collect(Collectors.groupingBy(emp -> emp.getId()));
        // one way of iterating over a map
        groupById.entrySet().forEach(System.out::println);

        // another way : Iterate over the entry set and print values
        groupById.entrySet().forEach(entry -> {
            System.out.println("ID: " + entry.getKey());
            entry.getValue().forEach(System.out::println);
            System.out.println("--------------------------");
        });

        String name = "Abdullah";

        Map <String, Long> occrenceMap = Arrays.stream(name.split("")).collect(Collectors.groupingBy(
                Function.identity(), counting()
        ));
        occrenceMap.entrySet().forEach(System.out::println);
    }
}
