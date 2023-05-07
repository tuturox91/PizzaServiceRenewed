package com.sniklz.pizza.repository.specification.pizza;

import com.sniklz.pizza.model.Ingredient;
import com.sniklz.pizza.model.Pizza;
import com.sniklz.pizza.repository.specification.SpecificationProvider;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class PizzaByIngredientNameSpecification implements SpecificationProvider<Pizza> {
    private static final String FILTER_KEY = "ingredientsIds";
    private static final String FIELD_NAME = "name";

    @Override
    public Specification<Pizza> getSpecification(String[] ingredients) {
        return (root, query, cb) -> {
            Join<Pizza, Ingredient> join = root.join("ingredients", JoinType.INNER);
            CriteriaBuilder.In<String> predicate = cb.in(join.get(FIELD_NAME));
            for (String value : ingredients) {
                predicate.value(value);
            }
            return cb.or(predicate, predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}