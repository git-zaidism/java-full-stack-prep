package org.zaidism.oops.polymorphism;

class Animal {
  void makeSound() {
    System.out.println("Animal makes a sound");
  }

  Animal() {
    System.out.println("Animal constructor called");
  }
}

class Dog extends Animal {
  @Override
  void makeSound() {
    System.out.println("Dog barks");
  }

  Dog() {
    System.out.println("Dog constructor called");
  }
}

class Cat extends Animal {
  Cat() {
    System.out.println("Cat constructor called");
  }

  @Override // if we comment anyone of override method from dog and cat class it will not give any compilation error instead it will call parent class makeSound method
  void makeSound() {
    System.out.println("Cat meows");
  }
}

public class MethodOverridingDemo {
  public static void main(String[] args) {
    Animal genericAnimal = new Animal();
    Dog myDog = new Dog();
    Cat myCat = new Cat();

    // Scenario 1: Using each class individually
    genericAnimal.makeSound(); // Output: Animal makes a sound
    myDog.makeSound(); // Output: Dog barks
    myCat.makeSound(); // Output: Cat meows

    // Scenario 2: Using polymorphism with superclass reference
    Animal polyDog = new Dog();
    Animal polyCat = new Cat();

    polyDog.makeSound(); // Output: Dog barks (Dynamic method dispatch)
    polyCat.makeSound(); // Output: Cat meows (Dynamic method dispatch)

    // Not allowed as there is no direct relation between these two classes
    // Dog myDog1 = new Cat();
    // Cat myCat1  = new Dog();

    // compilation error as child cannot hold the reference of object class
    // Dog myDog3 = new Animal();
  }
}
