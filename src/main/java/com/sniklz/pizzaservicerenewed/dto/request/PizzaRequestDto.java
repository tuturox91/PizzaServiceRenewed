package com.sniklz.pizzaservicerenewed.dto.request;

import com.sniklz.pizzaservicerenewed.model.Ingredient;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class PizzaRequestDto {
    private String name;
    private String description;
    private Set<Long> ingredients;
    private BigDecimal cost;
}
