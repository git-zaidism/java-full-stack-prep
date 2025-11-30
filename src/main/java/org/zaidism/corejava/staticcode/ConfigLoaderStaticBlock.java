package org.zaidism.corejava.staticcode;


//A static block is used for static initialization logic, and it runs only once when the class is loaded.


public class ConfigLoaderStaticBlock {
    static String config;

    ConfigLoaderStaticBlock(){
        System.out.println("Constructor invoked");
    }

    static {
        // load config once when class is loaded
        config = "Loaded from file";
        System.out.println("Static block executed");
    }

    public static void main(String[] args) {
        ConfigLoaderStaticBlock configLoaderStaticBlock = new ConfigLoaderStaticBlock();
        System.out.println("Config: " + config);
    }
}

