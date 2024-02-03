package org.zaidism.functionalprogramming.stream;

import org.zaidism.model.Employee;

import java.util.List;

import static org.zaidism.model.EmployeeProvider.getEmployeeList;

public class Aggregation {
  public static void main(String[] args) {
    List<Employee> employees = getEmployeeList();

    // Corrected lambda expressions to compare Employee IDs
    Employee employeeMaxId = employees.stream().max((e1, e2) -> Integer.compare(e1.getId(), e2.getId())).orElseThrow();
    System.out.println("Employee With biggest employee ID is: " + employeeMaxId);

    Employee employeeMinId = employees.stream().min((e1, e2) -> Integer.compare(e1.getId(), e2.getId())).orElseThrow();
    System.out.println("Employee With smallest employee ID is: " + employeeMinId);
  }
}
