package org.zaidism.oops.inheritance;

//  Diamond Problem,
//Consider that there is a superclass1 named A, and the A class has a method testMethod(). Consider there is a superclass2 named B, and B class has a method testMethod(),
//which has the same name as class A. Now, lets us suppose that classes A and B are both inherited by a subclass named C. And if testMethod() is called from the subclass C,
//an Ambiguity would arise as the same method is present in both the superclasses.


interface A1 {
    default void testMethod() {
        System.out.println("A");
    }
}

interface B1 {
    default void testMethod() {
        System.out.println("B");
    }
}
// Not possible to inherit classes this way, But for understanding, let us suppose
//class C extends A, B { // com
//    void newMethod() {
//        System.out.println("I am from subclass");
//    }
//}
//class Main {
//    public static void main(String args[]) {
//        C obj = new C();
//        obj.testMethod();
//        // Ambiguity here as it's present in both A and B class
//    }
//}

class A {
    void testMethod() {
        System.out.println("I am from class A");
    }
}

class B {
    void testMethod() {
        System.out.println("I am from class B");
    }
}

class C1 implements A1, B1 {

    @Override // Overriding is must from interfaces
    public void testMethod() {
        A1.super.testMethod();
        B1.super.testMethod();

    }
}

class MultipleInheritanceDemo {
    public static void main(String args[]) {
        C1 obj = new C1();
        obj.testMethod();
    }
}


