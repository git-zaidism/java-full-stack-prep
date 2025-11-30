package org.zaidism.corejava;

import java.io.*;

class SerializableExample implements Serializable {
    private static final long serialVersionUID = 1L; // Required for Serializable optional

    private String data;

    public SerializableExample(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SerializableExample{" +
                "data='" + data + '\'' +
                '}';
    }

    public static void main(String[] args) {
        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serialized_object.ser"))) {
            SerializableExample obj = new SerializableExample("Hello, Serializable!");
            oos.writeObject(obj);
            System.out.println("Object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serialized_object.ser"))) {
            SerializableExample deserializedObj = (SerializableExample) ois.readObject();
            System.out.println(deserializedObj);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
