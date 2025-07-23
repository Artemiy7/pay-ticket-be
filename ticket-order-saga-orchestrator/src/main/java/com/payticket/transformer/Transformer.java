package com.payticket.transformer;

public interface Transformer <T, R> {
    R transform(T t);
}
