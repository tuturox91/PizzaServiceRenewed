package com.sniklz.pizzaservicerenewed.service.mapper;

public interface UniversalMapper<Model, RequestDTO, ResponseDTO>
        extends RequestMapper<Model, RequestDTO>,
        ResponseMapper<Model, ResponseDTO> {
}
