package org.zaidism.oops.polymorphism;

class Superclass {
    static void staticMethod() {
        System.out.println("Superclass static method");
    }
}

class Subclass extends Superclass {

   // @Override //this will give error as static methods can't be override
    static void staticMethod() {
        System.out.println("Subclass static method");
    }
}

public class StaticMethodOverrideDemo {
    public static void main(String[] args) {
        Superclass.staticMethod(); // Calls Superclass static method
        Subclass.staticMethod();   // Calls Subclass static method

        // Using references to demonstrate compile-time binding
        Superclass reference = new Subclass();
        reference.staticMethod();  // Calls Superclass static method (compile-time binding)

        //Subclass subclass = new Superclass();// subclass/child reference can't hold the object of parent/super class
        Subclass subclass = new Subclass();
        // subclass. we will not get option to call any method
    }
}

// In the example above, the staticMethod in the Subclass hides the staticMethod in the Superclass.
// However, when using a reference of the superclass to refer to an object of the subclass, the
// compiler binds the call to the superclass's static method at compile time. There is no dynamic
// dispatch, and the actual type of the object is not considered.
//
// In summary, while static methods can be "hidden" by redeclaring them in a subclass, they are not
// overridden in the traditional sense, and the method to be called is determined at compile time
// based on the reference type.
