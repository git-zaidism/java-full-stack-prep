package org.zaidism.design.lld.designpattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public enum SingletonWithEnum {
    GET_INSTANCE;
    public void doSomething() {
        System.out.println("Do something with: "+ GET_INSTANCE.hashCode());
    }

}

class TestSingletonEnum {
    public static void main(String[] args) {
        SingletonWithEnum singletonWithEnum2 = SingletonWithEnum.GET_INSTANCE;
        singletonWithEnum2.doSomething();

        // thread safe
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                SingletonWithEnum singletonWithEnum = null;
                try {
                    singletonWithEnum = SingletonWithEnum.GET_INSTANCE;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " got hashCode of singletonInstance: " + singletonWithEnum.hashCode());
            });
            thread.start();
        }

        // Attempting to access Singleton using reflection
        try {
            Class<?> singletonClass = Class.forName("org.zaidism.design.lld.designpattern.SingletonWithEnum");
            Constructor<?> constructor = singletonClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            SingletonWithEnum singletonWithEnum = (SingletonWithEnum) constructor.newInstance();
            System.out.println("Singleton 2 hashCode: " + singletonWithEnum.hashCode());
        } catch (Exception e) {
            System.out.println("Reflection Exception: " + e.getMessage());
        }

        // Attempting to access Singleton using serialization
        SingletonWithEnum singletonWithEnum = SingletonWithEnum.GET_INSTANCE;

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("singletonWithEnum.ser"));
            out.writeObject(singletonWithEnum);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("singletonWithEnum.ser"));
            SingletonWithEnum singleton3 = (SingletonWithEnum) in.readObject();
            in.close();
            System.out.println("Singleton 3 hashCode: " + singleton3.hashCode());
            System.out.println("singletonWithEnum hashCode: " + singletonWithEnum.hashCode());
        } catch (Exception e) {
            System.out.println("Serialization Exception: " + e.getMessage());
        }

    }
}
