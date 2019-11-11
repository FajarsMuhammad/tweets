package com.pattern.abstractfactory;

public interface AbstractFactory<T> {
    T create(String animalType);
}