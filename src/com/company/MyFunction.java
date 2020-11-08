package com.company;
@FunctionalInterface
public interface MyFunction<T,R> {
    /**
     * @param t1
     * @param t2
     */
    public R numberHandler(T t1,T t2);


}
