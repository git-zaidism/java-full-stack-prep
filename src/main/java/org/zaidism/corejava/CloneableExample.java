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
  protected Object clone() throws CloneNotSupportedException { //not always optional refer this code if we don't override this will get error in this code CloningTechniques.java
    return super.clone();
  }

  public static void main(String[] args) {
    try {
      CloneableExample originalObj = new CloneableExample("Hello, Cloneable!");

      // Cloningv
      CloneableExample clonedObj = (CloneableExample) originalObj.clone();

      // Output
      System.out.println("Original Object Data: " + originalObj.getData()+" - "+originalObj.hashCode());
      System.out.println("Cloned Object Data: " + clonedObj.getData()+" - "+clonedObj.hashCode());
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
  }
}
