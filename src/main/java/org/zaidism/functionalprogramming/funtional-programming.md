# Functional Interface

Refer to `FunctionalInterface.java`.

A functional interface is an interface that contains only one abstract method, and it can have multiple default or static methods. The introduction of functional interfaces played a crucial role in enabling the use of lambda expressions and functional programming concepts in Java.

The `@FunctionalInterface` annotation can be used to explicitly declare an interface as a functional interface, though it's not mandatory. The primary purpose of the annotation is to ensure that the interface follows the single abstract method (SAM) contract.

Some functional interfaces in Java are `Runnable`, `Callable`, `Comparator`, `Function`, `Predicate`, `Supplier`, and `Consumer`.

---

## Lambda Expression

- **Anonymous Functions:** Lambda expressions provide a way to create short, anonymous functions (also known as function literals or lambda functions).

- **Simplified Syntax:**
  - Syntax: `(parameters) -> expression` or `(parameters) -> { statements; }`
  - Parameters: Input parameters specified within parentheses.
  - Arrow (`->`): Separates parameters from the body of the lambda expression.
  - Expression/Statements: Code that represents the implementation.

- **Functional Interfaces:**
  - Lambda expressions are often used to implement single-method interfaces, known as functional interfaces.
  - Functional interfaces have only one abstract method, but they can have multiple default or static methods.

- **Example:**

    ```java
    @FunctionalInterface
    interface ReturnCalculator {
        double calculateReturn(double amount);
    }

    public class ReturnCalculatorExample {
        public static void main(String[] args) {
            // Using a lambda expression to implement the calculateReturn method
            ReturnCalculator simpleReturnCalculator = amount -> amount * 0.05; // 5% return

            // Example usage
            double investmentAmount = 1000.0;
            double calculatedReturn = simpleReturnCalculator.calculateReturn(investmentAmount);

            System.out.println("Investment Amount: $" + investmentAmount);
            System.out.println("Calculated Return: $" + calculatedReturn);
        }
    }
    ```

- **Conciseness and Readability:**
  - Lambda expressions reduce boilerplate code, making the code more concise and readable.
  - Especially beneficial when working with functional interfaces in the context of streams, `java.util.function` package, etc.

- **Common Use Cases:**
  - Used extensively with the Streams API for functional-style operations on collections.
  - Facilitates functional programming features by enabling the use of higher-order functions.

- **Functional Programming Concepts:**
  - Lambda expressions enable the adoption of functional programming concepts, allowing Java to express functional-style programming patterns.

In essence, lambda expressions in Java 8 provide a shorter and more expressive way to implement single-method interfaces, promoting cleaner and more functional programming practices.

---

## Method References

Method references allow us to refer to a method without invoking it, making our code cleaner and more readable. They can be used in place of a lambda expression when the lambda expression only calls an existing method.

---

## Default and Static Methods in Functional Interfaces

- Until Java 1.7, only public abstract methods were allowed inside interfaces, which basically means methods without a body.
- Since Java 8, we can have concrete methods inside interfaces.
- Any method inside an interface that has a body must be either static or default; otherwise, the compiler will give a compile-time error.
- Static methods can only be called by `interfaceName.staticMethodName()`.
- Default methods can't be called by `interfaceName.defaultMethodName()`.
- In order to provide backward compatibility, default methods were introduced.
- To call default methods in your class, it is mandatory to implement the functional interface in your class.
- We can't override static methods of a functional interface, but we can override default methods of a functional interface.

---

## Explanation About Optional

Refer to `OptionalDemo.java`.

- **Optional Usage:**
  - `Optional` is a container class that may or may not contain a non-null value.
  - It helps in avoiding null pointer exceptions by providing methods to handle the presence or absence of a value.

- **Handling Null Values:**
  - `Optional.of(value)` creates an `Optional` containing a non-null value.
  - `Optional.ofNullable(value)` creates an `Optional` that may contain a null value.

- **Handling Absence of Value:**
  - `isPresent()` checks if a value is present.
  - `ifPresent(Consumer)` executes a block of code only if a value is present.

- **Handling Default Values:**
  - `orElse(defaultValue)` returns the value if present, otherwise the provided default value.
  - `orElseGet(Supplier)` returns the value if present, otherwise evaluates and returns a default value.

- **Handling Exceptions:**
  - `orElseThrow(ExceptionSupplier)` returns the value if present, otherwise throws a specified exception.

