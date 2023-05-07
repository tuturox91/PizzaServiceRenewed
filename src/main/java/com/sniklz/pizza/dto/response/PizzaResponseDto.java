package com.sniklz.pizza.dto.response;

import java.math.BigDecimal;
import java.util.Set;
import lombok.Data;

@Data
public class PizzaResponseDto {
    private Long id;
    private String name;
    private String description;
    private Set<Long> ingredients;
    private BigDecimal cost;
}
