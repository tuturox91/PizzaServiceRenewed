package com.sniklz.pizza.renewed.service.mapper.impl;

import com.sniklz.pizza.renewed.dto.request.IngredientRequestDto;
import com.sniklz.pizza.renewed.dto.response.IngredientResponseDto;
import com.sniklz.pizza.renewed.model.Ingredient;
import com.sniklz.pizza.renewed.service.mapper.UniversalMapper;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper implements
        UniversalMapper<Ingredient, IngredientRequestDto,
                IngredientResponseDto> {

    @Override
    public Ingredient toModel(IngredientRequestDto requestDto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(requestDto.getName());
        ingredient.setCost(requestDto.getCost());
        return ingredient;
    }

    @Override
    public IngredientResponseDto toDto(Ingredient ingredient) {
        IngredientResponseDto ingredientDto = new IngredientResponseDto();
        ingredientDto.setId(ingredient.getId());
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setCost(ingredient.getCost());
        return ingredientDto;
    }
}
