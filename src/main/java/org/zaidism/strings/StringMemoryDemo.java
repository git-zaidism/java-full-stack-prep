package org.zaidism.strings;

public class StringMemoryDemo {
    public static void main(String[] args) {
        // 🔹 Stack Memory: Reference variable s1
        // 🔸 Method Area (String Pool): "Zahid" is stored
        String s1 = "Zahid";

        // 🔹 Stack Memory: Reference variable s2
        // Points to the same pooled object "Zahid" (reused)
        String s2 = "Zahid";

         System.out.println("s1 == s2: " + (s1 == s2));           // ✅ true (same object from pool)
        System.out.println("s1.equals(s2): " + s1.equals(s2));   // ✅ true (same content)

        // 🔹 Stack: s3; 🔸 Heap: new String("Zahid") creates a new object (not pooled)
        String s3 = new String("Zahid");

        System.out.println("s1 == s3: " + (s1 == s3));           // ❌ false (different memory)
        System.out.println("s1.equals(s3): " + s1.equals(s3));   // ✅ true (same content)

        // 🔄 Interning s3: returns reference to pooled "Zahid"
        String s4 = s3.intern();

        System.out.println("s1 == s4: " + (s1 == s4));           // ✅ true (both point to pool)

        // ✅ Immutability demo
        // ➤ s1 points to "Zahid", which is in the pool
        // ➤ s1 = s1 + " Quraishi" creates a **new object**
        s1 = s1 + " Quraishi";

        System.out.println("s1 after concat: " + s1);            // Zahid Quraishi (new object)
        System.out.println("s2 (original): " + s2);              // Zahid (unchanged)

        // ❗ Original "Zahid" object is not modified—shows immutability
        // ➤ String = immutable; modification = creation of new object

        // 🧪 Interning concatenated string
        String s5 = s1.intern(); // Adds or fetches "Zahid Quraishi" from pool

        String s6 = "Zahid Quraishi";
        System.out.println("s5 == s6: " + (s5 == s6));           // ✅ true (pooled match)

        System.out.println("----- MUTABLE vs IMMUTABLE -----");

        // ✅ StringBuilder is MUTABLE
        StringBuilder sb = new StringBuilder("Zahid");
        sb.append(" Quraishi"); // Same object is modified
        System.out.println("StringBuilder result: " + sb);       // Zahid Quraishi

        // ✅ StringBuffer is also MUTABLE + Thread-Safe
        StringBuffer sf = new StringBuffer("Zahid");
        sf.append(" Quraishi"); // Same object is modified
        System.out.println("StringBuffer result: " + sf);         // Zahid Quraishi

        // 🔁 But String is IMMUTABLE — modification = new object
        String str = "Zahid";
        String modified = str.concat(" Quraishi");
        System.out.println("Original String: " + str);            // Zahid
        System.out.println("Modified String: " + modified);       // Zahid Quraishi
    }
}
