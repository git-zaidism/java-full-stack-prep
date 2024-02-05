package org.zaidism.interviewprograms;

import java.util.Arrays;
import java.util.List;

//predict the output
public class StreamQuestion {
  public static void main(String[] args) {
    final List<String> abc = Arrays.asList("a", "b", "c");
    abc.stream().forEach(a -> abc.add("p"));
    System.out.println(abc);
  }
}
