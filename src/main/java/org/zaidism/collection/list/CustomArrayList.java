package org.zaidism.collection.list;

import java.util.ArrayList;

// custom array list that does not allow duplicate
public class CustomArrayList extends ArrayList {

  @Override
  public boolean add(Object object) {
    if (this.contains(object)) return true;
    else return super.add(object);
  }

  public static void main(String[] args) {
    CustomArrayList customArrayList = new CustomArrayList(); // without generic
    customArrayList.add(1);
    customArrayList.add(2);
    customArrayList.add(1);
    System.out.println(customArrayList);
  }
}
