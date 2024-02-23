package org.zaidism.interviewprograms;

public class ReverseSentenceString {
    public static void main(String[] args) {
        String sentence = "coding test is mandatory";
        String[] sentenceArr = sentence.split(" ");
        String[] reverseArr = new String[sentenceArr.length];
        int index = 0;
        for (int i = sentenceArr.length - 1; i >= 0; i--) {
            reverseArr[index] = sentenceArr[i];
            index++;
        }

        String reversedSentence = String.join(" ", reverseArr);
        System.out.println(reversedSentence);
    }
}
