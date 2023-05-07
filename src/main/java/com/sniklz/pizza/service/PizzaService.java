package com.sniklz.pizza.service;

import com.sniklz.pizza.model.Pizza;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PizzaService extends DefaultService<Pizza> {

    Pizza calculateCost(Long id);

    List<Pizza> findAll();

    Set<Pizza> byIngredient(Map<String, String> params);
}
