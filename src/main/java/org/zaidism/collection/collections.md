# Internal Working of HashMap

## HashMapExample.java

The average case complexity of insertions, updates, and deletions in a HashMap is O(1). However, in the worst-case scenario, due to collisions leading to long linked lists, the complexity degrades to O(n).

### How the put() Method Works in HashMap

- When you create a HashMap, initially, 16 buckets are formed (indexed from 0 to 15) in the hash table. Once the threshold index value, which is more than 12 in a HashMap, is reached, the bucket size increases. The resizing of the map usually doubles its size from 16 to 32 during debugging.
- Each index in the bucket acts as a linked list/node with the following structure: `[Hashcode|Key|Value|Next]`.
- When the `put()` method of the HashMap is called, the hash function is invoked on the key object to generate the hash code. Based on this hash code, the index for the first entry is calculated using the formula: `hashCode & (n-1)`.
- For example, if the index is calculated as 4, a node is created at this index in the bucket with the value `[12342|Jahid|1|null]`.
- If a second entry is added to the map with the key "Amina", and the hash function calculates the same hash code for the key, resulting in the index being 4 again, this situation is called a hash collision.
- In a hash collision scenario, the `equals` function is applied to both keys to check if they are not equal. If they are not equal, the new entry is added to the existing entry as a linked node: `[12342|Jahid|1|1213x] -> [12342|Amina|2|null]` at index 4 of the bucket.
- If the keys are equal, the existing entry in the map is replaced by the new entry.
- If multiple linked lists are formed within the same index, JVM traverses through the linked list, which is not O(1). To address this issue, HashMap in Java 8 replaces the linked list with a balanced tree (red-black tree) to improve performance when the number of elements in the bucket reaches a certain threshold.
- If null keys are provided in the HashMap, the corresponding entry in the form of a node is always stored at the 0th index in the bucket of the hash table. HashMaps allow only one null key.
- While keys can have a null value, values in a HashMap can also be null.
- When the same key is put into the HashMap again, the existing entry is replaced with the latest one.

### How `get` Method Works in HashMap

- When you use `hashMap.get("Amina")`, the hash function calculates the hashcode for the key "Amina."
- Using the hashcode, an index is determined within the HashMap's internal array of buckets. This index is calculated as `index = hashCode & (n-1)`.
- In the bucket at the calculated index, the HashMap checks if there are one or more entries (nodes) with matching hashcodes.
- If a matching hashcode is found, the `equals` method is used to check which node's key matches the provided key ("Amina").
- If a matching key is found within a node, the `get` method returns the corresponding value associated with that key.

---

## Fail-Fast vs Fail-Safe Iterators

### Fail-Safe

- Fail-safe iterators operate on a copy of the collection instead of the original collection.
- Changes made to the original collection during iteration do not affect the iterator.
- Fail-safe iterators do not throw `ConcurrentModificationException`.
- Instead of relying on mod counts, fail-safe iterators often use mechanisms such as snapshotting (creating a copy of the collection when iteration begins) or maintaining a separate data structure for tracking modifications, ensuring that the iterator can continue iterating over the original collection without interference from concurrent modifications.

### Fail-Fast

- Fail-fast iterators operate directly on the original collection.
- If the collection is modified structurally while iterating (adding, removing), `ConcurrentModificationException` is thrown.
- During iteration, the iterator checks this modification count. If it detects that the count has changed since the iteration began, it indicates that the collection has been modified concurrently, and it throws a `ConcurrentModificationException`.

---

## HashTable vs ConcurrentHashMap

| ConcurrentHashMap                       | HashTable                              |
|----------------------------------------|----------------------------------------|
| Multiple Segments for Concurrency      | Single Global Lock for Synchronization |
| (Divides Map into Segments, Each        |                                        |
| with Independent Lock)                  |                                        |


---

## Why Set Doesn't Allow Duplicate Values?

