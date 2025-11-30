package org.zaidism.collection.map;

import java.util.HashMap;

public class HashCollisionExample {
    public static void main(String[] args) {
        HashMap<BadKey, String> map = new HashMap<>();

        map.put(new BadKey("A"), "Value1");
        map.put(new BadKey("B"), "Value2");

        System.out.println(map.get(new BadKey("A"))); // Value1
        System.out.println(map.get(new BadKey("B"))); // Value2
    }
}

class BadKey {
    String key;

    public BadKey(String key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        return 1; // Same hash for all keys!
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof BadKey))
            return false;
        return key.equals(((BadKey) o).key);
    }
}

