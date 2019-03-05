package com.lckdn.lambdas;

@FunctionalInterface
public interface Transformable<T> {

    T transform(T t);
}
