package com.learn.designpatterns.strategy.afterjava8;

import java.util.stream.Collector;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Converter<String, Integer> converter =
                Converter.ofNullable(
                        String.class,
                        Integer.class,
                        s -> Integer.parseInt(s, 16),
                        Integer::toHexString
                );

        System.out.println(" From Hex to Int:  = " + converter.from("16"));

        // Another example
        for (int i : Stream.of(1, 8, 3, 5, 6, 2, 4, 7)
                .collect(Collector.of(
                        () -> new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE },
                        (a, t) -> {
                            if (a[0] < t) {
                                a[1] = a[0];
                                a[0] = t;
                            }
                            else if (a[1] < t)
                                a[1] = t;
                        },
                        (a1, a2) -> {
                            throw new UnsupportedOperationException(
                                    "Say no to parallel streams");
                        }
                )))
            System.out.println(i);
    }
}
