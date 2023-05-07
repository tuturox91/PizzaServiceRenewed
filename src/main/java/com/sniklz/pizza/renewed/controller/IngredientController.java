package com.sniklz.pizza.renewed.controller;

import com.sniklz.pizza.renewed.dto.request.IngredientRequestDto;
import com.sniklz.pizza.renewed.dto.response.IngredientResponseDto;
import com.sniklz.pizza.renewed.model.Ingredient;
import com.sniklz.pizza.renewed.service.IngredientService;
import com.sniklz.pizza.renewed.service.mapper.UniversalMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public IngredientResponseDto updateIngredient(
            @PathVariable Long id, @RequestBody IngredientRequestDto requestDto) {
        return mapper.toDto(ingredientService.update(id, mapper.toModel(requestDto)));
    }
}
