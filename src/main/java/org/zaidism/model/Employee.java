package org.zaidism.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee implements Comparable<Employee> {

  private int id;
  private String name;
  private LocalDate birthDate;
  private double salary;

  List<String> techStack = new ArrayList<>();

  public Employee() {}

  public Employee(int id, String name, LocalDate birthDate, double salary, List<String> techStack) {
    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
    this.salary = salary;
    this.techStack = techStack;
  }

  public Employee(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public double getSalary() {
    return salary;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public List<String> getTechStack() {
    return techStack;
  }

  public void setTechStack(List<String> techStack) {
    this.techStack = techStack;
  }

  @Override
  public int compareTo(Employee that) {
    return this.getId() - that.getId();
    // return this.getName().compareTo(that.getName());
  }

  @Override
  public String toString() {
    return "Employee{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", birthDate="
        + birthDate
        + ", salary="
        + salary
        + ", techStack="
        + techStack
        + '}';
  }
}
