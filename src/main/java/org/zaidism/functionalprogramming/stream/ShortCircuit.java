package org.zaidism.functionalprogramming.stream;

import org.zaidism.model.Employee;

import java.util.List;

import static org.zaidism.model.EmployeeProvider.getEmployeeList;
import static org.zaidism.model.EmployeeProvider.printEmployees;

public class ShortCircuit {
    public static void main(String[] args){
        List<Employee> employees = getEmployeeList();

        List<Employee> employeesAfterSkip = employees.stream().skip(1).toList();
        printEmployees(employeesAfterSkip, "Employee After Skip: ");


        List<Employee> employeesAfterLimit = employees.stream().limit(1).toList();
        printEmployees(employeesAfterLimit, "Employee After Limit: ");

        List<Employee> employeesAfterSkipAndLimit = employees.stream().skip(1).limit(1).toList();
        printEmployees(employeesAfterSkipAndLimit, "Employee After Skip and Limit: ");
    }
}

