package com.sniklz.pizzaservicerenewed.service.mapper.Impl;

import com.sniklz.pizzaservicerenewed.dto.request.PizzaRequestDto;
import com.sniklz.pizzaservicerenewed.dto.response.PizzaResponseDto;
import com.sniklz.pizzaservicerenewed.model.Pizza;
import com.sniklz.pizzaservicerenewed.service.IngredientService;
import com.sniklz.pizzaservicerenewed.service.mapper.UniversalMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

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
