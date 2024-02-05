package org.zaidism.interviewprograms;

import static java.util.stream.Collectors.counting;
import static org.zaidism.model.EmployeeProvider.getEmployeeList;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.zaidism.model.Employee;

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
    }
}
