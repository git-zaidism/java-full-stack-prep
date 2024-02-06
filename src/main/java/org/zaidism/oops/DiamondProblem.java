package org.zaidism.oops;

interface Herbivore {
  default void eat() {
    System.out.println("Herbivore is eating");
  }
}

interface Carnivore {
  default void eat() {
    System.out.println("Carnivore is eating");
  }
}

class DiamondProblem implements Herbivore, Carnivore {

  @Override // commenting this entire method will give compilation error
  public void eat() {
    Carnivore.super.eat();
    Herbivore.super.eat();
  }
    public static void main(String[] args) {
        DiamondProblem diamondProblem = new DiamondProblem();
        diamondProblem.eat();
    }
}

