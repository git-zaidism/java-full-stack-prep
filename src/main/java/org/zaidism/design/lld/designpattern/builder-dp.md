
# Builder Pattern – Employee Example

## Overview

The Builder Pattern is a creational design pattern used to construct complex objects step by step.  
It helps when:

- An object has many fields
- Some fields are optional
- Some fields must not change after creation (immutability)
- Constructor overloading becomes messy
- Backward compatibility is important

This document explains the problem and how the Builder Pattern solves it using the `Employee` example.

---

# The Problem Without Builder Pattern

Imagine an `Employee` class with these attributes:

- `name`
- `address`
- `id`
- `gender` (cannot change after creation)

## 1. Immutability Problem

If we expose setters:

```java
employee.setGender("MALE");
employee.setGender("FEMALE"); // ❌ Should not be allowed
````

Some attributes should never change once the object is created.
Public setters break immutability.

---

## 2. Constructor Overloading Explosion

If we use constructors instead:

```java
Employee(String name)
Employee(String name, String address)
Employee(String name, String address, String id)
Employee(String name, String address, String id, String gender)
```

As fields increase, constructors grow exponentially (2ⁿ combinations).

This leads to:

* Hard-to-maintain code
* Duplication
* Confusion
* Increased bug risk

This is often called the **Telescoping Constructor Problem**.

---

## 3. Parameter Order Confusion

Constructors depend on strict parameter ordering:

```java
new Employee("Zahid", "Address 1", "123", "MALE");
```

If order changes accidentally:

```java
new Employee("Address 1", "Zahid", "123", "MALE"); // ❌ Logical bug
```

The compiler may not catch it if types are same.

---

## 4. Backward Compatibility Problem

Suppose later we add:

```java
private String department;
```

Now all constructors must change.

Every client code that uses those constructors breaks.

In large systems, this is dangerous and costly.

---

# How Builder Pattern Solves These Problems

The Builder Pattern introduces an intermediate object responsible for constructing the final object.

Instead of:

```java
new Employee(...)
```

We use:

```java
new Employee.EmployeeBuilder()
    .setName("Zahid")
    .setAddress("Address 1")
    .setId("123")
    .setGender("MALE")
    .build();
```

---

# Benefits in This Example

## 1. Enforces Immutability

* All fields in `Employee` are `final`
* No public setters
* Values are assigned only once through the constructor
* After creation, object state cannot change

---

## 2. Eliminates Constructor Overloading

We only need one constructor:

```java
Employee(EmployeeBuilder builder)
```

No explosion of multiple constructors.

---

## 3. Removes Parameter Order Dependency

Each field is explicitly named:

```java
.setName("Zahid")
.setAddress("Address 1")
```

Order does not matter.

Readable and safe.

---

## 4. Improves Backward Compatibility

If we add a new field later:

* Add it to `Employee`
* Add setter in `EmployeeBuilder`

Old client code continues to work.

No breaking changes.

---

## 5. Clean and Expressive Code

The method chaining style:

```java
.setName(...)
.setAddress(...)
.setId(...)
```

is called a **Fluent Interface**.

It makes object construction readable and self-documenting.

---

# Complete Code Example

## Employee Class

```java
class Employee {

    private final String name;
    private final String address;
    private final String id;
    private final String gender;

    private Employee(EmployeeBuilder employeeBuilder) {
        this.name = employeeBuilder.name;
        this.address = employeeBuilder.address;
        this.id = employeeBuilder.id;
        this.gender = employeeBuilder.gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    static class EmployeeBuilder {

        private String name;
        private String address;
        private String id;
        private String gender;

        public EmployeeBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public EmployeeBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
```

---

## Client Code

```java
public class BuilderDesign {

    public static void main(String[] args) {

        Employee employee1 = new Employee.EmployeeBuilder()
                .setAddress("Address 1")
                .setGender("MALE")
                .setName("Zahid")
                .setId("lsdnlndnj2w")
                .build();

        Employee employee2 = new Employee.EmployeeBuilder()
                .setAddress("Address 1")
                .setName("Ram")
                .build();

        System.out.println(employee1);
        System.out.println(employee2);
    }
}
```

---

# The Core Idea

The Builder Pattern separates:

* **Object construction logic**
* **Object representation**

This gives:

* Immutability
* Flexibility
* Cleaner client code
* Backward compatibility
* Better maintainability

---

# When to Use Builder Pattern

Use it when:

* A class has many optional parameters
* You want immutable objects
* Constructor overloading becomes messy
* You want readable object creation
* You care about long-term maintainability

---

# Conclusion

The Builder Pattern solves:

* Setter misuse problems
* Constructor overloading explosion
* Parameter ordering bugs
* Backward compatibility issues
* Dirty and unreadable object creation

It makes object construction safe, expressive, and future-proof.


