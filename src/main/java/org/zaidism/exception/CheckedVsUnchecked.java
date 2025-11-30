package org.zaidism.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedVsUnchecked {
    public static void main(String[] args) {
        try { // checked
            Class.forName("kjsdksfd");
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
        }

        String name = null;
        System.out.println(name.length()); // unchecked


        try {
            FileReader file = new FileReader("pom.xml"); // checked

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
