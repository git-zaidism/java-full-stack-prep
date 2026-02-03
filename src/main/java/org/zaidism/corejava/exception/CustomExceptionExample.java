package org.zaidism.corejava.exception;

// Define a custom exception class by extending Exception
class CustomException extends Exception {

  // Constructor with a message
  public CustomException(String message) {
    super(message);
  }

  // optional  Constructor with a message and a cause
//  public CustomException(String message, Throwable cause) {
//    super(message, cause);z
//  }
}

public class CustomExceptionExample {
  public static void main(String[] args) throws CustomException {
      // Calling a method that may throw a custom exception
      throw new CustomException("Test my Exception");
  }
}
