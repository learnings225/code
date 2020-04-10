package com.learn.designpatterns.strategy.beforejava8;

public class Main {
    public static void main(String[] args) {
        Converter<String, Integer> c = new HexConverter();
        System.out.println("c.from(\"16\") = " + c.from("16"));
    }
}
