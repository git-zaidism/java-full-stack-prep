package org.zaidism.interviewprograms;

import java.util.Optional;

// predict the output
public class OptionalCode {
  public static void main(String[] args) {
    Optional<Integer> opt = Optional.of(5);
    System.out.println(opt.filter(x -> x > 10).orElseGet(() -> opt.get() + 5));
  }
}
