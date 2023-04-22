package com.sniklz.pizzaservicerenewed.service.mapper;

public interface ResponseMapper<Model, Response> {
    Response toDto(Model model);
}
