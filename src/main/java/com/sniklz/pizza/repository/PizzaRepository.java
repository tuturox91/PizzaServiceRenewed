package com.sniklz.pizza.repository;

import com.sniklz.pizza.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends
        JpaRepository<Pizza, Long>, JpaSpecificationExecutor<Pizza> {
}
