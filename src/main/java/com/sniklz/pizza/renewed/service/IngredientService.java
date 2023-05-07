package com.sniklz.pizza.renewed.service;

import com.sniklz.pizza.renewed.model.Ingredient;
import java.util.List;

public interface IngredientService extends DefaultService<Ingredient> {
    List<Ingredient> findAll();
}
