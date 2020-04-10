package com.learn.designpatterns.strategy.beforejava8;

public interface Converter<T, U> {
    U from(T t);
    T to(U u);

    Class<T> fromType();
    Class<U> toType();
}