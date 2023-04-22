package com.sniklz.pizzaservicerenewed.service.Impl;

import com.sniklz.pizzaservicerenewed.model.Pizza;
import com.sniklz.pizzaservicerenewed.repository.PizzaRepository;
import com.sniklz.pizzaservicerenewed.service.IngredientService;
import com.sniklz.pizzaservicerenewed.service.PizzaService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository repository;
    private final IngredientService ingredientService;

    public PizzaServiceImpl(PizzaRepository repository, IngredientService ingredientService) {
        this.repository = repository;
        this.ingredientService = ingredientService;
    }

    @Override
    public Pizza save(Pizza model) {
       return repository.save(model);
    }

    @Override
    public Pizza get(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Pizza update(Long id, Pizza model) {
        Pizza pizza = model;
        pizza.setId(id);
        return save(pizza);
    }

    @Override
    public Pizza calculateCost(Long id) {
        Pizza pizza = get(id);

        pizza.setCost(
                pizza.getIngredients()
                        .stream()
                        .map(ingredient -> ingredient.getCost())
                        .reduce(BigDecimal.ZERO, (x,y) -> x.add(y)));
        save(pizza);
        return pizza;
    }

}
