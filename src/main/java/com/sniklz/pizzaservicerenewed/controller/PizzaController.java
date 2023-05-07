package com.sniklz.pizzaservicerenewed.controller;

import com.sniklz.pizzaservicerenewed.dto.request.PizzaRequestDto;
import com.sniklz.pizzaservicerenewed.dto.response.PizzaResponseDto;
import com.sniklz.pizzaservicerenewed.model.Ingredient;
import com.sniklz.pizzaservicerenewed.model.Pizza;
import com.sniklz.pizzaservicerenewed.service.IngredientService;
import com.sniklz.pizzaservicerenewed.service.PizzaService;
import com.sniklz.pizzaservicerenewed.service.mapper.UniversalMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    private final PizzaService pizzaService;
    private final IngredientService ingredientService;
    private final UniversalMapper<Pizza, PizzaRequestDto, PizzaResponseDto> mapper;

    public PizzaController(
            PizzaService pizzaService,
            IngredientService ingredientService, UniversalMapper<Pizza,
                    PizzaRequestDto, PizzaResponseDto> mapper) {
        this.ingredientService = ingredientService;
        this.pizzaService = pizzaService;
        this.mapper = mapper;
    }

    @PostMapping
    public PizzaResponseDto save(@RequestBody PizzaRequestDto requestDto) {
        return mapper.toDto(pizzaService.save(mapper.toModel(requestDto)));
    }

    @GetMapping("/getAll")
    public List<PizzaResponseDto> getAll() {
        return pizzaService.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PizzaResponseDto get(@PathVariable Long id) {
        return mapper.toDto(pizzaService.get(id));
    }

    @GetMapping
    public Set<PizzaResponseDto> byIngredient(@RequestParam Map<String, String> params) {
        return pizzaService.byIngredient(params).stream().map(mapper::toDto).collect(Collectors.toSet());
    }


    @PutMapping("/{id}")
    public PizzaResponseDto update(@PathVariable Long id, @RequestBody PizzaRequestDto requestDto) {
        return mapper.toDto(pizzaService.update(id, mapper.toModel(requestDto)));
    }

    @PostMapping("{id}/cost")
    public PizzaResponseDto calculateCost(@PathVariable Long id) {
        return mapper.toDto(pizzaService.calculateCost(id));
    }

}
