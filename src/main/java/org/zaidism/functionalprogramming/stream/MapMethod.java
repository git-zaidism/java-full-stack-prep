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
  }
}
