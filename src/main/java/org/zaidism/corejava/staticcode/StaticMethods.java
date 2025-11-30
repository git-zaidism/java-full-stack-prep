package org.zaidism.corejava.staticcode;

//Can be invoked without an object reference, usecase could be Utility or helper functions (e.g., java.util.Collections.sort())
//Stateless operations. Entry points like public static void main(String[]).


class MathUtils {
    public static double toRadians(double degrees) {
        return degrees * Math.PI / 180;
    }
}

public class StaticMethods {
    public static void main(String[] args) {
        System.out.print(MathUtils.toRadians(90));
    }
}
