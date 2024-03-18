package org.zaidism.interviewprograms;

import java.util.Arrays;
import java.util.List;

import java.util.Map;
import java.util.stream.Collectors;

public class EvenOddSingleStream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // approach 1
        // Grouping numbers into even and odd categories
        Map<Boolean, List<Integer>> evenOddMap = list.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        // Outputting the result
        System.out.println("EVEN=" + evenOddMap.get(true));
        System.out.println("ODD=" + evenOddMap.get(false));

        // approach 2
        // Grouping numbers into even and odd categories using groupingBy collector
        Map<String, List<Integer>> evenOddMaps = list.stream()
                .collect(Collectors.groupingBy(
                        n -> n % 2 == 0 ? "EVEN" : "ODD"
                ));

        // Outputting the result
        System.out.println(evenOddMaps);
    }
}

