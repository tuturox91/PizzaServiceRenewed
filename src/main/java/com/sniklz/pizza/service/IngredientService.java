package com.sniklz.pizza.service;

import com.sniklz.pizza.model.Ingredient;
import java.util.List;

public interface IngredientService extends DefaultService<Ingredient> {
    List<Ingredient> findAll();
}
