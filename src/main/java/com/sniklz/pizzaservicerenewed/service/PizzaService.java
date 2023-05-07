package com.sniklz.pizzaservicerenewed.service;

import com.sniklz.pizzaservicerenewed.model.Ingredient;
import com.sniklz.pizzaservicerenewed.model.Pizza;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PizzaService extends DefaultService<Pizza> {

    Pizza calculateCost(Long id);
    List<Pizza> findAll();

    Set<Pizza> byIngredient(Map<String, String> params);


//    Set<Pizza> getPizzasByIngredients(Set<Ingredient> ingredients);
}
