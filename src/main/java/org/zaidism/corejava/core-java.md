# What is a Marker Interface and Its Significance?

In Java, a marker interface is an interface with no methods, also known as a tag or flag interface. The purpose of a marker interface is to mark a class as having a particular property or special characteristic to JVM. This marking is done implicitly by implementing the marker interface.

Marker interfaces are used to indicate certain behavior or capabilities of classes without specifying the details.

Two well-known marker interfaces in Java are `Serializable` and `Cloneable`.

## Example: `SerializableExample.java` and `CloneableExample.java`

Let's break down why `private static final long serialVersionUID = 1L;` is used in `Serializable` and why the `clone` method is used in:

### 1. `serialVersionUID` for Serializable:

- When a class implements `Serializable`, Java automatically generates a unique identifier for the class known as the `serialVersionUID`. This identifier is used during the serialization and deserialization process to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization.

- If you don't explicitly declare a `serialVersionUID`, the Java runtime system will generate one based on the class structure. However, it's considered good practice to provide an explicit `serialVersionUID` to have control over the versioning of your classes.

- Here, `1L` is an arbitrary value, and you may choose different values based on your versioning strategy. If you don't add new fields/variables to the class, you might keep the `serialVersionUID` unchanged. If you add new fields/variables to the class, you can increment the `serialVersionUID` from `1L` to `2L` as per good practice.

- If you keep the `serialVersionUID` unchanged (e.g., `serialVersionUID = 1L`) even after adding new fields to the class, it can lead to versioning issues during the process of serialization and deserialization.

- If you keep the `serialVersionUID` unchanged, you might face issues like deserialization failure; after deserialization, you might not get new fields added in class in the source file.

- In summary, keeping the `serialVersionUID` unchanged while making incompatible changes to the class (such as adding new fields) is generally not recommended. It's essential to increment the `serialVersionUID` whenever there are structural changes to the class to indicate versioning and maintain compatibility. By doing so, you have better control over the serialization and deserialization process, ensuring that the class versions are recognized as compatible.

### 2. `clone` Method:

- The `clone` method is declared in the `Object` class, and when you override it in your class, using `@Override` ensures that you are correctly overriding the method. It's a good practice to include this annotation to make your code more robust and easier to maintain.

- The `clone` method is declared in the `Cloneable` interface, and it's used to create a copy of the object. By convention, the `clone` method in your class should call `super.clone()` to leverage the default implementation provided by the `Object` class. However, it's important to note that proper cloning may involve more considerations, especially for deep cloning of objects with complex structures.

---

# `hashCode()` and `equals()` Method

- `hashCode()` and `equals()` methods have been defined in the `Object` class, which is the parent of all Java objects. For this reason, all Java objects inherit the default implementation of these methods, but we can override the implementation of these methods.

- When you create two objects with the same content (refer to example `HashCodeAndEquals.java`), and print them, the default value (class name + hexadecimal value) of them will be different as those two objects are created at different places in memory.

- The `equals()` method is checking internally if both the objects are referring to the same object, so by default, both `==` and `equals` will give a false result for equality of objects in our example.

- To define our own logic to determine when objects are equal or not, we need to override the `equals` method inside the class. After overriding the `equals` method, there is still a problem: you can still add these two similar or non-similar objects in a `HashSet`. For similar objects, ideally, it should not happen as a set always contains unique values. The same identical object can be used as a `HashMap` key.

- To resolve this, Java documentation recommends overriding the `hashCode()` method whenever `equals()` is overridden. Additionally, both methods should utilize the same fields (e.g., price and color).

- Once you override the `hashCode` method, there will only be one entry added in the `HashSet`, and without `hashCode`, there will be two entries for identical objects. This is because while creating `hashCode`, we use the same values for both objects for generating the hash code, meaning the generated hash code will always be the same for two identical objects. You can verify this by running the code without the `toString` method.

## `hashCode()` and `equals()` Contract:

- If two objects are equal, they must have the same hash code.
- If two objects have the same hash code, they may or may not be equal.

---

# Cloning: Shallow vs Deep

In Java, cloning refers to creating a copy of an object. There are two main types of cloning: shallow cloning and deep cloning. Let's explain each with clear, easy-to-understand language and code examples: `CloningTechniques.java`

### Shallow Cloning:

- **Description:** Shallow cloning creates a new object and copies all the fields of the original object to the new object. However, if the fields of the original object are references to other objects, shallow cloning only copies the references, not the actual objects. As a result, both the original object and the cloned object share references to the same objects. Changes made to the shared objects through one object will affect the other object as well.

  In your `shallowClone` method, you clone the `Person` object using the default `clone()` method, which performs shallow cloning. This means that the `address` field in both the original `Person` object and the shallow cloned `Person` object points to the same `Address` object in memory. As a result, changes made to the `address` field in the shallow cloned `Person` object will affect the original `Person` object as well.

### Deep Cloning:

- **Description:** Deep cloning creates a

 new object and recursively copies all fields of the original object, including any objects referenced by the fields. This means that all objects within the original object hierarchy are duplicated. As a result, the cloned object and the original object are entirely independent of each other, and changes made to one object won't affect the other.

---

# Exception Handling in Java

## Practical use of finally block

- Finally can be practically used in a code where we create connection to db and then perform insert/update/delete and if any exception occurs then it should go to catch block and after that we always want to close the db connection that code can be implemented inside finally block.

- System.exit can stop finally block execution.

---

## Exception hierarchy in Java

```
          Object
            |
         Throwable
            |
      ----------------
     |                |
   Error          Exception
     |                |
  --------           ---------------------------------------------------------------
 OutOfMemoryError                      |                                           |
 StackOverflow                      Checked (Exception class)                     Unchecked (RuntimeException)
 (Unchecked)                         |                                                    |
                              -------------                                          ----------------
                             |    IO      |                                          |    Runtime     |
                             |  Exceptions |                                         |   Exceptions   |
                             |(e.g., IOException |                   (e.g., NullPointerException, ArrayIndexOutOfBound, ArithmeticException)
                              SQLException
                              FileNotFoundException)
```

### Key Points:

- `Throwable` is at the top of the hierarchy, acting as the root class after Object.
- `Error` and `Exception` are the main branches.
- `Error` represents severe issues that typically cannot be recovered from caused due to lack of resources.
- `Exception` is further divided into `Checked Exceptions` and `Unchecked Exceptions`.
