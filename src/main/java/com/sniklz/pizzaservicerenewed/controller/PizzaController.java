package com.sniklz.pizzaservicerenewed.controller;

import com.sniklz.pizzaservicerenewed.dto.request.PizzaRequestDto;
import com.sniklz.pizzaservicerenewed.dto.response.PizzaResponseDto;
import com.sniklz.pizzaservicerenewed.model.Pizza;
import com.sniklz.pizzaservicerenewed.service.PizzaService;
import com.sniklz.pizzaservicerenewed.service.mapper.UniversalMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pizza")
public class PizzaController {

    private final PizzaService pizzaService;
    private final UniversalMapper<Pizza, PizzaRequestDto, PizzaResponseDto> mapper;

    public PizzaController(
            PizzaService pizzaService,
            UniversalMapper<Pizza,
                    PizzaRequestDto, PizzaResponseDto> mapper) {
        this.pizzaService = pizzaService;
        this.mapper = mapper;
    }

    @PostMapping
    public PizzaResponseDto save(@RequestBody PizzaRequestDto requestDto) {
        return mapper.toDto(pizzaService.save(mapper.toModel(requestDto)));
    }

    @GetMapping("/{id}")
    public PizzaResponseDto get(@PathVariable Long id) {
        return mapper.toDto(pizzaService.get(id));
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
