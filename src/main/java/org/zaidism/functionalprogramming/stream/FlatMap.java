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
            .flatMap(techStack -> techStack.stream())
            .distinct() //optional can be removed no impact of flattering logic
            .collect(Collectors.joining(", "));

    System.out.println("All tech stacks of employees: " + techStacks);

    // without flat map it will print steam of list<list<string>>
    List<List<String>> techStacksListOfList = employees.stream()
            .distinct() //optional can be removed no impact of flattering logic
            .map(emp -> emp.getTechStack())
            .toList();
    System.out.println(techStacksListOfList);
  }
}