- **Mapping Values:**
  - `map(Function)` transforms the value inside `Optional` if present.

Remember, `Optional` is not meant to be used everywhere and should be used judiciously, especially when dealing with methods that may return `null`.

---

## References

- [Comparable vs Comparator in Java](https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/)

---

## Intermediate Operations

Intermediate operations return another stream as a result. Examples include `filter`, `map`, `flatMap`, `distinct`, `sorted`, `limit`, `skip`, etc.

- **filter:** Based on condition (takes `Predicate` as input)
- **map:** Used to perform an operation on elements in the stream (takes `Function` as input)
- **skip:** Skips nth element from the stream
- **limit:** Limits the number of elements
- **sorted:** Takes `Comparator` as input
- **max:** Takes `Comparator` as input

## Terminal Operations

Terminal operations return non-stream values as a result, such as primitive, object, collection, or nothing. Examples include `forEach`, `toArray`, `reduce`, `collect`, `min`, `max`, `count`, `findFirst`, `findAny`, `allMatch`.

---

## Functional Interfaces

1. **Predicate:**
   - **Explanation:** Represents a boolean-valued function that takes one argument and returns true or false.
   - **Methods:**
     - `test(T t)`: Evaluates the predicate on the given argument.
   - **Uses:**
     - Filtering elements based on a given condition.
     - Checking whether an element satisfies a certain criterion.

2. **Function:**
   - **Explanation:** Represents a function that takes one argument and produces a result.
   - **Methods:**
     - `apply(T t)`: Applies the function to the given argument and produces a result.
   - **Uses:**
     - Transforming or mapping data from one type to another.
     - Performing calculations or computations on input data.

3. **Supplier:**
   - **Explanation:** Represents a supplier of results.
   - **Methods:**
     - `get()`: Retrieves a result.
   - **Uses:**
     - Providing values or objects without taking any input.
     - Delayed or lazy initialization of objects.

4. **Consumer:**
   - **Explanation:** Represents an operation that accepts a single input argument and returns no result.
   - **Methods:**
     - `accept(T t)`: Performs the operation on the given argument.
   - **Uses:**
     - Consuming or processing elements from a stream.
     - Performing side effects like printing, logging, or updating state.

These predefined functional interfaces were introduced in Java to facilitate functional programming paradigms, enabling developers to write more concise, expressive, and flexible code by treating functions as first-class citizens. They are commonly used in conjunction with streams, lambdas, and method references to perform various operations on data collections, such as filtering, mapping, reducing, and iterating, in a more functional and declarative style.

---

## BiFunction, BiPredicate, and BiConsumer

1. **BiFunction:**
   - **Explanation:** Represents a function that takes two arguments and produces a result.
   - **Methods:**
     - `apply(T t, U u)`: Applies the function to the given arguments and produces a result.
   - **Uses:**
     - Performing operations that involve two inputs and produce a result.
     - Combining or merging data from two sources.

2. **BiPredicate:**
   - **Explanation:** Represents a boolean-valued function that takes two arguments and returns true or false.
   - **Methods:**
     - `test(T t, U u)`: Evaluates the predicate on the given arguments.
   - **Uses:**
     - Testing conditions involving two input values.
     - Filtering elements based on a condition involving two attributes.

3. **BiConsumer:**
   - **Explanation:** Represents an operation that accepts two input arguments and returns no result.
   - **Methods:**
     - `accept(T t, U u)`: Performs the operation on the given arguments.
   - **Uses:**
     - Consuming or processing pairs of elements from a stream.
     - Performing side effects or actions that involve two inputs.

These interfaces were introduced to extend the functionality of their single-argument counterparts (`Function`, `Predicate`, and `Consumer`) to handle operations involving two input values. They provide flexibility and convenience in dealing with pairs of elements or attributes in various scenarios, such as data processing, validation, or transformation, in a functional programming paradigm.

---

## Collectors.partitioningBy

Refer to `PartitioningBy.java`.

`Collectors.partitioningBy` is a collector that partitions the elements of a stream into two groups based on a boolean condition. It takes a predicate as an argument, which evaluates to true or false for each element in the stream. It returns a `Map<Boolean, List<T

>>`, where the keys are true and false, and the values are lists of elements that satisfy the condition (true key) and elements that do not satisfy the condition (false key).
