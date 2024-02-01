package org.zaidism.model;

import java.time.LocalDate;

public class Employee implements Comparable<Employee> {

  private int id;
  private String name;
  private LocalDate birthDate;
  private double salary;

  public Employee(int id, String name, LocalDate birthDate, double salary) {
    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
    this.salary = salary;
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
        + '}';
  }

  @Override
  public int compareTo(Employee that) {
    return this.getId()  - that.getId();
    //return this.getName().compareTo(that.getName());
  }
}
