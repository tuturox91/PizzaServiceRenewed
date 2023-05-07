package com.sniklz.pizza.renewed.service;

import com.sniklz.pizza.renewed.model.Pizza;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PizzaService extends DefaultService<Pizza> {

    Pizza calculateCost(Long id);

    List<Pizza> findAll();

    Set<Pizza> byIngredient(Map<String, String> params);
}
