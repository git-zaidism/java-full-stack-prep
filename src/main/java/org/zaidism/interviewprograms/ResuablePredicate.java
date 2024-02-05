package org.zaidism.interviewprograms;

import java.util.function.Predicate;

public class ResuablePredicate implements Predicate<String> {
  @Override
  public boolean test(String name) {
    return name.length() <= 10;
  }

  public static void main(String[] args) {
    System.out.println(new ResuablePredicate().test("Jahid"));
    System.out.println(new ResuablePredicate().test("Chinna Swami Muttu Swami VenGopal Ayyer"));

  }
}