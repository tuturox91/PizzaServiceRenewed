package com.sniklz.pizzaservicerenewed.service;

import com.sniklz.pizzaservicerenewed.model.Pizza;

public interface PizzaService extends DefaultService<Pizza> {

    Pizza calculateCost(Long id);
}
