package org.zaidism.functionalprogramming.stream;

import org.zaidism.functionalprogramming.customsorting.CustomObjectSorting;
import org.zaidism.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.zaidism.model.EmployeeProvider.getEmployeeList;

public class Filter {
  public static void main(String[] args) {

    List<Employee> employees = getEmployeeList();
    System.out.println("Employee with Even Employee ID's and salary greater than 50000.0 : ");
    employees.stream()
        .filter(e -> e.getId() % 2 == 0 && e.getSalary() > 60000)
        .toList()
        .forEach(System.out::println);

    // employees.forEach(System.out::println);

    System.out.println("*************************************************");

    List<Employee> employees1 = employees.stream().sorted().toList();
    employees1.forEach(e -> System.out.println(e));
    System.out.println("*************************************************");

    List<Employee> employees2 = employees.stream().sorted(Comparator.reverseOrder()).toList();
    System.out.println("*************************************************");

    employees2.forEach(System.out::println);
  }
}
