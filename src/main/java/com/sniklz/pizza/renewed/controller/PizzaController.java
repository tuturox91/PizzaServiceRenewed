package com.sniklz.pizza.renewed.controller;

import com.sniklz.pizza.renewed.dto.request.PizzaRequestDto;
import com.sniklz.pizza.renewed.dto.response.PizzaResponseDto;
import com.sniklz.pizza.renewed.model.Pizza;
import com.sniklz.pizza.renewed.service.PizzaService;
import com.sniklz.pizza.renewed.service.mapper.UniversalMapper;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    private final PizzaService pizzaService;
    private final UniversalMapper<Pizza, PizzaRequestDto, PizzaResponseDto> mapper;

    public PizzaController(
            PizzaService pizzaService, UniversalMapper<Pizza,
                    PizzaRequestDto, PizzaResponseDto> mapper) {
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
        return pizzaService.byIngredient(params)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toSet());
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
