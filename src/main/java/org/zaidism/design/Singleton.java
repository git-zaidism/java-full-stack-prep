package org.zaidism.design;

import java.io.*;
import java.lang.reflect.Constructor;

public class Singleton implements Serializable, Cloneable {
  private static volatile Singleton singletonInstance = null;
  static int time = 0;

  // prevent it from reflection
  private Singleton() throws Exception {
      time++;
    if (singletonInstance != null) {
      throw new Exception("Singleton Object does not support clone.");
    }
      System.out.println("construction called "+ time+ " time ");
  }

  public static Singleton getSingletonInstance() throws Exception {
    if (singletonInstance == null) {
      synchronized (Singleton.class) {
        if (singletonInstance == null) singletonInstance = new Singleton();
      }
    }
    return singletonInstance;
  }

  // to prevent it from cloning
  @Override
  public Singleton clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException("Singleton Object does not support clone.");
  }

  // to prevent it from serializable
  @Serial // optional to use annotation
  protected Object readResolve() {
    return singletonInstance;
  }
}

class SingletonTest {
  public static void main(String[] args) throws Exception {
    // thread safe
    for (int i = 0; i < 10; i++) {
      Thread thread = new Thread(() -> {
          Singleton singletonInstance = null;
          try {
              singletonInstance = Singleton.getSingletonInstance();
          } catch (Exception e) {
              throw new RuntimeException(e);
          }
          System.out.println(Thread.currentThread().getName() + " got hashCode of singletonInstance: " + singletonInstance.hashCode());
              });
      thread.start();
    }

    // Accessing Singleton using regular method
    Singleton singleton1 = Singleton.getSingletonInstance();
    System.out.println("Singleton 1 hashCode: " + singleton1.hashCode());


    // Attempting to access Singleton using reflection
    try {
      Class<?> singletonClass = Class.forName("org.zaidism.design.Singleton");
      Constructor<?> constructor = singletonClass.getDeclaredConstructor();
      constructor.setAccessible(true);
      Singleton singleton2 = (Singleton) constructor.newInstance();
      System.out.println("Singleton 2 hashCode: " + singleton2.hashCode());
    } catch (Exception e) {
      System.out.println("Reflection Exception: " + e.getMessage());
    }

    // Attempting to access Singleton using serialization
    try {
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
      out.writeObject(singleton1);
      out.close();

      ObjectInputStream in = new ObjectInputStream(new FileInputStream("singleton.ser"));
      Singleton singleton3 = (Singleton) in.readObject();
      in.close();
      System.out.println("Singleton 3 hashCode: " + singleton3.hashCode());
    } catch (Exception e) {
      System.out.println("Serialization Exception: " + e.getMessage());
    }

  }
}
