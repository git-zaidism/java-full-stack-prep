package org.zaidism.functionalprogramming.stream;

import org.zaidism.model.Employee;

import java.util.List;

import static org.zaidism.model.EmployeeProvider.getEmployeeList;

public class Filter {
  public static void main(String[] args) {

    List<Employee> employees = getEmployeeList();
    System.out.println("Employee with Even Employee ID's and salary greater than 50000.0 : ");
    employees.stream()
        .filter(e -> e.getId() % 2 == 0 && e.getSalary() > 60000)
        .toList()
        .forEach(System.out::println);
  }
}
