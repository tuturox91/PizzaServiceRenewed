package com.sniklz.pizza.renewed.service.mapper;

public interface ResponseMapper<M, R> {
    R toDto(M model);
}
