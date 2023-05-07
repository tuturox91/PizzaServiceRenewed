package com.sniklz.pizzaservicerenewed.controller;

import com.sniklz.pizzaservicerenewed.dto.request.IngredientRequestDto;
import com.sniklz.pizzaservicerenewed.dto.response.IngredientResponseDto;
import com.sniklz.pizzaservicerenewed.dto.response.PizzaResponseDto;
import com.sniklz.pizzaservicerenewed.model.Ingredient;
import com.sniklz.pizzaservicerenewed.service.IngredientService;
import com.sniklz.pizzaservicerenewed.service.mapper.UniversalMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    private final IngredientService ingredientService;
    private final UniversalMapper<Ingredient, IngredientRequestDto, IngredientResponseDto> mapper;

    public IngredientController(
            IngredientService ingredientService,
            UniversalMapper<Ingredient, IngredientRequestDto,
                    IngredientResponseDto> ingredientMapper) {
        this.ingredientService = ingredientService;
        this.mapper = ingredientMapper;
    }

    @PostMapping
    public IngredientResponseDto save(@RequestBody IngredientRequestDto ingredientDto) {
        return mapper.toDto(ingredientService.save(mapper.toModel(ingredientDto)));
    }

    @GetMapping("{id}")
    public IngredientResponseDto getIngredientById(@PathVariable Long id) {
        return mapper.toDto(ingredientService.get(id));
    }

    @GetMapping("/getAll")
    public List<IngredientResponseDto> getAll() {
        return ingredientService.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @PutMapping("{id}")
    public IngredientResponseDto updateIngredient(@PathVariable Long id, @RequestBody IngredientRequestDto requestDto) {
        return mapper.toDto(ingredientService.update(id, mapper.toModel(requestDto)));
    }
}
