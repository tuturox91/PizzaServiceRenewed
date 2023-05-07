package com.sniklz.pizza.renewed.dto.request;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class IngredientRequestDto {
    private String name;
    private BigDecimal cost;
}
