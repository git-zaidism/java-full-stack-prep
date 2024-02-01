package org.zaidism.collection;

import java.util.HashMap;

public class HashMapExample {
  public static void main(String[] args) {
    HashMap<String, Integer> hashMap = new HashMap<>();

    hashMap.put("Jahid", 1);
    hashMap.put("Jahid", 2);
    hashMap.put("Amina", 2);
    hashMap.put("Bob", 3);
    hashMap.put("Cathy", 4);
    hashMap.put("David", 5);

    // Adding a null key
    hashMap.put(null, 6);

    displayHashMapContents(hashMap);
    displayKeys(hashMap);
    displayValues(hashMap);

    System.out.println("Value for Key Amina is: "+hashMap.get("Amina"));

    hashMap.entrySet().forEach(System.out::println);
  }

  private static void displayHashMapContents(HashMap<String, Integer> hashMap) {
    // Iterate through the entry set
    for (HashMap.Entry<String, Integer> entry : hashMap.entrySet()) {
      String key = entry.getKey();
      Integer value = entry.getValue();
      System.out.println("Key: " + key + ", Value: " + value);
    }
  }

  private static void displayValues(HashMap<String, Integer> hashMap) {
    // Iterate through the keys
    for (Integer value : hashMap.values()) {
      System.out.println("Value: " + value);
    }
  }

  private static void displayKeys(HashMap<String, Integer> hashMap) {
    // Iterate through the keys
    for (String key : hashMap.keySet()) {
      System.out.println("Key: " + key);
    }
  }
}
