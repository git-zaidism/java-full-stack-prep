# The SOLID Principles

The broad goal of the SOLID principles is to reduce dependencies so that engineers can change one area of software without impacting others. Additionally, they're intended to make designs easier to understand, maintain, and extend. Ultimately, using these design principles makes it easier for software engineers to avoid issues and to build adaptive, effective, and agile software. They lead to better code for readability, maintainability, design patterns, and testability.

---

## 1. Single Responsibility Principle

The Single Responsibility Principle states that a class should have only one reason to change, meaning it should have only one responsibility.
The Single Responsibility Principle is important because it ensures a class has only one reason to change. This reduces complexity, makes the code easier to understand and test, and prevents unrelated changes from impacting each other. When responsibilities are clearly separated, the system becomes more maintainable, flexible, and less prone to bugs.

**Example:**

Suppose we have a class `Employee` that manages employee data and also handles email notifications. This violates the SRP because it has two responsibilities: managing data and sending notifications.

---

## 2. Open-Closed Principle

Software components should be open for extension, but closed for modification.
The Open–Closed Principle is important because it allows systems to grow by adding new functionality without modifying existing, stable code. This reduces regression risk, improves maintainability, and makes the codebase easier to scale in team environments. Instead of changing tested logic, we extend behavior through new implementations, which keeps the system stable and flexible.
---

## 3. Liskov’s Substitution Principle

The Liskov Substitution Principle ensures that objects of a superclass should be replaceable with objects of its subclasses without breaking the application or altering expected behavior. It protects correctness and reliability by maintaining consistent contracts across inheritance hierarchies. This prevents surprising bugs when polymorphism is used.

---

## 4. Interface Segregation Principle (Same as SRP but with Interfaces)

The Interface Segregation Principle is like the Single Responsibility Principle for interfaces. It focuses on keeping interfaces small and focused on specific tasks.

In simple terms, it says: "Don't make anyone use an interface with stuff they don't need."

It states that "Clients should not be forced to implement unnecessary methods which they will not use."

---

## 5. Dependency Inversion Principle

The Dependency Inversion Principle asserts that rather than real implementations, we should rely on abstractions (interfaces and abstract classes). Details should not be dependent on abstractions; rather, abstractions should be dependent on details.
The Dependency Inversion Principle ensures that high-level modules depend on abstractions rather than concrete implementations. This reduces tight coupling, improves flexibility, and makes systems easier to test, extend, and maintain.
---

## Playlists:

➡️ [LLD](https://lnkd.in/dJkgzKxf) (some videos are in Hindi, rest in English)

➡️ [HLD](https://lnkd.in/d8eDwYVA) (some videos are in Hindi, rest in English)

➡️ [Spring Boot](https://lnkd.in/gz2A5ih2) (All videos are in English)

---
