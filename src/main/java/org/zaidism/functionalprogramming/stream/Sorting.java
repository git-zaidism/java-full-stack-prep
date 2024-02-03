package org.zaidism.functionalprogramming.stream;

import org.zaidism.model.Employee;

import java.util.List;

import static org.zaidism.model.EmployeeProvider.getEmployeeList;

public class Sorting {
  public static void main(String[] args) {
    List<Employee> employees = getEmployeeList();
    employees.stream().sorted((e1, e2) -> e1.getBirthDate().compareTo(e2.getBirthDate())).toList().forEach(System.out::println);
  }
}
