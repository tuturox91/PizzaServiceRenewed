package com.sniklz.pizzaservicerenewed.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class IngredientRequestDto {
    private String name;
    private BigDecimal cost;
}
