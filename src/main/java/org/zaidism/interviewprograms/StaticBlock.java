package org.zaidism.interviewprograms;

// predict the output
class Test {
  static int i;

  static {
    System.out.println("a");
    i = 100;
  }
}

public class StaticBlock {

  static {
    System.out.println("b");
  }

  // instance block
  {
    System.out.println("instance block");
  }

  public static void main(String[] args) {
    System.out.println("c");
    System.out.println(Test.i);
    StaticBlock staticBlock1 = new StaticBlock();
    StaticBlock staticBlock2 = new StaticBlock();
    StaticBlock staticBlock3 = new StaticBlock();
  }
}
