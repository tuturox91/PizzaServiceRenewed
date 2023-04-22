package com.sniklz.pizzaservicerenewed.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class IngredientResponseDto {
    private long id;
    private String name;
    private BigDecimal cost;
}
