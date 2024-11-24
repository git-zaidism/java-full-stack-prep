# Practical Use of `finally` Block

- `finally` can be practically used in a code where we create a connection to the database, perform insert/update/delete operations, and handle any exceptions in the `catch` block. After that, we always want to close the database connection. This code can be implemented inside the `finally` block.

- `System.exit()` can stop the execution of the `finally` block.

---

# Exception Hierarchy in Java

```
          Object
            |
         Throwable
            |
      ----------------
     |                |
   Error          Exception
     |                |
  --------           -------------------------------------------------------------
 OutOfMemoryError                      |                            |
 StackOverflow                      Checked                      Unchecked
 (Unchecked)                         |                              |
                              -------------                 ----------------
                             |    IO      |                  |    Runtime     |
                             |  Exceptions |                 |   Exceptions   |
                             |(e.g., IOException |      (e.g., NullPointerException, ArrayIndexOutOfBound, ArithmeticException)
                              SQLException
                              FileNotFoundException)
```

- `Throwable` is at the top of the hierarchy, acting as the root class after `Object`.
- `Error` and `Exception` are the main branches.
- `Error` represents severe issues that typically cannot be recovered from, caused due to a lack of resources.
- `Exception` is further divided into `Checked Exceptions` and `Unchecked Exceptions`.
