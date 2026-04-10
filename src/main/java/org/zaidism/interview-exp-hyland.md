## Part 1: System Design & Architecture

1. **Microservices State Management**
   * Why should microservices be designed as stateless? 

2. **Communication Protocols**
   * When should you use synchronous REST API calls, and when is it better to use an asynchronous event streaming platform like Kafka?

3. **Database Selection**
   * What are the primary deciding factors when choosing between a Relational (SQL) and a Non-Relational (NoSQL) database?
   * Why it is said that NoSQL databases scale better is it true? If flase they why?

4. **Spring Boot App Management**
   * Is it possible to hot-reload a Spring Boot application? 
   * If yes, is it considered a good practice to allow hot-reloading in a production environment?

---

## Part 2: Code Review & Refactoring 

**Reference Code:**
```java
public String execute(List<Integer> numbers) {
   if (Objects.isNull(numbers))
       throw new InputMismatchException("Invalid Input type provided.");

   if (numbers.isEmpty())
       return " ";

   StringBuilder result = new StringBuilder();

   for (int num : numbers) {
       if (num % 15 == 0)
           result.append("fizzbuzz ");
       else if (num % 3 == 0)
           result.append("fizz ");
       else if (num % 5 == 0)
           result.append("buzz ");
       else
           result.append(num + " ");
   }

   return result.toString().trim();
}
```

### Technical Questions Based on the Code:

5. **Design Patterns & SOLID Principles**
   * Which design pattern and SOLID principle can be applied to improve this code? 
   * How would you rewrite this method based on those principles?

6. **Microservice Configurability**
   * How would you make the logic in this code configurable within a microservice architecture so that the numbers (3, 5, 15) and operators/outputs ("fizz", "buzz") can be changed dynamically based on business requirements?

7. **Memory Management (`String` vs `StringBuilder`)**
   * Why is `String` not preferred for concatenation inside the loop? 
   * If string immutability is the reason, why is that an issue if the Garbage Collector will eventually clean up the unused memory once the function completes?

8. **Java Streams & Parallel Processing**
   * Why the sequnece/order of above conditions checking matters in the code?
   * How would you convert the above `for` loop to use the Java Streams API?
   * If the number of items in the list increases significantly (e.g., 20,000+), how can you make it more performance-oriented? 
   * *Follow-up:* If you use `parallelStream()`, will it produce a stable/ordered output since multiple threads are processing the list concurrently?

9. **Performance Benchmarking**
   * Strictly in terms of execution speed, which approach will be faster: the traditional `for` loop shown above, or the Streams API?
