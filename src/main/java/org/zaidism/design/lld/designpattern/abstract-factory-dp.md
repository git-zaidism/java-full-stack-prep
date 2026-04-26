
# Abstract Factory Design Pattern – FedEx Shipping Example

---

# 1. Simple Definition

The Abstract Factory Pattern is a creational design pattern that:

> Provides an interface to create families of related objects without specifying their concrete classes.

In simple words:

Instead of creating objects directly, you create them through a factory.  
And instead of one factory, you have multiple factories for different "families" of objects.

---

# Factory vs Abstract Factory (FedEx Example)

---

# 1. Simple Difference in One Line

Factory Pattern:
Creates one type of product.

Abstract Factory Pattern:
Creates families of related products

# 2. Real FedEx Scenario

Imagine FedEx operates in:

- Domestic region
- International region

Each region needs:

- Pricing Service
- Label Service

Domestic and International versions are different.

Now we must ensure:

If we use Domestic pricing → we must also use Domestic label  
If we use International pricing → we must also use International label  

They belong to the same "family".

That’s where Abstract Factory helps.

---

# 3. Problem Without Abstract Factory

Without it, you might do:

```java
PricingService pricing = new DomesticPricing();
LabelService label = new InternationalLabel(); // ❌ wrong combination
````

Now pricing and label belong to different regions.

This creates inconsistent object combinations.

---

# 4. Solution – Abstract Factory Pattern

We group related objects into a family.

Each factory creates matching objects.

---

# Step 1: Create Product Interfaces

```java
interface PricingService {
    double calculate(double weight);
}
```

```java
interface LabelService {
    void generateLabel(String orderId);
}
```

---

# Step 2: Create Concrete Products

## Domestic Implementations

```java
class DomesticPricing implements PricingService {

    @Override
    public double calculate(double weight) {
        return weight * 5;
    }
}
```

```java
class DomesticLabel implements LabelService {

    @Override
    public void generateLabel(String orderId) {
        System.out.println("Generating Domestic Label for " + orderId);
    }
}
```

---

## International Implementations

```java
class InternationalPricing implements PricingService {

    @Override
    public double calculate(double weight) {
        return weight * 15;
    }
}
```

```java
class InternationalLabel implements LabelService {

    @Override
    public void generateLabel(String orderId) {
        System.out.println("Generating International Label for " + orderId);
    }
}
```

---

# Step 3: Create Abstract Factory Interface

```java
interface ShipmentFactory {
    PricingService createPricingService();
    LabelService createLabelService();
}
```

This ensures related objects are created together.

---

# Step 4: Create Concrete Factories

## Domestic Factory

```java
class DomesticShipmentFactory implements ShipmentFactory {

    @Override
    public PricingService createPricingService() {
        return new DomesticPricing();
    }

    @Override
    public LabelService createLabelService() {
        return new DomesticLabel();
    }
}
```

---

## International Factory

```java
class InternationalShipmentFactory implements ShipmentFactory {

    @Override
    public PricingService createPricingService() {
        return new InternationalPricing();
    }

    @Override
    public LabelService createLabelService() {
        return new InternationalLabel();
    }
}
```

---

# Step 5: Client Code

```java
public class AbstractFactoryDemo {

    public static void main(String[] args) {

        ShipmentFactory factory = new DomesticShipmentFactory();

        PricingService pricing = factory.createPricingService();
        LabelService label = factory.createLabelService();

        double price = pricing.calculate(10);
        label.generateLabel("FX-101");

        System.out.println("Total Price: " + price);
    }
}
```

If you switch to:

```java
ShipmentFactory factory = new InternationalShipmentFactory();
```

Everything changes consistently.

No wrong combinations possible.

---

# 5. What Problem Does It Solve?

Abstract Factory ensures:

* Related objects are created together.
* Families of objects stay consistent.
* Client does not depend on concrete classes.
* System follows Open/Closed Principle.

---

# 6. When To Use It

Use Abstract Factory when:

* You have multiple families of related objects.
* Objects must be used together.
* You want to enforce consistency.
* You want to switch entire configurations at once.

---

# 7. Advantages

1. Ensures object consistency.
2. Promotes loose coupling.
3. Follows Open/Closed Principle.
4. Makes switching environments easy.
5. Centralizes object creation logic.

---

# 8. Disadvantages

1. Adds more classes.
2. Can become complex for small systems.
3. Adding a new product type requires modifying all factories.
4. Overkill if you only have one product family.

---

# 9. Factory vs Abstract Factory (Quick Difference)

Factory Pattern:
Creates one type of object.

Abstract Factory:
Creates families of related objects.

Example:

Factory → Create PricingService
Abstract Factory → Create PricingService + LabelService together

---

# 10. One-Line Summary

Abstract Factory provides a way to create families of related objects without exposing their concrete implementations.

