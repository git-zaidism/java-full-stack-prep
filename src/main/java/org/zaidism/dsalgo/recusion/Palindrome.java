package org.zaidism.dsalgo.recusion;

public class Palindrome {
    public static void main(String[] args) {
        String name = "amina";
        System.out.println(isPalindromeString(name, 0, name.length() - 1));
    }

    private static boolean isPalindromeString(String name, int start, int end) {
        if (name.charAt(start) != name.charAt(end))
            return false;

        if (start != end)
            return isPalindromeString(name, start + 1, end - 1);

        return true;
    }
}
