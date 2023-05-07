package com.sniklz.pizzaservicerenewed.service.Impl;

import com.sniklz.pizzaservicerenewed.model.Ingredient;
import com.sniklz.pizzaservicerenewed.model.Pizza;
import com.sniklz.pizzaservicerenewed.repository.IngredientRepository;
import com.sniklz.pizzaservicerenewed.service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository repository;

    public IngredientServiceImpl(IngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ingredient save(Ingredient model) {
        return repository.save(model);
    }

    @Override
    public Ingredient get(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Ingredient update(Long id, Ingredient model) {
        Ingredient ingredient = model;
        ingredient.setId(id);
        return repository.save(ingredient);
    }

    @Override
    public List<Ingredient> findAll() {
        return repository.findAll();
    }

}
