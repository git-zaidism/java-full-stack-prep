package org.zaidism.functionalprogramming.functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateDemo {
  public static void main(String[] args) {
    Predicate<String> nameLengthCheck = s -> s.length() <= 5 && s.contains("s");
    System.out.println(nameLengthCheck.test("Jshid"));

    Predicate<Integer> evenCheck = num -> num % 2 == 0;
    Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter(evenCheck).forEach(System.out::print);

    Predicate<String> nameCheck = s -> s.toLowerCase().charAt(0) == 'a';
    System.out.println(nameCheck.test("amina"));

    // some extra functionalities of predicate
    Predicate<String> andPredicate =
        nameCheck.and(nameLengthCheck); // can be achieved using && operator
    Predicate<String> orPredicate =
        nameCheck.or(nameLengthCheck); // can be achived using || operator
    Predicate<Integer> negatePredicate =
        evenCheck.negate(); // can be achiveed ! in existing predicate

    // is equal method of predicate for all data type
    Predicate<Integer> equalPredicateForInteger = Predicate.isEqual(2);
    System.out.println(equalPredicateForInteger.test(2));
    System.out.println(equalPredicateForInteger.test(22));

    Predicate<String> equalPredicateForString = Predicate.isEqual("Jahid");
    System.out.println(equalPredicateForString.test("Jahid"));
    System.out.println(equalPredicateForString.test("jahid"));
    System.out.println("____________________________________________");

    BiPredicate<Integer, Integer> evenChecks = (x, y) -> x % 2 == 0 && y % 2 == 0;
    System.out.println(evenChecks.test(4, 8));

    BiPredicate<String, Integer> strCheck = (str, length) -> str.length() == length;
    System.out.println(strCheck.test("Jahid", 4));
  }
}
