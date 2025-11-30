package org.zaidism.oops.inheritance;

class Bird1 {
    void fly() {
        System.out.println("I am a Bird");
    }
}
class Parrot1 extends Bird1 {
    void whatColourAmI() {
        System.out.println("I am green!");
    }
}
class Crow1 extends Bird1 {
    void whatColourAmI() {
        System.out.println("I am black!");
    }
}
class Main {
    public static void main(String args[]) {
        Parrot1 par = new Parrot1();
        Crow1 cro = new Crow1();
        //Call methods of Parrot Class
        par.whatColourAmI();
        par.fly();

        //Call methods of Crow Class
        cro.whatColourAmI();
        cro.fly();
    }
}
