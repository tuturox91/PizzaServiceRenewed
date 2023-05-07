package com.sniklz.pizza.renewed.service.mapper;

public interface RequestMapper<M, R> {

    M toModel(R requestDto);
}
