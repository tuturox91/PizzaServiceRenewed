package com.sniklz.pizzaservicerenewed.service.mapper;

public interface RequestMapper<Model, Request> {

    Model toModel(Request requestDto);
}
