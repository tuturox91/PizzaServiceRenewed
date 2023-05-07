package com.sniklz.pizza.renewed.dto.response;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class IngredientResponseDto {
    private long id;
    private String name;
    private BigDecimal cost;
}
