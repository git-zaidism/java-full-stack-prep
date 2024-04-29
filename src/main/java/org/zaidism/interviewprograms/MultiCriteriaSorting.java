package org.zaidism.interviewprograms;

import org.zaidism.model.Employee;

import java.util.Comparator;
import java.util.List;

import static org.zaidism.model.EmployeeProvider.getEmployeeList;
import static org.zaidism.model.EmployeeProvider.printSeparation;

public class MultiCriteriaSorting {
  public static void main(String[] args) {
    List<Employee> employees = getEmployeeList();

    // multiple sorting criteria
    employees.stream()
        .sorted(
            Comparator.comparing(Employee::getName)
                .thenComparingInt(Employee::getId)
                .thenComparingDouble(Employee::getSalary))
        .forEach(System.out::println);

    printSeparation();
    // multiple sorting criteria
    employees.stream()
            .sorted(
                    Comparator.comparingInt(Employee::getId).reversed()
                            .thenComparing(Employee::getName)
                            .thenComparingDouble(Employee::getSalary).reversed())
            .forEach(System.out::println);
  }
}
