package com.sniklz.pizzaservicerenewed.service.Impl;

import com.sniklz.pizzaservicerenewed.model.Pizza;
import com.sniklz.pizzaservicerenewed.repository.PizzaRepository;
import com.sniklz.pizzaservicerenewed.repository.specification.SpecificationManager;
import com.sniklz.pizzaservicerenewed.service.IngredientService;
import com.sniklz.pizzaservicerenewed.service.PizzaService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository repository;
    private final SpecificationManager<Pizza> pizzaSpecificationManager;

    public PizzaServiceImpl(PizzaRepository repository, IngredientService ingredientService, SpecificationManager<Pizza> pizzaSpecificationManager) {
        this.repository = repository;
        this.pizzaSpecificationManager = pizzaSpecificationManager;
    }

    @Override
    public Pizza save(Pizza model) {
        Pizza pizza = repository.save(model);
        if(pizza.getCost() == BigDecimal.ZERO || pizza.getCost() == null) {
            calculateCost(pizza.getId());
        }
        return pizza;
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

    @Override
    public List<Pizza> findAll() {
        return repository.findAll();
    }

    @Override
    public Set<Pizza> byIngredient(Map<String, String> params) {
        Specification<Pizza> specification = null;
        for(Map.Entry<String, String> entry : params.entrySet()) {
            Specification<Pizza> sp = pizzaSpecificationManager.get(entry.getKey(),
                    entry.getValue().split(","));
            specification = specification == null ? Specification.where(sp) : specification.and(sp);
        }
        return repository.findAll(specification).stream().collect(Collectors.toSet());
    }

//    @Override
//    public Set<Pizza> getPizzasByIngredients(Set<Ingredient> ingredients) {
//        return repository.getPizzasByIngredients(ingredients);
//    }


}
