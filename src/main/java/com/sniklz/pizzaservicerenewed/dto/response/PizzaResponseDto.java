package com.sniklz.pizzaservicerenewed.dto.response;

import com.sniklz.pizzaservicerenewed.model.Ingredient;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class PizzaResponseDto {
    private Long id;
    private String name;
    private String description;
    private Set<Long> ingredients;
    private BigDecimal cost;
}
