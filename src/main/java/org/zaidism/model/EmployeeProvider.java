package org.zaidism.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeProvider {

    public static List<Employee> getEmployeeList() {
        return Arrays.asList(
                new Employee(1, "John", LocalDate.of(1990, 1, 1), 50000.0, Arrays.asList("Java", "Spring")),
                new Employee(2, "Jahid", LocalDate.of(1985, 2, 2), 60000.0, Arrays.asList("JavaScript", "React")),
                new Employee(3, "Zack", LocalDate.of(1992, 3, 3), 55000.0, Arrays.asList("Python", "Django")),
                new Employee(4, "David", LocalDate.of(1988, 4, 4), 70000.0, Arrays.asList("C#", ".NET")),
                new Employee(5, "Emily", LocalDate.of(1995, 5, 5), 48000.0, Arrays.asList("Ruby", "Rails")),
                new Employee(16, "Sophie", LocalDate.of(1989, 11, 11), 55000.0, Arrays.asList("JavaScript", "Vue.js")),
                new Employee(17, "Ethan", LocalDate.of(1993, 12, 12), 60000.0, Arrays.asList("Java", "Hibernate")),
                new Employee(18, "Isabella", LocalDate.of(1991, 1, 13), 52000.0, Arrays.asList("Node.js", "MongoDB")),
                new Employee(2, "Jahid", LocalDate.of(1985, 2, 2), 65000.0, Arrays.asList(".NET", "SQL")),
                new Employee(20, "Emily", LocalDate.of(1994, 3, 15), 48000.0, Arrays.asList("Python", "Flask"))
        );
    }

    public static void printEmployees(List<Employee> employees , String message) {
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println(message);
        for (Employee employee : employees)
            System.out.println(employee);

        System.out.println("----------------------------------------------------------------------------------------");
    }

    public static void printSeparation() {
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println();
    }
}
