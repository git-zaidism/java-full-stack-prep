package org.zaidism.temp;


public class Demo {
    public static void main(String[] args) {
        try {
            Class.forName("kjsdksfd");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
