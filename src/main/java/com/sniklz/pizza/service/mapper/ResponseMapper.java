package com.sniklz.pizza.service.mapper;

public interface ResponseMapper<M, R> {
    R toDto(M model);
}