- In Java, for example, the HashSet implementation of the Set interface uses a HashMap internally to store its elements. When you add an element to a HashSet, it is added as a key in the HashMap, with a dummy value. The uniqueness of keys in a HashMap is enforced by the hashing and equality comparison mechanisms.
- A Set can contain duplicate elements for custom objects if `hashCode` and `equals` methods are not overridden as per their contract.

---

## Can I Add an Element to a Final ArrayList?

- Yes, but we can't re-assign it as shown below; it will give a compilation error:

  ```java
  final List<Integer> nums = new ArrayList<>();
  nums = new ArrayList<>(); // Compilation error
  ```

- To achieve immutability in an ArrayList, we can use `Collections.unmodifiableList` method:

  ```java
  // Creating a regular ArrayList
  List<String> mutableList = new ArrayList<>();
  mutableList.add("apple");
  mutableList.add("banana");
  mutableList.add("orange");

  // Creating an immutable view of the ArrayList
  List<String> immutableList = Collections.unmodifiableList(mutableList);
  ```

- `List.of` method also creates an unmodifiable List.

---

## ArrayList vs LinkedList

- `ArrayList` is suitable for storing and accessing data as it works on an indexed-based search like an array, so these operations are faster.
- `LinkedList` is better suited for manipulating data.

---

## HashMap vs ConcurrentHashMap

- **HashMap**: Not thread-safe, fail-fast, allows storing null keys and values, faster than ConcurrentHashMap.
- **ConcurrentHashMap**: Thread-safe, fail-safe, doesn't allow storing null keys and values, slower than HashMap.

---

## Why Not Use `Collections.synchronizedMap` Instead of `ConcurrentHashMap`?

- If we use `Collections.synchronizedMap(map)`, it will act as a synchronized Hashtable where the locking mechanism is different.

---

## TreeMap vs HashMap

The choice between `TreeMap` and `HashMap` in Java depends on the specific requirements and characteristics of your application. Here are some considerations:

1. **Ordering**:
    - **TreeMap**: Elements are stored in sorted order based on their keys. If you need the elements to be sorted according to the natural order of the keys or a custom comparator, `TreeMap` is the appropriate choice.
    - **HashMap**: Elements are not ordered. If the order of elements is not important or if you need faster insertion, deletion, and retrieval of elements without considering their order, `HashMap` is more suitable.

2. **Performance**:
    - **TreeMap**: Insertion, deletion, and retrieval operations have a time complexity of O(log n) due to the underlying Red-Black Tree structure used for maintaining sorted order. This makes `TreeMap` suitable for scenarios where the number of elements is relatively small or where the need for sorted order outweighs performance concerns.
    - **HashMap**: In general, insertion, deletion, and retrieval operations have an average time complexity of O(1) (constant time). `HashMap` provides better performance for large datasets or scenarios where order is not a concern.

3. **Memory Overhead**:
    - **TreeMap**: Requires additional memory overhead to store the Red-Black Tree structure for maintaining sorted order.
    - **HashMap**: Generally has lower memory overhead compared to `TreeMap` because it doesn't need to maintain any specific order.

4. **Key Immutability**:
    - **TreeMap**: Requires keys to be immutable or at least consistent during the time they are used as keys in the map. This is because the sorting order relies on the keys.
    - **HashMap**: More flexible with key mutability because it doesn't rely on sorting keys.

5. **Custom Sorting**:
    - **TreeMap**: Allows you to specify a custom comparator to define the sorting order of keys.
    - **HashMap**: Doesn't offer built-in support for custom sorting. If you need custom sorting, you would need to sort the keys externally and then perform operations on the map.

In summary:
- Use `TreeMap` when you need elements sorted according to their keys, and the additional overhead and slightly slower performance are acceptable.
- Use `HashMap` when ordering is not important, and you prioritize faster insertion, deletion, and retrieval operations, especially for large datasets.
