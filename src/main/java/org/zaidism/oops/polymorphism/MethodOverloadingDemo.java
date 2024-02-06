package org.zaidism.oops.polymorphism;

public class MethodOverloadingDemo {

    // Scenario 1: Overloading with different parameter types
    public void display(int num) {
        System.out.println("Displaying integer: " + num);
    }

    public void display(double num) {
        System.out.println("Displaying double: " + num);
    }

    // Scenario 2: Overloading with different number of parameters
    public void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public void greet(String firstName, String lastName) {
        System.out.println("Hello, " + firstName + " " + lastName + "!");
    }

    // Scenario 3: Overloading with different order of parameters
    public void printDetails(String name, int age) {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public void printDetails(int age, String name) {
        System.out.println("Age: " + age + ", Name: " + name);
    }

    // Scenario 4: Overloading with different return types (Not recommended) compilation error
   /* public int add(int a, int b) {
        return a + b;
    }

    public double add(int a, int b) {
        return a + b;
    } */


    // Scenario 5: Overloading static methods
    public static void staticDisplay(String message) {
        System.out.println("Static Display: " + message);
    }

    public static void staticDisplay(String message, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("Static Display " + (i + 1) + ": " + message);
        }
    }

    // Attempt to overload the main method (won't be recognized as an entry point)
    public static void main() {
        System.out.println("Main method without parameter");
    }


    public static void main(String[] args, int additionalParam) {
        System.out.println("Main method with String[] and int parameters");
    }

    public static void main(String[] args) {
        System.out.println("Main method with String[] parameter");
        MethodOverloadingDemo methodOverloadingDemo = new MethodOverloadingDemo();
        methodOverloadingDemo.display(5);
        methodOverloadingDemo.display(5L);
        methodOverloadingDemo.printDetails(23, "Jahid");
        methodOverloadingDemo.printDetails("Jahid", 25);
        methodOverloadingDemo.greet("Jahid");
        methodOverloadingDemo.greet("Jahid", "Quraishi");
        MethodOverloadingDemo.staticDisplay("Hey static method overloaded part 1");
        MethodOverloadingDemo.staticDisplay("Hey static method overloaded part 2", 3);
        methodOverloadingDemo.main();
        String argsTemp[] = {"jahid", "amina"};
        methodOverloadingDemo.main(argsTemp, 2);
        MethodOverloadingDemo.main();

    }
}
