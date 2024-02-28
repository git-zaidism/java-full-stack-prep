package org.zaidism.functionalprogramming.stream;

import org.zaidism.model.Employee;

import java.util.Arrays;
import java.util.List;

import static org.zaidism.model.EmployeeProvider.getEmployeeList;
import static org.zaidism.model.EmployeeProvider.printEmployees;

public class Filter {
  public static void main(String[] args) {

    List<Employee> employees = getEmployeeList();
    System.out.println("Employee with Even Employee ID's and salary greater than 50000.0 : ");
    employees.stream()
        .filter(e -> e.getId() % 2 == 0 && e.getSalary() > 60000)
        .toList()
        .forEach(System.out::println);

    // find first whose salary is greater than 60k
    Employee firstEmpInList = employees.stream()
            .filter(e -> e.getSalary() > 60000.0)
            .findFirst()
            .orElseThrow();

    printEmployees(List.of(firstEmpInList), "First Employee in the list is");


    // count occurrence of specific character in a string
    String firstName = "Jahid Quraishi";
    System.out.println("Occurrence: "+firstName
            .chars()
            .filter(ch -> ch == 'a')
            .count());

    // Employee with max salary refer Aggregation.java for better approach
    System.out.println("Employee with max salary: ");
    double maxSalary = employees.stream().mapToDouble(emp -> emp.getSalary()).summaryStatistics().getMax();
    employees.stream()
            .filter(emp -> emp.getSalary() == maxSalary)
            .toList()
            .forEach(System.out::println);
  }
}
