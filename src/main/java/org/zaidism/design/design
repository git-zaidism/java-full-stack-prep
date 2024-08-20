# The SOLID Principles

The broad goal of the SOLID principles is to reduce dependencies so that engineers can change one area of software without impacting others. Additionally, they're intended to make designs easier to understand, maintain, and extend. Ultimately, using these design principles makes it easier for software engineers to avoid issues and to build adaptive, effective, and agile software. They lead to better code for readability, maintainability, design patterns, and testability.

---

## 1. Single Responsibility Principle

The Single Responsibility Principle states that a class should have only one reason to change, meaning it should have only one responsibility.

**Example:**

Suppose we have a class `Employee` that manages employee data and also handles email notifications. This violates the SRP because it has two responsibilities: managing data and sending notifications.

---

## 2. Open-Closed Principle

Software components should be open for extension, but closed for modification.

```java
public class Employee {
    private int id;
    private String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class TrainedEmployees extends Employee {
    private String trainingAreas;

    TrainedEmployees(int id, String name, String trainingAreas) {
        super(id, name);
        this.trainingAreas = trainingAreas;
    }
}
```

---

## 3. Liskov’s Substitution Principle

The Liskov Substitution Principle essentially states that objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.

**Example:** `Liskov.java`

In this example, `Rectangle` and `Square` are subclasses of `Shape`. Both `Rectangle` and `Square` override the `calculateArea()` method to provide their own implementation of calculating the area. According to the LSP, instances of `Rectangle` and `Square` should be able to substitute instances of `Shape` wherever they are expected.

---

## 4. Interface Segregation Principle (Same as SRP but with Interfaces)

The Interface Segregation Principle is like the Single Responsibility Principle for interfaces. It focuses on keeping interfaces small and focused on specific tasks.

In simple terms, it says: "Don't make anyone use an interface with stuff they don't need."

It states that "Clients should not be forced to implement unnecessary methods which they will not use."

---

## 5. Dependency Inversion Principle

The Dependency Inversion Principle asserts that rather than real implementations, we should rely on abstractions (interfaces and abstract classes). Details should not be dependent on abstractions; rather, abstractions should be dependent on details.

---
