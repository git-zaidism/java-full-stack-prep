package org.zaidism.corejava;

import java.util.HashSet;
import java.util.Set;

// run without tostring also to see different classname + hashcode value
public class HashCodeAndEquals {
  public static void main(String[] args) {
    Pen pen1 = new Pen(20, "blue");
    Pen pen2 = new Pen(20, "blue");
    // Pen pen2 = new Pen(20, "black");
    System.out.println(pen1);
    System.out.println(pen2);
    System.out.println(pen1 == pen2);
    System.out.println(pen1.equals(pen2));

    Set<Pen> penSet = new HashSet<>();
    penSet.add(pen1);
    penSet.add(pen2);
    System.out.println(penSet);
  }
}

class Pen {
  int price;
  String color;

  public Pen(int price, String color) {
    this.color = color;
    this.price = price;
  }

//  @Override
//  public String toString() {
//    return "Pen{" + "price=" + price + ", color='" + color + '\'' + '}';
//  }

  @Override
  public boolean equals(Object object) {
    Pen that = (Pen) object;
    return this.price == that.price && this.color.equals(that.color);
  }

  @Override
  public int hashCode() {
    return price + color.hashCode();
  }
}
