package com.learn.java8.features.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SomeMoreStreams {

    public static void main(String[] args) {
//        Set<Integer> set = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 6, 5));
        Set<Integer> set = Stream.of(10, 1, 2, 3, 4, 6, 5)
                                .collect(Collectors.toSet());

        Stream<Integer> streamFilter = set.stream().filter(e -> e % 2 == 1);
        Stream<Integer> streamFilterNot = set.stream().filter(e -> e % 2 != 0);
        Stream<String> streamMap = set.stream().map(Object :: toString);

        Optional<Integer> findFirst = set.stream().filter(e -> e < 2).findFirst();
        String reduce = streamMap.reduce("", (r, s) -> r + s);
        System.out.println(reduce);

        boolean anyMatch = reduce.chars().anyMatch( c -> c == '2');
        System.out.println("any Match : " + anyMatch);
        boolean allMatch = set.stream().allMatch( c -> c < 5);
        System.out.println("All Match : " + allMatch);

        boolean noneMatch = set.stream().noneMatch(String.class :: isInstance);
        System.out.println("noneMatch = " + noneMatch);
    }
}
