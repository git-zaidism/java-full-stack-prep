package org.zaidism.functionalprogramming;

import org.zaidism.model.Employee;

import java.util.List;

public class MapMethod {
  public static void main(String[] args) {
    List<Integer> numList = List.of(12, 11, 64, 1, 4, 1, 234, 0, 8);
    numList.stream().map(num -> num / 2).toList().forEach(System.out::println);

    System.out.println(
        "----------------------------------------------------------------------------------------");

    List<Employee> employees = CustomObjectSorting.getEmployeeList();

    System.out.println("Employees after IDs multiply by 5: ");
    List<Employee> employeesAfterIdChange =
        employees.stream()
            .map(
                emp -> {
                  emp.setId(5 * emp.getId());
                  return emp;
                })
            .toList();

    CustomObjectSorting.printEmployees(employeesAfterIdChange);

    // Employee with max salary
    System.out.println("Employee with max salary: ");
    double maxSalary =
        employees.stream().mapToDouble(emp -> emp.getSalary()).summaryStatistics().getMax();

    employees.stream()
        .filter(emp -> emp.getSalary() == maxSalary)
        .toList()
        .forEach(System.out::println);
    System.out.println(
        "----------------------------------------------------------------------------------------");


    // Employee with max salary
    System.out.println("Employee with min salary: ");
    double minSalary = employees.stream().mapToDouble(e->e.getSalary()).summaryStatistics().getMin();
    employees.stream().filter(e->e.getSalary()==minSalary).toList().forEach(System.out::println);
    System.out.println(
            "----------------------------------------------------------------------------------------");

  }
}
