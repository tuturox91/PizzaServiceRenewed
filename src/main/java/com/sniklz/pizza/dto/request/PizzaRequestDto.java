package com.sniklz.pizza.dto.request;

import java.math.BigDecimal;
import java.util.Set;
import lombok.Data;

@Data
public class PizzaRequestDto {
    private String name;
    private String description;
    private Set<Long> ingredients;
    private BigDecimal cost;
}
