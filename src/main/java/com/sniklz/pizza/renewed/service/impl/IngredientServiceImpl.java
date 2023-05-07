package com.sniklz.pizza.renewed.service.impl;

import com.sniklz.pizza.renewed.model.Ingredient;
import com.sniklz.pizza.renewed.repository.IngredientRepository;
import com.sniklz.pizza.renewed.service.IngredientService;
import java.util.List;
import org.springframework.stereotype.Service;

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
