package org.zaidism.collection.list;

import java.util.ArrayList;
import java.util.List;

public class FinalArrayList {
  public static void main(String[] args) {
     final List<Integer> numList = new ArrayList<>(5);
      numList.add(22);
      numList.add(12);
      numList.add(32);
      numList.add(62);
      numList.add(21);
      numList.add(20);

      System.out.println(numList);
     // numList = List.of(2); // reassignment is not allowed with final collection
  }
}
