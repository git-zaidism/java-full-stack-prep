package org.zaidism.corejava;

import java.util.*;

// A base class
class Animal {
    void speak() {
        System.out.println("Animal speaks");
    }
}

// Subclass of Animal
class Dog extends Animal {
    @Override
    void speak() {
        System.out.println("Dog barks");
    }
}

// Subclass of Dog
class Puppy extends Dog {
    @Override
    void speak() {
        System.out.println("Puppy yips");
    }
}

public class WildcardGenericsDemo {

    // Unbounded wildcard: accepts any type
    public static void printAll(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj); // Can only read, not add (except null)
        }
    }

    // Upper bounded wildcard: accepts List of Dog or its subclasses
    public static void feedDogs(List<? extends Dog> dogs) {
        // Can't add: list type might be List<Puppy> or List<Dog>, which can't accept other subtypes
        // dogs.add(new Dog());      // ❌ Compile error
        // dogs.add(new Puppy());    // ❌ Compile error

        for (Dog dog : dogs) {
            dog.speak(); // ✅ Safe to read
        }
    }

    // Lower bounded wildcard: accepts List of Dog or any superclass (like Animal)
    public static void addDogs(List<? super Dog> list) {
        list.add(new Dog());   // ✅ Safe to add Dog
        list.add(new Puppy()); // ✅ Safe to add Puppy (subclass of Dog)

        // Reading is not type-safe here — returns Object
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();
        List<Puppy> puppies = new ArrayList<>();

        dogs.add(new Dog());
        puppies.add(new Puppy());

        System.out.println("1️⃣ Unbounded Wildcard:");
        printAll(dogs); // List<?>

        System.out.println("\n2️⃣ Upper Bounded Wildcard (Producer):");
        feedDogs(dogs);    // List<? extends Dog>
        feedDogs(puppies); // List<? extends Dog>

        System.out.println("\n3️⃣ Lower Bounded Wildcard (Consumer):");
        addDogs(animals);  // List<? super Dog>
        addDogs(dogs);     // List<? super Dog>
        // addDogs(puppies); // ❌ Not allowed, Puppy is not a supertype of Dog
    }
}

