# Facade Design Pattern – Shipment Processing System (FedEx Context)

---

# 1. Definition

The Facade Pattern is a structural design pattern that:

> Provides a simplified, unified interface to a complex subsystem.
> The Facade Pattern creates a unified interface that wraps a set of subsystems, making them easier to use without exposing their internal complexity.

It hides the complexity of multiple classes behind a single entry point.

In simple words:

Instead of interacting with many internal systems, the client talks to one simple class.

---

Perfect. Let’s keep it very simple and FedEx-related. No overengineering.

---

# 🚚 Simple Facade Example – FedEx Shipment Processing

Imagine processing a shipment requires:

1. Validate order
2. Calculate price
3. Generate label

That’s it. Very simple.

---

# ❌ Without Facade

## Subsystems

### Order Validation

```java
class OrderValidator {
    void validate(String orderId) {
        System.out.println("Validating order: " + orderId);
    }
}
```

### Pricing Service

```java
class PricingService {
    double calculate(double weight) {
        System.out.println("Calculating price...");
        return weight * 10;
    }
}
```

### Label Service

```java
class LabelService {
    void generate(String orderId) {
        System.out.println("Generating label for: " + orderId);
    }
}
```

---

## Client Code (Without Facade)

```java
public class WithoutFacadeDemo {

    public static void main(String[] args) {

        OrderValidator validator = new OrderValidator();
        PricingService pricing = new PricingService();
        LabelService labelService = new LabelService();

        String orderId = "FX-101";
        double weight = 5;

        validator.validate(orderId);
        double price = pricing.calculate(weight);
        labelService.generate(orderId);

        System.out.println("Total Price: " + price);
    }
}
```

### Problem

The client:

* Knows all services
* Knows the order of execution
* Is tightly coupled to multiple classes

If process changes, client must change.

---

# ✅ With Facade

Now we introduce one class that hides all this complexity.

---

## ShipmentFacade

```java
class ShipmentFacade {

    private OrderValidator validator = new OrderValidator();
    private PricingService pricing = new PricingService();
    private LabelService labelService = new LabelService();

    public void processShipment(String orderId, double weight) {

        validator.validate(orderId);
        double price = pricing.calculate(weight);
        labelService.generate(orderId);

        System.out.println("Total Price: " + price);
        System.out.println("Shipment processed successfully.");
    }
}
```

---

## Client Code (With Facade)

```java
public class WithFacadeDemo {

    public static void main(String[] args) {

        ShipmentFacade facade = new ShipmentFacade();
        facade.processShipment("FX-101", 5);
    }
}
```

---

# 🎯 What Changed?

Before:
Client handled everything.

After:
Client calls just:

```java
facade.processShipment(...)
```

Facade handles:

* Validation
* Pricing
* Label generation

Client doesn’t know internal details anymore.

---

# 🧠 In One Line

Facade gives you a simple interface to a complex set of operations.

Facade handles everything internally.

---

# 10. Final Summary

Facade Pattern provides:

* A simplified interface
* To a complex subsystem
* Without modifying the subsystem itself

It improves structure, readability, and maintainability.

It does NOT change behavior.
It only simplifies access.

