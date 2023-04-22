package com.sniklz.pizzaservicerenewed.service.mapper.Impl;

import com.sniklz.pizzaservicerenewed.dto.request.IngredientRequestDto;
import com.sniklz.pizzaservicerenewed.dto.response.IngredientResponseDto;
import com.sniklz.pizzaservicerenewed.model.Ingredient;
import com.sniklz.pizzaservicerenewed.service.PizzaService;
import com.sniklz.pizzaservicerenewed.service.mapper.UniversalMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class IngredientMapper implements
        UniversalMapper<Ingredient, IngredientRequestDto,
                IngredientResponseDto> {

    private final PizzaService pizzaService;

    public IngredientMapper(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @Override
    public Ingredient toModel(IngredientRequestDto requestDto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(requestDto.getName());
        ingredient.setCost(requestDto.getCost());
        /*ingredient.setPizzas(requestDto.getPizzasId()
                .stream()
                .map(pizzaService::get)
                .collect(Collectors.toSet()));*/
        return ingredient;
    }

    @Override
    public IngredientResponseDto toDto(Ingredient ingredient) {
        IngredientResponseDto ingredientDto = new IngredientResponseDto();
        ingredientDto.setId(ingredient.getId());
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setCost(ingredient.getCost());
        /*ingredientDto.setPizzasId(ingredient.getPizzas()
                        .stream()
                        .map(pizza -> pizza.getId())
                        .collect(Collectors.toSet()));*/
        return ingredientDto;
    }
}
