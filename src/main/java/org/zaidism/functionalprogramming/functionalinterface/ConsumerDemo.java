package org.zaidism.functionalprogramming.functionalinterface;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerDemo {
  public static void main(String[] args) {

    List<Integer> integers = List.of(1, 3, 2, 1, 3, 2);
    Consumer<List<Integer>> addHundredConsumer =
        list -> {
          for (int x : list) System.out.println(x + 100);
        };

    addHundredConsumer.accept(integers);
    System.out.println("____________________________________________");

    Consumer<List<Integer>> printConsumer =
        list -> {
          for (int x : list) System.out.println(x);
        };

    // one way of doing it
    printConsumer.andThen(addHundredConsumer).accept(integers);

    System.out.println("____________________________________________");
    // another way of doing the same thing as above
    Consumer<List<Integer>> listConsumer = printConsumer.andThen(addHundredConsumer);
    listConsumer.accept(integers);

    System.out.println("____________________________________________");
    BiConsumer<Integer, String> biConsumer = (a, b) -> System.out.println(a * b.hashCode());
    biConsumer.accept(23, "jahid");

    BiConsumer<Integer, Integer> biConsumer2 = (a, b) -> System.out.println(a + b);
    biConsumer2.accept(23, 7);
  }
}
