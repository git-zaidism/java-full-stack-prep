package org.zaidism.interviewprograms;

import java.util.List;
import java.util.stream.Stream;

public class FilterInteger {
  public static void main(String[] args) {
    List<Integer> integers = Stream.of(1, 101, 201, 121, 311, 41, 0).filter(i -> i.toString().charAt(0) == '1').toList();
    System.out.println(integers);
  }
}
