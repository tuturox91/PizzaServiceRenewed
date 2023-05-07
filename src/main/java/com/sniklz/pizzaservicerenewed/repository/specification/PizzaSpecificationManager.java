package com.sniklz.pizzaservicerenewed.repository.specification;

import com.sniklz.pizzaservicerenewed.model.Pizza;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PizzaSpecificationManager implements SpecificationManager<Pizza> {

    private final Map<String, SpecificationProvider<Pizza>> providersMap;

    public PizzaSpecificationManager(List<SpecificationProvider<Pizza>> pizzaSpecifications) {
        this.providersMap = pizzaSpecifications.stream()
                .collect(Collectors.toMap(SpecificationProvider::getFilterKey, Function.identity()));
    }


    @Override
    public Specification<Pizza> get(String filterKey, String[] params) {
        if(!providersMap.containsKey(filterKey)) {
            throw new RuntimeException("Key" + filterKey + " is not supported for data filtering");
        }
        return providersMap.get(filterKey).getSpecification(params);
    }
}
