package org.zaidism.interviewprograms;

public class Singleton {
  private static volatile Singleton singletonInstance = null;

  private Singleton() {}

  public static Singleton getSingletonInstance() {
    if(singletonInstance == null) {
      synchronized (Singleton.class) {
        if(singletonInstance == null)
          singletonInstance = new Singleton();
      }
    }
    return singletonInstance;
  }
}

class SingletonTest {
  public static void main(String[] args) {

    for (int i = 0; i < 10; i++) {
      Thread thread = new Thread(() -> {
                Singleton singletonInstance = Singleton.getSingletonInstance();
                System.out.println(Thread.currentThread().getName() + " got hashCode of singletonInstance: " + singletonInstance.hashCode());
              });
      thread.start();
    }
  }
}
