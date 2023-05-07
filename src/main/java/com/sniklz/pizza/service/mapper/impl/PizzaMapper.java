package com.sniklz.pizza.service.mapper.impl;

import com.sniklz.pizza.dto.request.PizzaRequestDto;
import com.sniklz.pizza.dto.response.PizzaResponseDto;
import com.sniklz.pizza.model.Pizza;
import com.sniklz.pizza.service.IngredientService;
import com.sniklz.pizza.service.mapper.UniversalMapper;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class PizzaMapper implements UniversalMapper<Pizza, PizzaRequestDto, PizzaResponseDto> {

    private final IngredientService ingredientService;

    public PizzaMapper(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Override
    public Pizza toModel(PizzaRequestDto requestDto) {
        Pizza pizza = new Pizza();
        pizza.setName(requestDto.getName());
        pizza.setDescription(requestDto.getDescription());
        pizza.setIngredients(requestDto.getIngredients()
                .stream()
                .map(ingredientService::get)
                .collect(Collectors.toSet()));
        pizza.setCost(requestDto.getCost());
        return pizza;
    }

    @Override
    public PizzaResponseDto toDto(Pizza pizza) {
        PizzaResponseDto pizzaResponse = new PizzaResponseDto();
        pizzaResponse.setId(pizza.getId());
        pizzaResponse.setName(pizza.getName());
        pizzaResponse.setDescription(pizza.getDescription());
        pizzaResponse.setIngredients(pizza.getIngredients()
                .stream()
                .map(ingredient -> ingredient.getId())
                .collect(Collectors.toSet()));
        pizzaResponse.setCost(pizza.getCost());
        return pizzaResponse;
    }
}
