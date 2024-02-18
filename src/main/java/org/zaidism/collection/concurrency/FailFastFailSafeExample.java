package org.zaidism.collection.concurrency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastFailSafeExample {
    public static void main(String[] args) {
        // Fail-Fast Example with ArrayList
        CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
        arrayList.add("item1");
        arrayList.add("item2");
        arrayList.add("item3");

        Iterator<String> iterator = arrayList.iterator();
        try {
            while (iterator.hasNext()) {
                String item = iterator.next();
                System.out.println(item);
                // Simulating modification during iteration
                arrayList.add("item4");
            }
        } catch (Exception e) {
            System.out.println("Fail-Fast with ArrayList: " + e);
        }


        // Fail-Fast Example with HashSet
        Set<String> hashSet = new HashSet<>();
        hashSet.add("item1");
        hashSet.add("item2");
        hashSet.add("item3");

        Iterator<String> setIterator = hashSet.iterator();
        try {
            while (setIterator.hasNext()) {
                String item = setIterator.next();
                System.out.println(item);
                // Simulating modification during iteration
                hashSet.add("item4");
            }
        } catch (Exception e) {
            System.out.println("Fail-Fast with HashSet: " + e);
        }

        // Fail-Fast Example with HashMap
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");
        hashMap.put("key3", "value3");

        Iterator<String> mapIterator = hashMap.keySet().iterator();
        try {
            while (mapIterator.hasNext()) {
                String key = mapIterator.next();
                System.out.println(key);
                // Simulating modification during iteration
                hashMap.put("key4", "value4");
            }
        } catch (Exception e) {
            System.out.println("Fail-Fast with HashMap: " + e);
        }
    }
}
