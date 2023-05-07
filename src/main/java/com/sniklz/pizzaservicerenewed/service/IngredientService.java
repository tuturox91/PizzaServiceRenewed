package com.sniklz.pizzaservicerenewed.service;

import com.sniklz.pizzaservicerenewed.model.Ingredient;
import com.sniklz.pizzaservicerenewed.model.Pizza;

import java.util.List;
import java.util.Set;

public interface IngredientService extends DefaultService<Ingredient> {
    List<Ingredient> findAll();


}
