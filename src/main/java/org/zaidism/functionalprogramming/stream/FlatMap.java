package org.zaidism.functionalprogramming.stream;

import org.zaidism.model.Employee;

import java.util.List;
import java.util.stream.Collectors;

import static org.zaidism.model.EmployeeProvider.getEmployeeList;

public class FlatMap {
  public static void main(String[] args) {
    List<Employee> employees = getEmployeeList();

    String techStacks =
        employees.stream()
            .map(emp -> emp.getTechStack())
            .flatMap(strings -> strings.stream())
            .distinct()
            .collect(Collectors.joining(", "));

    System.out.println("All tech stacks of employees: " + techStacks);

    // without flat map
    List<List<String>> techStacksListOfList =
        employees.stream().distinct().map(emp -> emp.getTechStack()).collect(Collectors.toList());
    System.out.println(techStacksListOfList);
  }
}
