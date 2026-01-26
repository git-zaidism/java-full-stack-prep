# Exception Handling in Java

## Practical use of finally block

- Finally can be practically used in a code where we create connection to db and then perform insert/update/delete and if any exception occurs then it should go to catch block and after that we always want to close the db connection that code can be implemented inside finally block.

- System.exit can stop finally block execution.

---

## Exception hierarchy in Java

```
          Object
            |
         Throwable
            |
      ----------------
     |                |
   Error          Exception
     |                |
  --------           ---------------------------------------------------------------
 OutOfMemoryError                      |                                           |
 StackOverflow                      Checked (Exception class)                     Unchecked (RuntimeException)
 (Unchecked)                         |                                                    |
                              -------------                                          ----------------
                             |    IO      |                                          |    Runtime     |
                             |  Exceptions |                                         |   Exceptions   |
                             |(e.g., IOException |                   (e.g., NullPointerException, ArrayIndexOutOfBound, ArithmeticException)
                              SQLException
                              FileNotFoundException)
```

### Key Points:

- `Throwable` is at the top of the hierarchy, acting as the root class after Object.
- `Error` and `Exception` are the main branches.
- `Error` represents severe issues that typically cannot be recovered from caused due to lack of resources.
- `Exception` is further divided into `Checked Exceptions` and `Unchecked Exceptions`.
