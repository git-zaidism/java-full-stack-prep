package org.zaidism.temp;

import org.zaidism.model.Employee;

import java.util.List;

import static org.zaidism.model.EmployeeProvider.getEmployeeList;

public class Main {
  public static void main(String[] args) {

    List<Employee> employees = getEmployeeList();

    System.out.println("");
  }
}
