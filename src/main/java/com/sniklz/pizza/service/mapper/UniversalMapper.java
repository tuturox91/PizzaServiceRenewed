package com.sniklz.pizza.service.mapper;

public interface UniversalMapper<M, R, O>
        extends RequestMapper<M, R>,
        ResponseMapper<M, O> {
}
