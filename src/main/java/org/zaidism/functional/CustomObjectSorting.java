package org.zaidism.functional;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.zaidism.model.Employee;

public class CustomObjectSorting {

  public static void main(String[] args) {

      List<Employee> employees = getEmployeeList();


      // Using comparable
    Collections.sort(employees);
    printEmployees(employees);

    // using comparator
    Comparator<Employee> nameComparator =
        new Comparator<Employee>() {
          @Override
          public int compare(Employee e1, Employee e2) {
            return e1.getName().compareTo(e2.getName());
          }
        };

    Collections.sort(employees, nameComparator);
    printEmployees(employees);

    Comparator<Employee> birthDateComparator =
        new Comparator<Employee>() {
          public int compare(Employee e1, Employee e2) {
            return e1.getBirthDate().compareTo(e2.getBirthDate());
          }
        };

    Collections.sort(employees, birthDateComparator);
    printEmployees(employees);

    // id comparator through lambda
    Comparator<Employee> IdComparator = (e1, e2) -> e1.getId() > e2.getId() ? 1 : -1;
    Collections.sort(employees, IdComparator);
    printEmployees(employees);

    // name comparator through lambda
    Comparator<Employee> dateComparator = (e1, e2) -> e1.getBirthDate().compareTo(e2.getBirthDate()); // java 8
     // dateComparator = Comparator.comparing(Employee::getBirthDate); //java 11 onwards
    Collections.sort(employees, dateComparator);
    printEmployees(employees);
  }

     public static List<Employee> getEmployeeList() {
        List<Employee> employees =
            Arrays.asList(
                new Employee(10, "Alice", LocalDate.of(1990, 5, 15), 50000.0),
                new Employee(2, "Ella", LocalDate.of(1985, 8, 22), 60000.0),
                new Employee(33, "Zahid", LocalDate.of(1992, 3, 7), 55000.0),
                new Employee(14, "David", LocalDate.of(1988, 11, 30), 70000.0),
                new Employee(2, "Eva", LocalDate.of(1995, 2, 18), 48000.0),
                new Employee(10, "Rahul", LocalDate.of(1990, 5, 15), 50000.0));
        return employees;
    }

    static void printEmployees(List<Employee> employees) {
    for (Employee employee : employees) {
      System.out.println(employee);
    }
    System.out.println(
        "----------------------------------------------------------------------------------------");
  }
}
