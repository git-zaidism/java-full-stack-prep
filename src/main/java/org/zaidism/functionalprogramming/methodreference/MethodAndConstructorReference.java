package org.zaidism.functionalprogramming.methodreference;

import org.zaidism.model.Employee;

import java.util.List;


public class MethodAndConstructorReference {

  static int multiplyByTwo(int n) {
    return n * 2;
  }

  static void print(String name) {
    System.out.print(name.toUpperCase() + " ");
  }

  public static void main(String[] args) {
    // example 1 method reference
    List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    List<Integer> afterMultiply =
        integers.stream().map(MethodAndConstructorReference::multiplyByTwo).toList();
    System.out.println(afterMultiply);

    // example 2 method reference
    List<String> name = List.of("Amina", "Zahid", "Rahul", "Manoj");
    name.forEach(MethodAndConstructorReference::print);

    // constructor reference
    name.stream().map(Employee::new).toList().forEach(System.out::println);
  }
}
