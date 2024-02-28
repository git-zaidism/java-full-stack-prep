package org.zaidism.interviewprograms;

import java.util.Stack;

// Given a stack with push(), pop(), and empty() operations, The task is to delete the middle
// element of it without using any additional data structure.
// Input : Stack[] = [1, 2, 3, 4, 5] Output : Stack[] = [1, 2, 4, 5]
// Input : Stack[] = [1, 2, 3, 4, 5, 6] Output : Stack[] = [1, 2, 4, 5, 6]

public class DeleteMiddleElementStack {

  // Function to delete middle element of a stack
  public static void deleteMiddle(Stack<Integer> stack) { // proposed way
    int size = stack.size();
    int mid = size / 2;

    // Create an auxiliary stack
    Stack<Integer> auxStack = new Stack<>();

    // Pop elements from the original stack and push them onto the auxiliary stack until reaching
    // the middle element
    for (int i = 0; i < mid; i++) {
      auxStack.push(stack.pop());
    }

    // Discard the middle element
    stack.pop();

    // Pop elements from the auxiliary stack and push them back onto the original stack
    while (!auxStack.isEmpty()) {
      stack.push(auxStack.pop());
    }
  }

  public static void deleteMiddleV2(Stack<Integer> stack) { // my way
    int size = stack.size();
    int index = size / 2;
    stack.remove(index);
  }

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.push(6);

    System.out.println("Stack before removing middle element: " + stack);

    // Delete middle element
    deleteMiddle(stack);

    System.out.println("Stack after removing middle element: " + stack);
  }
}
