package com.sniklz.pizza.service;

public interface DefaultService<T> {

    T save(T model);

    T get(Long id);

    T update(Long id, T model);
}
