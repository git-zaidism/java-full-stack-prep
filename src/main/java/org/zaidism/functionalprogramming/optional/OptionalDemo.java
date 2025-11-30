package org.zaidism.functionalprogramming.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalDemo {
  public static void main(String[] args) {
    // Scenario 1: Null pointer
    String nameFromDB;
    Optional<String> nameFromDBWithOptional;
    nameFromDB = getNameFromDB();

    // Uncommenting the line below would result in a null pointer exception
    // System.out.println(nameFromDB.toUpperCase());

    // Scenario 2: Handling Null pointer exception if no value present - Way 1
    nameFromDBWithOptional = getNameFromDBWithOptionalOfNullable();
    if (nameFromDBWithOptional.isPresent())
      System.out.println(nameFromDBWithOptional.get().toUpperCase());

    // Scenario 3: Handling Null pointer exception if no value present - Way 2
    nameFromDBWithOptional = getNameFromDBWithOptionalOfNullable();
    nameFromDBWithOptional.ifPresent(name -> System.out.println(name.toUpperCase()));

    // Scenario 4: Providing a default name if the name is not present - Way 1
    nameFromDBWithOptional = getNameFromDBWithOptionalOfNullableWithOrElse();
    String defaultName1 = nameFromDBWithOptional.orElse("default name");
    System.out.println("Output from orElse method: " + defaultName1.toUpperCase());

    // Scenario 5: Providing a default name if the name is not present - Way 2
    nameFromDBWithOptional = getNameFromDBWithOptionalOfNullableWithOrElse();
    String defaultName2 = nameFromDBWithOptional.orElseGet(() ->"default name from or else get");
    System.out.println("Output from orElseGet method: " + defaultName2.toUpperCase());

    // Scenario 6: Providing a default name if the name is not present - Way 3
    nameFromDBWithOptional = getNameFromDBWithOptionalOfNullableWithOrElse();
    String defaultName3 = nameFromDBWithOptional.orElseThrow(() -> new NoSuchElementException());
    System.out.println("Output from orElseThrow method: " + defaultName3.toUpperCase());

    // Scenario 7: Mapping the value inside optional
    nameFromDBWithOptional = getNameFromDBWithOptionalOf();
    Optional<String> optionalOfString = nameFromDBWithOptional.map(name -> name.toLowerCase());
    optionalOfString.ifPresent(System.out::println);
  }

  // Method to simulate fetching name from database (returns null)
  private static String getNameFromDB() {
    return null;
  }

  // Method to fetch name from database using Optional.of
  private static Optional<String> getNameFromDBWithOptionalOf() {
    String nameFromDB = "jahid"; // try with an actual value as well as with null
    return Optional.of(nameFromDB); // null pointer exception if nameFromDB is null
  }

  // Method to fetch name from database using Optional.ofNullable
  private static Optional<String> getNameFromDBWithOptionalOfNullable() {
    String nameFromDB = null; // try with an actual value as well as with null
    return Optional.ofNullable(nameFromDB);
  }

  // Method to fetch name from database using Optional.ofNullable with orElse
  private static Optional<String> getNameFromDBWithOptionalOfNullableWithOrElse() {
    String nameFromDB = "jahid"; // try with an actual value as well as with null
    return Optional.ofNullable(nameFromDB); // you can return Optional.empty() also to return value
  }
}
