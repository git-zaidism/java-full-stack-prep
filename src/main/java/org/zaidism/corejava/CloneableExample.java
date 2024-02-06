package org.zaidism.corejava;

class CloneableExample implements Cloneable { // if we remove this market interface from here it will give run time exception
  private final String data;

  public CloneableExample(String data) {
    this.data = data;
  }

  public String getData() {
    return data;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  public static void main(String[] args) {
    try {
      CloneableExample originalObj = new CloneableExample("Hello, Cloneable!");

      // Cloning
      CloneableExample clonedObj = (CloneableExample) originalObj.clone();

      // Output
      System.out.println("Original Object Data: " + originalObj.getData());
      System.out.println("Cloned Object Data: " + clonedObj.getData());
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
  }
}
