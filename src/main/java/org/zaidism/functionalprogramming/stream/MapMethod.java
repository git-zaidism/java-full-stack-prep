package org.zaidism.functionalprogramming.stream;

import org.zaidism.model.Employee;

import java.util.Arrays;
import java.util.List;

import static org.zaidism.model.EmployeeProvider.getEmployeeList;
import static org.zaidism.model.EmployeeProvider.printEmployees;

public class MapMethod {
  public static void main(String[] args) {

    //increment salaries  of employee
    List<Employee> employees = getEmployeeList();

    List<Employee> employeesAfterSalaryIncrement = employees.stream()
            .map(emp -> new Employee(
                    emp.getId(),
                    emp.getName(),
                    emp.getBirthDate(),
                    emp.getSalary() * 2,
                    emp.getTechStack()
    )).toList();

    printEmployees(employeesAfterSalaryIncrement, "Employees after salary increment");

    // Employee with max salary refer Aggregation.java for better approach
    System.out.println("Employee with max salary: ");
    double maxSalary = employees.stream().mapToDouble(emp -> emp.getSalary()).summaryStatistics().getMax();
    employees.stream()
        .filter(emp -> emp.getSalary() == maxSalary)
        .toList()
        .forEach(System.out::println);


    // find first whose salary is greater than 60k
    Employee firstEmpInList = employees.stream()
            .filter(e -> e.getSalary() > 60000.0)
            .findFirst()
            .orElse(employees.get(0));

    printEmployees(Arrays.asList(firstEmpInList), "First Employee in the list is");

  }
}
