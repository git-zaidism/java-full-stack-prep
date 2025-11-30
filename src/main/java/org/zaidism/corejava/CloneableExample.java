package org.zaidism.corejava;

class CloneableExample implements Cloneable { // if we remove this market interface from here it will give run time exception
  private final String data;

  public CloneableExample(String data) {
    this.data = data;
  }

  public String getData() {
    return data;
  }

  // If you do not override clone(), calling clone() from within the same class works
  // because Object.clone() is protected and accessible inside the class and its subclasses.

  // If you try to call clone() from another class (like CloningTechniques.java),
  // you get a compile-time error because clone() is not visible (still protected in Object).

  // Overriding clone() and making it public or protected allows access from outside the class.
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
      System.out.println("Original Object Data: " + originalObj.getData()+" - "+originalObj.hashCode());
      System.out.println("Cloned Object Data: " + clonedObj.getData()+" - "+clonedObj.hashCode());
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
  }
}
