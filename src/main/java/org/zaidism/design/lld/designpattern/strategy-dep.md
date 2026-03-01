
# Strategy Pattern – Shipment Pricing Example (FedEx Context)

## 1. Definition

The Strategy Pattern is a behavioral design pattern that:

> The Strategy Design Pattern is a behavioral pattern that allows an object to choose from different algorithms or behaviors at runtime, rather than implementing a single one directly. It achieves this by defining a family of algorithms, encapsulating each one into separate classes, and making them interchangeable through a common interface.

In simple terms:

Instead of writing multiple `if-else` or `switch` statements, we move each algorithm into its own class and inject it into the context object.

---

# 2. Problem Without Strategy Pattern

Imagine we calculate shipment price like this:

```java
class ShipmentService {

    public double calculate(String type, double weight) {

        if (type.equals("FXE")) {              // Express
            return weight * 9;
        } else if (type.equals("FXG")) {       // Ground
            return weight * 5;
        } else {
            return 0;
        }
    }
}
````

## Problems:

* Adding a new shipment type requires modifying this class.
* Violates Open/Closed Principle.
* Large `if-else` chains over time.
* Hard to test each pricing logic separately.
* Business logic tightly coupled.

If tomorrow FedEx introduces International shipment, you must modify this method again.

---

# 3. Strategy Pattern Structure

Strategy pattern has three parts:

1. Strategy Interface – Common contract for algorithms.
2. Concrete Strategies – Different implementations of the algorithm.
3. Context – Uses the strategy but does not know its details.

---

# 4. Complete Code – Strategy Pattern Implementation

## Step 1: Strategy Interface

```java
package org.zaidism.design.lld.strategy;

public interface ShipmentPriceCalculator {
    double calculate(double shipmentWeight);
}
```

---

## Step 2: Concrete Strategies

### Express Shipment (FXE)

```java
package org.zaidism.design.lld.strategy;

public class FXEShipment implements ShipmentPriceCalculator {

    @Override
    public double calculate(double shipmentWeight) {
        return shipmentWeight * 9;
    }
}
```

### Ground Shipment (FXG)

```java
package org.zaidism.design.lld.strategy;

public class FXGShipment implements ShipmentPriceCalculator {

    @Override
    public double calculate(double shipmentWeight) {
        return shipmentWeight * 5;
    }
}
```

### International Shipment (New Strategy)

```java
package org.zaidism.design.lld.strategy;

public class FXInternationalShipment implements ShipmentPriceCalculator {

    @Override
    public double calculate(double shipmentWeight) {
        return shipmentWeight * 15;
    }
}
```

Notice: We added a new pricing logic without modifying existing code.

---

## Step 3: Context Class

```java
package org.zaidism.design.lld.strategy;

public class Shipment {

    private double weight;
    private ShipmentPriceCalculator priceCalculator;

    public Shipment(double weight, ShipmentPriceCalculator priceCalculator) {
        this.weight = weight;
        this.priceCalculator = priceCalculator;
    }

    public double calculatePrice() {
        return priceCalculator.calculate(weight);
    }
}
```

Important:

Shipment does not know:

* Whether it's Express
* Whether it's Ground
* Whether it's International

It only delegates pricing to the injected strategy.

---

## Step 4: Client Code

```java
package org.zaidism.design.lld.strategy;

public class StrategyDemo {

    public static void main(String[] args) {

        // in real world code the objects can be return from factory design pattern
        Shipment expressShipment =
                new Shipment(12, new FXEShipment());

        Shipment groundShipment =
                new Shipment(10, new FXGShipment());

        Shipment internationalShipment =
                new Shipment(20, new FXInternationalShipment());

        System.out.println("Express Cost: " + expressShipment.calculatePrice());
        System.out.println("Ground Cost: " + groundShipment.calculatePrice());
        System.out.println("International Cost: " + internationalShipment.calculatePrice());
    }
}
```

---

# 5. How This Solves the Problem

Before Strategy:

* Shipment class decides which algorithm to use.
* Every new type requires modifying existing code.

After Strategy:

* Each pricing logic is isolated.
* New strategies can be added without touching existing classes.
* Follows Open/Closed Principle.

---

# 6. Real FedEx Analogy

Think of pricing engines:

* Domestic Pricing Engine
* Express Pricing Engine
* International Pricing Engine
* Holiday Surge Pricing Engine

Shipment does not calculate pricing itself.

It delegates to whichever pricing engine is injected.

---

# 7. Advantages

1. Follows Open/Closed Principle
   New pricing rules can be added without modifying existing code.

2. Eliminates if-else chains
   Cleaner, more readable design.

3. Better Testing
   Each pricing strategy can be unit tested independently.

4. Runtime Flexibility
   You can switch strategies dynamically.

5. Clear Separation of Concerns
   Shipment manages shipment data.
   Pricing strategies manage pricing logic.

---

# 8. Disadvantages

1. Increased Number of Classes
   Every new algorithm requires a new class.

2. Slightly More Complex Structure
   For very simple logic, Strategy may feel like overengineering.

3. Client Must Know Which Strategy to Use
   Often solved using Factory Pattern.

---

# 9. When To Use Strategy Pattern

Use Strategy when:

* You have multiple variations of an algorithm.
* You want to remove large conditional statements.
* You want runtime behavior switching.
* You want clean adherence to SOLID principles.
* You expect frequent addition of new business rules.

---

# 10. Key Takeaway

Strategy Pattern separates:

* The algorithm (pricing logic)
* From the object that uses it (Shipment)

This makes the system flexible, extendable, and maintainable.

In one line:

Strategy allows you to change the behavior of an object at runtime without modifying the object itself.

```
