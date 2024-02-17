package org.zaidism.practice.dsa.string;

public class ReverseSentenceString {
    public static void main(String[] args) {
        String sentence = "coding test is mandatory";
        String[] sentenceArr = sentence.split(" ");
        String[] reverseArr = new String[sentenceArr.length];
        int count = 0;
        for (int i = sentenceArr.length - 1; i >= 0; i--) {
            reverseArr[count] = sentenceArr[i];
            count++;
        }

        String reversedSentence = String.join(" ", reverseArr);
        System.out.println(reversedSentence);
    }
}
