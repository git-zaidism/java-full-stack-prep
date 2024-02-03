package org.zaidism.functionalprogramming;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalDemo {
  public static void main(String[] args) {
    // null pointer
    String nameFromDB;
    Optional<String> nameFromDBWithOptional;
    nameFromDB = getNameFromDB();
    // System.out.println(nameFromDB.toUpperCase());

    // Null pointer exception if no value present
    // nameFromDBWithOptional = getNameFromDBWithOptionalOf();
    // System.out.println(nameFromDBWithOptional.get().toUpperCase());

    // Handle Null pointer exception if no value present way 1
    nameFromDBWithOptional = getNameFromDBWithOptionalOfNullable();
    if (nameFromDBWithOptional.isPresent())
      System.out.println(nameFromDBWithOptional.get().toUpperCase());

    // Handle Null pointer exception if no value present way 2
    nameFromDBWithOptional = getNameFromDBWithOptionalOfNullable();
    nameFromDBWithOptional.ifPresent(name -> System.out.println(name.toUpperCase()));

    // I want a default name if the name is not present from the nullable method way 1
    nameFromDBWithOptional = getNameFromDBWithOptionalOfNullableWithOrElse();
    String defaultName1 =
            nameFromDBWithOptional.orElse(
                    "default name"); // used when you have to return a default value
    System.out.println("Output from orElse method: " + defaultName1.toUpperCase());

    // this is used when you want fetch another name from db may be bigger operations as it takes supplier
    nameFromDBWithOptional = getNameFromDBWithOptionalOfNullableWithOrElse();
    String defaultName2 =
            nameFromDBWithOptional.orElseGet(() -> "default name from or else get");
    System.out.println("Output from orElseGet method: " + defaultName2.toUpperCase());

    nameFromDBWithOptional = getNameFromDBWithOptionalOfNullableWithOrElse();
    String defaultName3 = nameFromDBWithOptional.orElseThrow(() -> new NoSuchElementException());
    System.out.println("Output from orElseThrow method: " + defaultName3.toUpperCase());

    // We can also map the value inside optional
    nameFromDBWithOptional = getNameFromDBWithOptionalOf();
    Optional<String> optionalOfString = nameFromDBWithOptional.map(name -> name.toLowerCase());
    optionalOfString.ifPresent(System.out::println);
  }

  private static String getNameFromDB() {
    return null;
  }

  private static Optional<String> getNameFromDBWithOptionalOf() {
    String nameFromDB = "jahid"; // try with an actual value as well as with null
    return Optional.of(nameFromDB); // null pointer exception
  }

  private static Optional<String> getNameFromDBWithOptionalOfNullable() {
    String nameFromDB = null; // try with an actual value as well as with null
    return Optional.ofNullable(nameFromDB);
  }

  private static Optional<String> getNameFromDBWithOptionalOfNullableWithOrElse() {
    String nameFromDB = "jahid"; // try with an actual value as well as with null
    return Optional.ofNullable(nameFromDB); // you can return Optional.empty() also to return value
  }
}
