package org.zaidism.functionalprogramming.customsorting;

import org.zaidism.model.Employee;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.zaidism.model.EmployeeProvider.getEmployeeList;
import static org.zaidism.model.EmployeeProvider.printEmployees;

public class CustomObjectSorting {

  public static void main(String[] args) {

      List<Employee> employees = getEmployeeList();


      // Using comparable
    Collections.sort(employees);
    printEmployees(employees, "Using comparable");

    // using comparator
    Comparator<Employee> nameComparator =
        new Comparator<Employee>() {
          @Override
          public int compare(Employee e1, Employee e2) {
            return e1.getName().compareTo(e2.getName());
          }
        };

    Collections.sort(employees, nameComparator);
    printEmployees(employees, "Using comparator");

    Comparator<Employee> birthDateComparator =
        new Comparator<Employee>() {
          public int compare(Employee e1, Employee e2) {
            return e1.getBirthDate().compareTo(e2.getBirthDate());
          }
        };

    Collections.sort(employees, birthDateComparator);
    printEmployees(employees, "Using comparator");

    // id comparator through lambda
    Comparator<Employee> IdComparator = (e1, e2) -> e1.getId() - e2.getId() ;
    Collections.sort(employees, IdComparator);
    printEmployees(employees, "Using comparator with lambda");

    // name comparator through lambda
    Comparator<Employee> dateComparator = (e1, e2) -> e1.getBirthDate().compareTo(e2.getBirthDate()); // java 8
     dateComparator = Comparator.comparing(Employee::getBirthDate); //java 11 onwards
    Collections.sort(employees, dateComparator);
    printEmployees(employees, "Using comparator with lambda");

    // multiple sorting criteria
    employees.stream()
        .sorted(
            Comparator.comparing(Employee::getId)
                .thenComparing(Employee::getName)
                .thenComparing(Employee::getSalary))
        .forEach(System.out::println);
  }

}
