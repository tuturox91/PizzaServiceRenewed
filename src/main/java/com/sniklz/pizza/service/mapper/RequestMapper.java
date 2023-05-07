package com.sniklz.pizza.service.mapper;

public interface RequestMapper<M, R> {

    M toModel(R requestDto);
}
