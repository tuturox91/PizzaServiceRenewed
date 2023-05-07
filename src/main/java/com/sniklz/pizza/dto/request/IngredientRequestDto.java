package com.sniklz.pizza.dto.request;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class IngredientRequestDto {
    private String name;
    private BigDecimal cost;
}
