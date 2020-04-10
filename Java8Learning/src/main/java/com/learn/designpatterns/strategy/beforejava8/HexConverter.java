package com.learn.designpatterns.strategy.beforejava8;

public class HexConverter implements Converter<String, Integer> {

    @Override
    public Integer from(String hexString) {
        return hexString == null
                ? null
                : Integer.parseInt(hexString, 16);
    }
    @Override
    public String to(Integer number) {
        return number == null
                ? null
                : Integer.toHexString(number);
    }
    @Override
    public Class<String> fromType() {
        return String.class;
    }
    @Override
    public Class<Integer> toType() {
        return Integer.class;
    }

//    @Override
//    public Integer from(String hexString) {
//        return Optional.ofNullable(hexString)
//                .map(h -> Integer.parseInt(h, 16) )
//                .orElse(-1);
//    }
//
//    @Override
//    public String to(Integer integer) {
//        return Optional.ofNullable(integer)
//                .map(i -> Integer.toHexString(i) )
//                .orElse("");
//    }
//
//    @Override
//    public Class<String> fromType() {
//        return String.class;
//    }
//
//    @Override
//    public Class<Integer> toType() {
//        return Integer.class;
//    }
}
