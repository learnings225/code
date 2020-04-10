package com.learn.designpatterns.strategy.afterjava8;

import java.util.function.Function;

public interface Converter<T, U> {
    U from(T t);
    T to(U u);

    Class<T> fromType();
    Class<U> toType();

    static <T,U> Converter<T,U> of(Class<T> fromType, Class<U> toType,
                                   Function<? super T, ? extends U> from,
                                   Function<? super U, ? extends T> to) {
        return new Converter<T, U>(){
            @Override
            public U from(T t) {
                return from.apply(t);
            }

            @Override
            public T to(U u) {
                return to.apply(u);
            }

            @Override
            public Class<T> fromType() {
                return fromType;
            }

            @Override
            public Class<U> toType() {
                return toType;
            }
        };
    }

    static <T, U> Converter<T, U> ofNullable(
            Class<T> fromType,
            Class<U> toType,
            Function<? super T, ? extends U> from,
            Function<? super U, ? extends T> to
    ) {
        return of(
                fromType,
                toType,
                t -> t == null ? null : from.apply(t),
                u -> u == null ? null : to.apply(u)
        );
    }
}
