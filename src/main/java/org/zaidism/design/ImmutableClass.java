package org.zaidism.design;

import org.zaidism.model.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class ImmutableClass {

  private final int id;
  private final List<String> subject; // collection object immutability

  private Employee employee; // custom object immutable

  public ImmutableClass(int id, List<String> subject) {
    this.id = id;
    this.subject = new ArrayList<>(subject);
  }

  public ImmutableClass(int id, List<String> subject, Employee employee) {
    this.id = id;
    this.subject = subject;
    this.employee = employee;
  }

  public int getId() {
    return id;
  }

  public List<String> getSubject() {
    return new ArrayList<>(subject);
    // return Collections.unmodifiableList(subject);
  }

  public Employee getEmployee() {
    return new Employee(
        employee.getId(),
        employee.getName(),
        employee.getBirthDate(),
        employee.getSalary(),
        employee.getTechStack());
  }

  @Override
  public String toString() {
    return "ImmutableClass{" + "id=" + id + ", subject=" + subject + ", employee=" + employee + '}';
  }
}

class ImmutableTest {
  public static void main(String[] args) {
    List<String> subject = new ArrayList<>();
    subject.add("subject1");
    ImmutableClass immutableClass1 = new ImmutableClass(1, subject);
    immutableClass1.getSubject().add("rr");
    System.out.println(immutableClass1);

    Employee employee = new Employee(21, "Jahid", LocalDate.now(), 600000L, List.of("Java"));
    ImmutableClass immutableClass2 = new ImmutableClass(1, subject, employee);
    immutableClass2.getEmployee().setId(2000);
    System.out.println(immutableClass2);
  }
}
